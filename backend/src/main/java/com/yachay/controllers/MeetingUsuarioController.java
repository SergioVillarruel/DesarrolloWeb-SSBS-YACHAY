package com.yachay.controllers;

import com.yachay.dtos.CreateMeetingUsuarioDto;
import com.yachay.dtos.CreateReservaDto;
import com.yachay.repositories.MeetingUsuarioRepository;
import com.yachay.responses.ApiResponse;
import com.yachay.services.MeetingUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/yachay-api")
public class MeetingUsuarioController {

    @Autowired
    private MeetingUsuarioService meetingUsuarioService;


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/MeetingAppUsuario/crear")
    public ApiResponse<String> addMeetingUsuario(@RequestBody CreateMeetingUsuarioDto createMeetingUsuarioDto){
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK),"OK",
                meetingUsuarioService.addMeetingUsuario(createMeetingUsuarioDto));
    }
}
