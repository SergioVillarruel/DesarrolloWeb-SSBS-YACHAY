package com.yachay.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name="meeting_app_usuario"
)

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Meeting_App_Usuario {
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
            name = "meeting_app_id",
            nullable=false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "usuario_logro_fk"
            )
    )
    private Meeting_App meeting_app;
}
