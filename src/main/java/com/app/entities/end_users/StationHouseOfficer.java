package com.app.entities.end_users;

import com.app.entities.Address;
import com.app.entities.BaseEntity;
import com.app.entities.PoliceStation;
import com.app.entities.enums.DutyStatus;
import com.app.entities.enums.GenderEnum;
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

    @Column(length = 30,nullable = false)
    private String officerFirstName;

    @Column(length = 30,nullable = false)
    private String officerLastName;

    @Column(length = 30,nullable = false, unique = true)
    private String mobileNo;

    @Column(length = 20,nullable = false)
    private String designation;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(length = 30,nullable = false , unique = true)
    private String email;

    @Column(name="date_of_birth")
    private LocalDate DOB;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "officer_address_line_one")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "officer_address_line_two")),
            @AttributeOverride(name = "district", column = @Column(name = "officer_address_district")),
            @AttributeOverride(name = "state", column = @Column(name = "officer_address_state")),
            @AttributeOverride(name = "country", column = @Column(name = "officer_address_country")),
            @AttributeOverride(name = "pincode", column = @Column(name = "officer_address_pincode")),
    })
    private Address officerAddress;

    @Column(nullable = false)
    private LocalDate joiningDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DutyStatus dutyStatus;

    @OneToOne
    @JoinColumn(name = "station_id",nullable = false)
    private PoliceStation station;

}
