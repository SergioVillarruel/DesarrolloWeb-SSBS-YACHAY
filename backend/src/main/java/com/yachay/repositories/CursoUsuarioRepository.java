package com.yachay.repositories;

import com.yachay.entities.Curso;
import com.yachay.entities.Curso_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoUsuarioRepository extends JpaRepository<Curso_Usuario, Long> {

    @Override
    Optional<Curso_Usuario> findById(Long curso_usuadioId);


}
