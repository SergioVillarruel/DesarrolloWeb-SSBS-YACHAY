package com.yachay.repositories;

import com.yachay.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Override
    Optional<Curso> findById(Long cursoId);

    @Query(value = "select * from curso where id in (select curso_id from curso_usuario where usuario_id = ?1)",nativeQuery = true)
    Optional<Curso> findByUserId(Long UserId);

    Optional<Curso> findByNombre(String nombre);

    //@Query(value = "select * from curso where nombre = ?1", nativeQuery = true)
    //Optional<Curso> findByNombre(String nombre);
}
