package com.app.daos;

import com.app.entities.FirstInformationReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FIRDao extends JpaRepository<FirstInformationReport, Long> {
}
