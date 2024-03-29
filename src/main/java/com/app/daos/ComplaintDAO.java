package com.app.daos;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Complaint;

@Repository
public interface ComplaintDAO extends JpaRepository<Complaint, Long> {


}
