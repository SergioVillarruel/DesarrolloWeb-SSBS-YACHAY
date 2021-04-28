package com.yachay.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name="curso"
)

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Curso {
    @Id
    @SequenceGenerator(
            name="curso_sequence",
            sequenceName = "curso_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "curso_sequence"
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
            name="universidad",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String universidad;

    @Column(
            name="ciclo",
            nullable = false
    )
    private Integer ciclo;

    @OneToMany(
            mappedBy = "curso",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Curso_Usuario> reservations=new ArrayList<>();

}
