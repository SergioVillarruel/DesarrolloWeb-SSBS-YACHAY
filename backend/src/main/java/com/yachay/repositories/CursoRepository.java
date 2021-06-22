package com.yachay.repositories;

import com.yachay.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Override
    Optional<Curso> findById(Long cursoId);
}
