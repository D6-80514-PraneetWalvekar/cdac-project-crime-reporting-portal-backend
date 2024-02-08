package com.app.entities.end_users;

import com.app.entities.BaseEntity;
import com.app.entities.PoliceStation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Station_House_Officers")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StationHouseOfficer extends BaseEntity {

    @Column(length = 20,nullable = false)
    private String designation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;

    @Column(nullable = false)
    private String dutyStatus;

    @OneToOne
    private PoliceStation station;
}
