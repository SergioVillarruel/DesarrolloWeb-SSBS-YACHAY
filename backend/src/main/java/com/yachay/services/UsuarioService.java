package com.yachay.services;

import com.yachay.dtos.CreateUsuarioDto;
import com.yachay.dtos.UsuarioDto;

public interface UsuarioService {
    //Todo add exceptions
    UsuarioDto findUsuarioById(Long usuarioId);
    UsuarioDto registerUsuario(CreateUsuarioDto createUsuarioDto);
}
