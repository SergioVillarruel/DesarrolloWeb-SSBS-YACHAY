package com.yachay.repositories;

import com.yachay.entities.Meeting_App;
import com.yachay.entities.Meeting_App_Usuario;
import com.yachay.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting_App,Long> {
    @Override
    Optional<Meeting_App> findById(Long MeetingId);
}
