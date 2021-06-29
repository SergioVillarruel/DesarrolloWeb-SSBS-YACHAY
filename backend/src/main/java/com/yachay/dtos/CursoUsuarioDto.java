package com.yachay.dtos;

import com.yachay.entities.Curso;
import com.yachay.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CursoUsuarioDto {
    private Long id;
    private Integer experiencia;
    private Usuario usuario;
    private Curso curso;
}
