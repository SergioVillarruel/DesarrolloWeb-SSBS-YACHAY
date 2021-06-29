package com.yachay.repositories;

import com.yachay.entities.Meeting_App_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingUsuarioRepository extends JpaRepository<Meeting_App_Usuario,Long> {
}
