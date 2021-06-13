package com.yachay.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String correo;
    private String rol;
    private String universidad;
    private LocalDate fecha_de_nacimiento;
    private String genero;
    private String imagen;
    private String portafolio;
}
