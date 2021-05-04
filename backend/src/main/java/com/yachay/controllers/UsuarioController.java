package com.yachay.controllers;

import com.yachay.dtos.CreateUsuarioDto;
import com.yachay.dtos.LoginUsuarioDto;
import com.yachay.dtos.UsuarioDto;
import com.yachay.entities.Usuario;
import com.yachay.responses.ApiResponse;
import com.yachay.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/yachay-api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios/{usuarioId}")
    public ApiResponse<UsuarioDto> getUsuarioById(@PathVariable Long usuarioId) {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                usuarioService.findUsuarioById(usuarioId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios/register")
    public ApiResponse<UsuarioDto> createUsuario(@RequestBody CreateUsuarioDto createUsuarioDto) {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                usuarioService.registerUsuario(createUsuarioDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios/login")
    public ApiResponse<UsuarioDto> loginUsuario(@RequestBody LoginUsuarioDto loginUsuarioDto) {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                usuarioService.loginUsuario(loginUsuarioDto));
    }

   // @ResponseStatus(HttpStatus.OK)
    //@PostMapping("/usuarios/recoverContrasenia")
    //public ApiResponse<UsuarioDto> findRegistro(@PathVariable Long usuarioID){
    //    return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
    //            usuarioService.findContraseñabyEmail(usuarioID));
    //}

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios/{usuarioCurso}")
    public ApiResponse<UsuarioDto> findAllByCurso(@PathVariable String usuarioCurso){
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                usuarioService.findAllUsuarioByCurso(usuarioCurso));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios/{usuarioId}")
    public ApiResponse<UsuarioDto> editUsuario(@PathVariable Long usuarioId,@RequestBody CreateUsuarioDto new_data){
        return new ApiResponse<UsuarioDto>("Success", String.valueOf(HttpStatus.OK), "OK",
                usuarioService.editUsuario(usuarioId,new_data));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios/{rol}")
    public ApiResponse<UsuarioDto> getUsuarioById(@PathVariable String rol) {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                usuarioService.findAllUsuariosByRol(rol));
    }
}
