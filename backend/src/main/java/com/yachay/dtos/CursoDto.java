package com.yachay.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CursoDto {
    private Long id;
    private String nombre;
    private String universidad;
    private Integer ciclo;
}
