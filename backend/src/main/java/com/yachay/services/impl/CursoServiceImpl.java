package com.yachay.services.impl;


import com.yachay.dtos.*;
import com.yachay.dtos.CreateCursoDto;
import com.yachay.dtos.CursoDto;
import com.yachay.entities.Curso;
import com.yachay.entities.Usuario;
import com.yachay.repositories.CursoRepository;
import com.yachay.repositories.ReservaRepository;
import com.yachay.repositories.UsuarioRepository;
import com.yachay.services.CursoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    private Curso getCursoEntityById(Long cursoId) {
        return cursoRepository.findById(cursoId).orElse(null);// Todo Add exception
    }

    @Transactional
    @Override
    public CursoDto createCurso(CreateCursoDto createCursoDto){
        Curso new_curso = new Curso();

        new_curso.setNombre(createCursoDto.getNombre());
        new_curso.setCiclo(createCursoDto.getCiclo());
        new_curso.setUniversidad(createCursoDto.getUniversidad());

        try {
            new_curso = cursoRepository.save(new_curso);
        } catch (Exception exception) {
            throw new Error("No se pudo crear el curso");// Todo handle error better
        }

        return modelMapper.map(getCursoEntityById(new_curso.getId()),CursoDto.class);
    }
}
