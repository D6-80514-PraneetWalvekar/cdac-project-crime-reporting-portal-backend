package com.app.daos;

import com.app.entities.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliceStationDao extends JpaRepository<PoliceStation, Long> {
}
