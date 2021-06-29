package com.yachay.services.impl;

import com.yachay.dtos.*;
import com.yachay.entities.Curso;
import com.yachay.entities.Curso_Usuario;
import com.yachay.entities.Reserva;
import com.yachay.entities.Usuario;
import com.yachay.repositories.CursoRepository;
import com.yachay.repositories.ReservaRepository;
import com.yachay.repositories.UsuarioRepository;
import com.yachay.services.CursoService;
import com.yachay.services.UsuarioService;
import com.yachay.jsons.usuarioRest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.ColorType;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public UsuarioDto findUsuarioById(Long usuarioId) {
        return modelMapper.map(getUsuarioEntityById(usuarioId), UsuarioDto.class);
    }

   // @Override
    //public UsuarioDto findContraseñabyEmail(Long usuarioId){
    //    return modelMapper.map(getContraseñaByCorreo(usuarioId), UsuarioDto.class);
    //}

    @Override
    public List<UsuarioDto> findAllUsuarioByCurso(String Nombre) {
        Curso curso = cursoRepository.findByNombre(Nombre).orElse(null);
        final  List<Usuario> usuarioEntity = usuarioRepository.findAllByCursoId(curso.getId());
        return usuarioEntity.stream().map(service -> modelMapper.map(service, UsuarioDto.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioDto editUsuario(Long usuarioId, EditUsuarioDto new_datos){
        Usuario perfil = getUsuarioEntityById(usuarioId);

        perfil.setContraseña(new_datos.getContraseña());
        perfil.setCorreo(new_datos.getCorreo());
        perfil.setGenero(new_datos.getGenero());
        perfil.setNombre(new_datos.getNombre());
        perfil.setFecha_de_nacimiento(toLocalDate(new_datos.getFecha_de_nacimiento()));
        perfil.setRol(new_datos.getRol());
        perfil.setTarifa(new_datos.getTarifa());

        try {
            perfil = usuarioRepository.save(perfil);
        } catch (Exception exception) {
            throw new Error("No se pudo crear usuario");// Todo handle error better
        }

        return modelMapper.map(getUsuarioEntityById(perfil.getId()),UsuarioDto.class);
    }

    @Transactional
    @Override
    public UsuarioDto registerUsuario(CreateUsuarioDto createUsuarioDto) {
        Usuario new_usuario = new Usuario();
        new_usuario.setNombre(createUsuarioDto.getNombre());
        new_usuario.setCorreo(createUsuarioDto.getCorreo());
        new_usuario.setContraseña(createUsuarioDto.getContraseña());
        new_usuario.setUniversidad(createUsuarioDto.getUniversidad());
        new_usuario.setGenero(createUsuarioDto.getGenero());
        new_usuario.setRol(createUsuarioDto.getRol());
        new_usuario.setFecha_de_nacimiento(toLocalDate(createUsuarioDto.getFecha_de_nacimiento()));

        try {
            new_usuario = usuarioRepository.save(new_usuario);
        } catch (Exception exception) {
            throw new Error("No se pudo crear usuario");// Todo handle error better
        }

        return modelMapper.map(getUsuarioEntityById(new_usuario.getId()), UsuarioDto.class);
    }

    @Override
    public  UsuarioDto editarImagen(Long usuarioId,String imagen){
        Usuario perfil = getUsuarioEntityById(usuarioId);
        perfil.setImagen(imagen);
        try {
            perfil = usuarioRepository.save(perfil);
        } catch (Exception exception) {
            throw new Error("No se pudo guardar la imagen");// Todo handle error better
        }

        return modelMapper.map(getUsuarioEntityById(perfil.getId()),UsuarioDto.class);
    }

    @Override
    public  UsuarioDto editarPortafolio(Long usuarioId,String portafolio){
        Usuario perfil = getUsuarioEntityById(usuarioId);
        perfil.setPortafolio(portafolio);
        try {
            perfil = usuarioRepository.save(perfil);
        } catch (Exception exception) {
            throw new Error("No se pudo guardar el link");// Todo handle error better
        }

        return modelMapper.map(getUsuarioEntityById(perfil.getId()),UsuarioDto.class);
    }

    @Override
    public UsuarioDto loginUsuario(LoginUsuarioDto loginUsuarioDto) {
        return modelMapper.map(getUsuarioEntity(loginUsuarioDto.getCorreo(), loginUsuarioDto.getContraseña()), UsuarioDto.class);
    }

    private LocalDate toLocalDate(String strFecha) {
       return LocalDate.parse(strFecha);
    }

    private Usuario getUsuarioEntityById(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);// Todo Add exception
    }

    private Usuario getUsuarioEntity(String correo, String contraseña) {
        return usuarioRepository.findByCorreoAndContraseña(correo, contraseña).orElse(null);// Todo Add exception
    }

    //private Usuario getContraseñaByCorreo(Long usuarioID){
   //     return  usuarioRepository.findPasswordbyEmail(usuarioID).orElse(null);
    //}

    @Override
    public List<usuarioRest> findAllUsuarioByRol(String Rol) {

        final List<Usuario> usuarioEntity = usuarioRepository.findByRolIs(Rol);
        return usuarioEntity.stream().map(service -> modelMapper.map(service, usuarioRest.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDto> findByUniversidad(String universidad){
        final  List<Usuario> usuarioEntity = usuarioRepository.findByUniversidad(universidad);
        return usuarioEntity.stream().map(service -> modelMapper.map(service, UsuarioDto.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioDto findByNombre(java.lang.String nombre){
        return modelMapper.map(usuarioRepository.findByNombre(nombre), UsuarioDto.class);
    }

    @Override
    public String findPortafolio(String nombre){
        return usuarioRepository.findPortafolio(nombre);
    }


}
