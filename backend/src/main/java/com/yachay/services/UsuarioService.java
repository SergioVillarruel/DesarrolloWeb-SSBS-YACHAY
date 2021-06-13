package com.yachay.services;

import com.yachay.dtos.CreateUsuarioDto;
import com.yachay.dtos.LoginUsuarioDto;
import com.yachay.dtos.UsuarioDto;
import com.yachay.entities.Usuario;
import com.yachay.jsons.usuarioRest;

import java.util.List;

public interface UsuarioService {
    //Todo add exceptions
    UsuarioDto findUsuarioById(Long usuarioId);
    UsuarioDto registerUsuario(CreateUsuarioDto createUsuarioDto);
    UsuarioDto loginUsuario(LoginUsuarioDto loginUsuarioDto);
    //UsuarioDto findContraseñabyEmail(Long usuarioId);
    UsuarioDto findAllUsuarioByCurso(String Nombre);
    UsuarioDto editUsuario(Long usuarioId, CreateUsuarioDto new_datos);
    List<usuarioRest> findAllUsuarioByRol(String Rol);
    UsuarioDto editarImagen(Long usuarioId,String imagen);
    List<UsuarioDto> findByUniversidad(String Universidad);
    UsuarioDto editarPortafolio(Long usuarioId,String portafolio);
    UsuarioDto findPortafolio(String nombre);
}
