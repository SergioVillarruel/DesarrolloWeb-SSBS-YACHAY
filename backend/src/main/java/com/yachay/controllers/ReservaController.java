package com.yachay.controllers;

import com.yachay.dtos.CreateReservaDto;
import com.yachay.dtos.ReservaDto;
import com.yachay.responses.ApiResponse;
import com.yachay.services.ReservaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/yachay-api")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/reserva/crearReserva")
    public ApiResponse<String> crearReserva(@RequestBody CreateReservaDto createReservaDto){
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK),"OK",
                reservaService.createReserva(createReservaDto));
    }
}
