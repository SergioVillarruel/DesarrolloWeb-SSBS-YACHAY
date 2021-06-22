package com.yachay.dtos;

import com.yachay.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class ReservaDto {
    private Long id;
    private Long alumno;
    private Long tutor;
    private LocalDateTime fecha;
}
