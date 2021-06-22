package com.yachay.controllers;

import com.yachay.dtos.CreateReservaDto;
import com.yachay.dtos.ReservaDto;
import com.yachay.responses.ApiResponse;
import com.yachay.services.ReservaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

public class ReservaController {
    @Autowired
    private ReservaService reservaService;


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/reserva/crearReserva")
    public ApiResponse<ReservaDto> crearReserva(@RequestBody CreateReservaDto createReservaDto){
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK),"OK",
                reservaService.createReserva(createReservaDto));
    }
}
