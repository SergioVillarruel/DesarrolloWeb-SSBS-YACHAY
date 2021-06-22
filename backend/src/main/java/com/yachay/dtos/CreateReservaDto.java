package com.yachay.dtos;

import com.yachay.entities.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateReservaDto {
    private Long alumnoID;
    private Long tutorID;
    private LocalDateTime fecha;
}
