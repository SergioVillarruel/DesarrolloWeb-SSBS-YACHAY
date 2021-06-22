package com.yachay.controllers;

import com.yachay.dtos.CreateCursoDto;
import com.yachay.dtos.CursoDto;
import com.yachay.responses.ApiResponse;
import com.yachay.services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/yachay-api")
public class CursoController {

    @Autowired
    private CursoService cursoService;


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/curso/newcurso")
    public ApiResponse<CursoDto> createCurso(@RequestBody CreateCursoDto createCursoDto){
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK),"OK",
                cursoService.createCurso(createCursoDto));
    }
}
