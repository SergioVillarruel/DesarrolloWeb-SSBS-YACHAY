package com.yachay.repositories;

import com.yachay.entities.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Override
    Optional<Reserva> findById(Long usuarioId);
}
