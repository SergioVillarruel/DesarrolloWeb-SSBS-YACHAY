package com.yachay.services.impl;


import com.yachay.dtos.CreateCursoDto;
import com.yachay.dtos.CreateCursoUsuarioDto;
import com.yachay.dtos.CursoDto;
import com.yachay.dtos.CursoUsuarioDto;
import com.yachay.entities.Curso;
import com.yachay.entities.Curso_Usuario;
import com.yachay.entities.Usuario;
import com.yachay.repositories.CursoRepository;
import com.yachay.repositories.CursoUsuarioRepository;
import com.yachay.repositories.UsuarioRepository;
import com.yachay.services.CursoService;
import com.yachay.services.CursoUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CursoUsuarioServiceImpl implements CursoUsuarioService {
    @Autowired
    private CursoUsuarioRepository cursoUsuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    private Curso_Usuario getCursoUsuarioById(Long cursoUsuarioId){
        return cursoUsuarioRepository.findById(cursoUsuarioId).orElse(null);
    }

    @Transactional
    @Override
    public CursoUsuarioDto addCursoUsuario(CreateCursoUsuarioDto curso_usuarioDto){
        Curso_Usuario new_curso_usuario = new Curso_Usuario();

        Curso curso = cursoRepository.findById(curso_usuarioDto.getCursoId()).orElse(null);
        Usuario usuario = usuarioRepository.findById(curso_usuarioDto.getUsuarioId()).orElse(null);

        new_curso_usuario.setCurso(curso);
        new_curso_usuario.setUsuario(usuario);
        new_curso_usuario.setExperiencia(curso_usuarioDto.getExperiencia());

        try {
            new_curso_usuario = cursoUsuarioRepository.save(new_curso_usuario);
        } catch (Exception exception) {
            throw new Error("No se pudo crear el curso_usuario");// Todo handle error better
        }
        return modelMapper.map(getCursoUsuarioById(new_curso_usuario.getId()),CursoUsuarioDto.class);
    }
}
