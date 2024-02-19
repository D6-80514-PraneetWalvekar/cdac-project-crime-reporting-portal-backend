package com.app.daos;

import com.app.entities.FirstInformationReport;
import com.app.entities.PoliceStation;
import com.app.entities.end_users.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FIRDao extends JpaRepository<FirstInformationReport, Long> {
    List<FirstInformationReport> findByComplaint_Citizen(Citizen citizen);
    List<FirstInformationReport> findByInvestigatingOfficer_Station(PoliceStation station);
}
