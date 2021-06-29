package com.yachay.services;

import com.yachay.dtos.*;
import com.yachay.entities.Usuario;
import com.yachay.jsons.usuarioRest;

import java.time.LocalDateTime;
import java.util.List;

public interface UsuarioService {
    //Todo add exceptions
    UsuarioDto findUsuarioById(Long usuarioId);
    UsuarioDto registerUsuario(CreateUsuarioDto createUsuarioDto);
    UsuarioDto loginUsuario(LoginUsuarioDto loginUsuarioDto);
    //UsuarioDto findContraseñabyEmail(Long usuarioId);
    List<UsuarioDto> findAllUsuarioByCurso(String Nombre);
    UsuarioDto editUsuario(Long usuarioId, EditUsuarioDto new_datos);
    List<usuarioRest> findAllUsuarioByRol(String Rol);
    UsuarioDto editarImagen(Long usuarioId,String imagen);
    List<UsuarioDto> findByUniversidad(String Universidad);
    UsuarioDto editarPortafolio(Long usuarioId,String portafolio);
    UsuarioDto findByNombre(String nombre);
    String findPortafolio(String nombre);

}
