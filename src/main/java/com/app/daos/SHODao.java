package com.app.daos;

import com.app.entities.end_users.StationHouseOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SHODao extends JpaRepository<StationHouseOfficer, Long> {
    Optional<StationHouseOfficer> findByBaseEntityUserEmail(String email);
}
