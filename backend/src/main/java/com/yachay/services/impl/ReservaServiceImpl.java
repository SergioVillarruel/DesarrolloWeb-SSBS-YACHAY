package com.yachay.services.impl;

import com.yachay.dtos.CreateReservaDto;
import com.yachay.dtos.ReservaDto;
import com.yachay.entities.Reserva;
import com.yachay.entities.Usuario;
import com.yachay.repositories.ReservaRepository;
import com.yachay.repositories.UsuarioRepository;
import com.yachay.services.ReservaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public class ReservaServiceImpl implements ReservaService {


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
    public ReservaDto createReserva(CreateReservaDto createReservaDto){

        final Usuario alumnoID = getUsuarioEntityById(createReservaDto.getAlumnoID());

        final Usuario tutorID = getUsuarioEntityById(createReservaDto.getTutorID());

        Reserva reserva = new Reserva();
        reserva.setAlumno(alumnoID);
        reserva.setTutor(tutorID);
        reserva.setFecha(createReservaDto.getFecha());


        try {
            reserva = reservaRepository.save(reserva);
        } catch (Exception exception) {
            throw new Error("No se pudo crear reserva");// Todo handle error better
        }

        return modelMapper.map(getReservaEntityById(reserva.getId()), ReservaDto.class);
    }
}
