package com.app.entities.end_users;

import com.app.entities.BaseEntity;
import com.app.entities.enums.GenderEnum;
import com.app.entities.enums.RoleEnum;
import com.app.entities.enums.TitleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "secure_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseEntityUsers extends BaseEntity {

        @Column(length = 30,nullable = false, unique = true)
        private String email;

        @Column(length = 100)
        private String password;

        @Column(length = 20, nullable = false)
        @Enumerated(value = EnumType.STRING)
        private RoleEnum role;
}


