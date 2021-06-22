package com.yachay.services.impl;

import com.yachay.dtos.*;
import com.yachay.dtos.CreateReservaDto;
import com.yachay.dtos.ReservaDto;
import com.yachay.entities.Reserva;
import com.yachay.entities.Usuario;
import com.yachay.repositories.ReservaRepository;
import com.yachay.repositories.UsuarioRepository;
import com.yachay.services.ReservaService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class ReservaServiceImpl implements ReservaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservaServiceImpl.class);

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    private Usuario getUsuarioEntityById(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);// Todo Add exception
    }

    private Reserva getReservaEntityById(long reservaID){
        return reservaRepository.findById(reservaID).orElse(null);
    }

    @Transactional
    @Override
    public String createReserva(CreateReservaDto createReservaDto){

        final Usuario alumnoID = getUsuarioEntityById(createReservaDto.getAlumnoID());
        final Usuario tutorID = getUsuarioEntityById(createReservaDto.getTutorID());

        Reserva reserva = new Reserva();

        reserva.setAlumno(alumnoID);
        reserva.setTutor(tutorID);
        reserva.setFecha(createReservaDto.getFecha());

        String locator = generateLocator(alumnoID,tutorID, createReservaDto);


        try {
            reserva = reservaRepository.save(reserva);
        } catch (Exception exception) {
            throw new Error("No se pudo crear reserva");// Todo handle error better
        }



        return locator;
    }

    private String generateLocator(final Usuario alumnoID,final Usuario tutorID, final CreateReservaDto createReservaDto){

        return alumnoID.getNombre() +" "+ tutorID.getNombre() + " " + createReservaDto.getFecha();
    }
}
