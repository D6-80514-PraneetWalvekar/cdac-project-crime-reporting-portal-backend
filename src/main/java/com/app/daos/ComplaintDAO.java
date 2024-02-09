package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Complaint;

public interface ComplaintDAO extends JpaRepository<Complaint, Long> {

}
