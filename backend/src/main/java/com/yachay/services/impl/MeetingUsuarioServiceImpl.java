package com.yachay.services.impl;

import com.yachay.dtos.CreateMeetingUsuarioDto;
import com.yachay.dtos.CreateReservaDto;
import com.yachay.dtos.MeetingUsuarioDto;
import com.yachay.entities.Meeting_App;
import com.yachay.entities.Meeting_App_Usuario;
import com.yachay.entities.Usuario;
import com.yachay.repositories.MeetingRepository;
import com.yachay.repositories.MeetingUsuarioRepository;
import com.yachay.repositories.UsuarioRepository;
import com.yachay.services.MeetingUsuarioService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MeetingUsuarioServiceImpl implements MeetingUsuarioService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeetingUsuarioServiceImpl.class);

    @Autowired
    private MeetingUsuarioRepository meetingUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MeetingRepository meetingRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    private Meeting_App getMeetingAppById(Long meetingId){
        return meetingRepository.findById(meetingId).orElse(null);

    }

    private Usuario getUsuarioEntityById(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);// Todo Add exception
    }

    @Transactional
    @Override
    public String addMeetingUsuario(CreateMeetingUsuarioDto createMeetingUsuarioDto){
        final Usuario usuario = getUsuarioEntityById(createMeetingUsuarioDto.getUsuario());
        final Meeting_App meeting_app = getMeetingAppById(createMeetingUsuarioDto.getMeeting());

        Meeting_App_Usuario new_MeetingUsuario = new Meeting_App_Usuario();
        new_MeetingUsuario.setUsuario(usuario);
        new_MeetingUsuario.setMeeting_app(meeting_app);

        String locator = generateLocator(usuario,meeting_app);

        try {
            new_MeetingUsuario = meetingUsuarioRepository.save(new_MeetingUsuario);
        }catch (Exception exception) {
            throw new Error("No se pudo crear conexion");// Todo handle error better
        }

        return locator;
    }
    private String generateLocator(final Usuario usuario,final Meeting_App meeting_app){
        return usuario.getNombre() + " " + meeting_app.getNombre();
    }
}
