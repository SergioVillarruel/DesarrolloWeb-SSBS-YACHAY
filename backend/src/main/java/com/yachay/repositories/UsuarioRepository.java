package com.yachay.repositories;

import java.util.List;

import com.yachay.entities.Curso;
import com.yachay.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
   //Todo add exception
   @Override
   Optional<Usuario> findById(Long usuarioId);
   Optional<Usuario> findByCorreoAndContraseña(String correo, String contraseña);
   //Optional<Usuario> findPasswordbyEmail(Long usuarioId);

   List<Usuario> findByRolIs(String Rol);
   List<Usuario> findByUniversidad(String Universidad);
   Optional<Usuario> findByNombre(String nombre);

   @Query(value = "select portafolio from usuarios where nombre = ?1",nativeQuery = true)
   String findPortafolio(String nombre);

   @Query(value = "select * from usuarios where id in (select usuario_id from curso_usuario where curso_id = ?1)",nativeQuery = true)
   List<Usuario> findAllByCursoId(Long cursoId);


}
