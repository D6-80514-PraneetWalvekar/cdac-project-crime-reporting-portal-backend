package com.app.daos;

import com.app.entities.end_users.InvestigatingOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IODao extends JpaRepository<InvestigatingOfficer, Long> {
    Optional<InvestigatingOfficer> findByBaseEntityUserEmail(String email);
}
