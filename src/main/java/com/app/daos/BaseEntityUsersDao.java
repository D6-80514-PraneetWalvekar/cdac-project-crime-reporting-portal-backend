package com.app.daos;


import com.app.entities.end_users.BaseEntityUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseEntityUsersDao extends JpaRepository<BaseEntityUsers, Long> {
    Optional<BaseEntityUsers> findByEmail(String email);
}
