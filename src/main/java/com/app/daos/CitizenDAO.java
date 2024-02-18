package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.end_users.Citizen;

import java.util.Optional;

@Repository
public interface CitizenDAO extends JpaRepository<Citizen, Long> {
    Optional<Citizen> findByBaseEntityUserEmail(String email);
}
