package com.yachay.dtos;

import com.yachay.entities.Curso;
import com.yachay.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCursoUsuarioDto {
    private Integer experiencia;
    private Long usuarioId;
    private Long cursoId;
}
