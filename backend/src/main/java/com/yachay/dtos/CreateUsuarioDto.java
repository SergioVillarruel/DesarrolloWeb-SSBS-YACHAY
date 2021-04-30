package com.yachay.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateUsuarioDto {
    private String nombre;
    private String rol;
    private String correo;
    private String genero;
    private String contraseña;
    private String fecha_de_nacimiento;
    private String universidad;
}
