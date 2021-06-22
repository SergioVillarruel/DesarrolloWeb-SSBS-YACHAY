package com.yachay.services;

import com.yachay.dtos.CreateReservaDto;
import com.yachay.dtos.ReservaDto;

import java.time.LocalDateTime;

public interface ReservaService {
    ReservaDto createReserva(CreateReservaDto createReservaDto);
}
