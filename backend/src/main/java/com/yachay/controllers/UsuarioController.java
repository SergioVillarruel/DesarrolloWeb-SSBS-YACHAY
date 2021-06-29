package com.yachay.controllers;

import com.yachay.dtos.*;
import com.yachay.entities.Usuario;
import com.yachay.jsons.usuarioRest;
import com.yachay.responses.ApiResponse;
import com.yachay.services.UsuarioService;
import com.yachay.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/yachay-api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios/id/{usuarioId}")
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
    @GetMapping("/usuarios/curso/{usuarioCurso}")
    public ApiResponse<List<UsuarioDto>> findAllByCurso(@PathVariable String usuarioCurso){
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                usuarioService.findAllUsuarioByCurso(usuarioCurso));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios/edit/{usuarioId}")
    public ApiResponse<UsuarioDto> editUsuario(@PathVariable Long usuarioId,@RequestBody EditUsuarioDto new_data){
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                usuarioService.editUsuario(usuarioId,new_data));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios/rol/{usuarioRol}")
    public ApiResponse<List<usuarioRest>> findAllByRol(@PathVariable String usuarioRol) {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                usuarioService.findAllUsuarioByRol(usuarioRol));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios/editImagen/{usuarioId}")
    public ApiResponse<UsuarioDto> editarImagen(@PathVariable Long usuarioId,@RequestBody String imagen){
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                usuarioService.editarImagen(usuarioId,imagen));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios/editPortafolio/{usuarioId}")
    public ApiResponse<UsuarioDto> editarPortafolio(@PathVariable Long usuarioId,@RequestBody String portafolio){
        return new ApiResponse<UsuarioDto>("Success", String.valueOf(HttpStatus.OK), "OK",
                usuarioService.editarPortafolio(usuarioId,portafolio));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios/universidad/{usuarioUniversidad}")
    public ApiResponse<List<UsuarioDto>> findByUniversidad(@PathVariable String usuarioUniversidad) {
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                usuarioService.findByUniversidad(usuarioUniversidad));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios/findPortafolio/{usuarioNombre}")
    public ApiResponse<String> findPortafolio(@PathVariable String usuarioNombre){
        return new ApiResponse<>("Success", String.valueOf(HttpStatus.OK),
                usuarioService.findPortafolio(usuarioNombre));
    }



}
