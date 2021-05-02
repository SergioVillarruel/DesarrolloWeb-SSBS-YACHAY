package com.yachay.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(
        name="reserva"
)

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reserva {

    @Id
    @SequenceGenerator(
            name="reserva_sequence",
            sequenceName = "reserva_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reserva_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(
            name="fecha",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime fecha;



    @ManyToOne
    @JoinColumn(
            name = "alumno_id",
            nullable=false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "alumno_fk"
            )
    )
    private Usuario alumno;

    @ManyToOne
    @JoinColumn(
            name = "tutor_id",
            nullable=false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "tutor_fk"
            )
    )
    private Usuario tutor;
}
