package com.yachay.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name="curso_usuario"
)

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Curso_Usuario {
    @Id
    @SequenceGenerator(
            name="logro_usuario_sequence",
            sequenceName = "logro_usuario_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "logro_usuario_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(
            name="experiencia",
            nullable = false
    )
    private Integer experiencia;

    @ManyToOne
    @JoinColumn(
            name = "usuario_id",
            nullable=false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "usuario_logro_fk"
            )
    )
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(
            name = "curso_id",
            nullable=false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "Curso_usuario_fk"
            )
    )
    private Curso curso;
}
