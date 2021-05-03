package com.yachay.repositories;

import com.yachay.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
   //Todo add exception
   Optional<Usuario> findById(Long usuarioId);
   Optional<Usuario> findByCorreoAndContraseña(String correo, String contraseña);

   Optional<Usuario> findUserbyContrasenia(Long usuarioId);

}
