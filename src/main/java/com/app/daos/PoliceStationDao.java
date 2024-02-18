package com.app.daos;

import com.app.entities.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PoliceStationDao extends JpaRepository<PoliceStation, Long> {
    Optional<PoliceStation> findPoliceStationByAddress(String address);

}
