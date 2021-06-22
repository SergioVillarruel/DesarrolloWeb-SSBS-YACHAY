package com.yachay.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateCursoDto {
    private String nombre;
    private String universidad;
    private Integer ciclo;
}
