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
   List<Usuario> findAllByCurso(String var1);
   List<Usuario> findByRolIs(String Rol);
   List<Usuario> findByUniversidad(String Universidad);
   Optional<Usuario> findByNombre(String nombre);
   @Query(value = "select portafolio from usuarios where nombre = ?1",nativeQuery = true)
   String findPortafolio(String nombre);


}
