package com.yachay.controllers;

import com.yachay.dtos.CreateCursoDto;
import com.yachay.dtos.CreateCursoUsuarioDto;
import com.yachay.dtos.CursoDto;
import com.yachay.dtos.CursoUsuarioDto;
import com.yachay.responses.ApiResponse;
import com.yachay.services.CursoService;
import com.yachay.services.CursoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/yachay-api")
public class CursoUsuarioController {

    @Autowired
    private CursoUsuarioService cursoUsuarioService;


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/cursousuario/newcursousuario")
    public ApiResponse<CursoUsuarioDto> createCursoUsuario(@RequestBody CreateCursoUsuarioDto createCursoUsuarioDto){
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK),"OK",
                cursoUsuarioService.addCursoUsuario(createCursoUsuarioDto));
    }

}
