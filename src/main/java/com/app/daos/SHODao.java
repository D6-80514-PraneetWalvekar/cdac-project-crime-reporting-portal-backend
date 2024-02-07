package com.app.daos;

import com.app.entities.end_users.StationHouseOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SHODao extends JpaRepository<StationHouseOfficer, Long> {
}
