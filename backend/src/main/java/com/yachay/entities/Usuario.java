package com.yachay.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name="usuarios"
)

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @SequenceGenerator(
            name="usuario_sequence",
            sequenceName = "usuario_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usuario_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(
            name="nombre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre;
    @Column(
            name="fecha_de_nacimiento",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDate fecha_de_nacimiento;
    @Column(
            name="rol",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String rol;
    @Column(
            name="correo",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String correo;
    @Column(
            name="contraseña",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String contraseña;

    @Column(
            name="universidad",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String universidad;
    @Column(
            name="genero",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String genero;

    @Column(
            name="imagen"
            //nullable = true,
            //columnDefinition = "TEXT"
    )
    private String imagen;

    @Column(
            name="portafolio"
            //nullable = true,
            //columnDefinition = "TEXT"
    )
    private String portafolio;

    @Column(
            name="tarifa",
            nullable = true
            //columnDefinition = "TEXT"
    )
    private int tarifa;

    @OneToMany(
            mappedBy = "usuario",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Logro_Usuario> logro=new ArrayList<>();

    @OneToMany(
            mappedBy = "usuario",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Curso_Usuario> curso=new ArrayList<>();

    @OneToMany(
            mappedBy = "usuario",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Meeting_App_Usuario> meeting_app=new ArrayList<>();

    @OneToMany(
            mappedBy = "alumno",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Reserva> alumno=new ArrayList<>();

    @OneToMany(
            mappedBy = "tutor",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Reserva> tutor=new ArrayList<>();
}

