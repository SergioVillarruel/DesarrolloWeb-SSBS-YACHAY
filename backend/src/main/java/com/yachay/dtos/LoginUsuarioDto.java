package com.yachay.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUsuarioDto {
    private String correo;
    private String contraseña;
}
