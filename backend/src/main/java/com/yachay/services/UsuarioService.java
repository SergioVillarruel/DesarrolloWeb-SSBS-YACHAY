package com.yachay.services;

import com.yachay.dtos.CreateUsuarioDto;
import com.yachay.dtos.LoginUsuarioDto;
import com.yachay.dtos.UsuarioDto;
import com.yachay.entities.Usuario;

public interface UsuarioService {
    //Todo add exceptions
    UsuarioDto findUsuarioById(Long usuarioId);
    UsuarioDto registerUsuario(CreateUsuarioDto createUsuarioDto);
    UsuarioDto loginUsuario(LoginUsuarioDto loginUsuarioDto);
    //UsuarioDto findContraseñabyEmail(Long usuarioId);
    UsuarioDto findAllUsuarioByCurso(String Nombre);
    UsuarioDto editUsuario(UsuarioDto usuario, CreateUsuarioDto new_datos);
    UsuarioDto findAllUsuariosByRol(String Rol);
    UsuarioDto recuperarContrasenia(String correo);
}
