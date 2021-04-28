package com.yachay.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name="logro_usuario"
)

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Logro_Usuario {
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
            name="fecha_de_logro",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime fecha_de_logro;

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
            name = "logro_id",
            nullable=false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "logro_usuario_fk"
            )
    )
    private Logro logro;

}
