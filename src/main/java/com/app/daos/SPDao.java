package com.app.daos;

import com.app.entities.end_users.SPOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SPDao extends JpaRepository<SPOfficer, Long> {
    Optional<SPOfficer> findByBaseEntityUserEmail(String email);
}
