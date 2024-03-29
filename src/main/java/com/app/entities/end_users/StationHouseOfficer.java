package com.app.entities.end_users;

import com.app.entities.Address;
import com.app.entities.BaseEntity;
import com.app.entities.PoliceStation;
import com.app.entities.enums.DutyStatus;
import com.app.entities.enums.GenderEnum;
import com.app.entities.enums.RoleEnum;
import com.app.entities.enums.TitleEnum;
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
@AttributeOverride(name = "ID", column = @Column(name = "sho_id"))
public class StationHouseOfficer extends BaseEntity {

    @OneToOne
    @MapsId
    @JoinColumn(name = "sho_id")
    BaseEntityUsers baseEntityUser = new BaseEntityUsers();

    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private TitleEnum title;

    @Column(length = 25,nullable = false)
    private String fName;

    @Column(length = 25,nullable = false)
    private String lName;

    @Column
    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DOB;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private GenderEnum gender;

    @Column(length = 12 ,nullable = false , unique = true)
    private String mobileNo;

    @Column(length = 20)
    private String designation;


//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "addressLine1", column = @Column(name = "officer_address_line_one")),
//            @AttributeOverride(name = "addressLine2", column = @Column(name = "officer_address_line_two")),
//            @AttributeOverride(name = "district", column = @Column(name = "officer_address_district")),
//            @AttributeOverride(name = "state", column = @Column(name = "officer_address_state")),
//            @AttributeOverride(name = "country", column = @Column(name = "officer_address_country")),
//            @AttributeOverride(name = "pincode", column = @Column(name = "officer_address_pincode")),
//    })
//    private Address officerAddress;

    @Column
    private LocalDate joiningDate;

    @Enumerated(EnumType.STRING)
    @Column
    private DutyStatus dutyStatus;

    @OneToOne
    @JoinColumn(name = "station_id",nullable = false)
    private PoliceStation station;

    @ManyToOne
    private SPOfficer spOfficer;
}
