package com.app.daos;

import com.app.entities.end_users.SPOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SPDao extends JpaRepository<SPOfficer, Long> {
}
