package com.yachay.services;

import com.yachay.dtos.CreateCursoDto;
import com.yachay.dtos.CursoDto;

public interface CursoService {

    CursoDto createCurso(CreateCursoDto createCursoDto);

    CursoDto findByNombre(String nombre);
}
