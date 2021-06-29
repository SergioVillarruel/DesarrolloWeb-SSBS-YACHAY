package com.yachay.services;

import com.yachay.dtos.CreateCursoUsuarioDto;
import com.yachay.dtos.CreateMeetingUsuarioDto;
import com.yachay.dtos.MeetingUsuarioDto;

public interface MeetingUsuarioService {
    String addMeetingUsuario(CreateMeetingUsuarioDto createMeetingUsuarioDto);
}
