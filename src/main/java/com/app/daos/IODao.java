package com.app.daos;

import com.app.entities.end_users.InvestigatingOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IODao extends JpaRepository<InvestigatingOfficer, Long> {
}
