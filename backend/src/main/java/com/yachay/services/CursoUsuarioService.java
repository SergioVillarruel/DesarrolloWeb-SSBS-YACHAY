package com.yachay.services;

import com.yachay.dtos.CreateCursoDto;
import com.yachay.dtos.CreateCursoUsuarioDto;
import com.yachay.dtos.CursoDto;
import com.yachay.dtos.CursoUsuarioDto;
import com.yachay.entities.Curso;
import com.yachay.entities.Curso_Usuario;
import com.yachay.entities.Usuario;
import com.yachay.repositories.CursoUsuarioRepository;

import javax.transaction.Transactional;

public interface CursoUsuarioService {

    CursoUsuarioDto addCursoUsuario(CreateCursoUsuarioDto curso_usuarioDto);
}
