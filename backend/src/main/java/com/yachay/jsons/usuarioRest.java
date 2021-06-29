package com.yachay.jsons;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class usuarioRest {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("fecha_de_nacimiento")
    private LocalDate fecha_de_nacimiento;

    @JsonProperty("rol")
    private String rol;

    @JsonProperty("correo")
    private String correo;

    @JsonProperty("contraseña")
    private String contraseña;

    @JsonProperty("universidad")
    private String universidad;

    @JsonProperty("genero")
    private String genero;

    @JsonProperty("imagen")
    private  String imagen;

    @JsonProperty("portafolio")
    private String portafolio;





}
