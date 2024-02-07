package com.app.daos;

import com.app.entities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintDao extends JpaRepository<Complaint, Long> {
}
