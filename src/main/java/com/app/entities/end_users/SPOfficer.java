package com.app.entities.end_users;


import com.app.entities.BaseEntity;
import com.app.entities.PoliceStation;
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
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SP_Officers")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "ID", column = @Column(name = "sp_id"))
public class SPOfficer extends BaseEntity {

    @OneToOne
    @MapsId
    @JoinColumn(name = "sp_id")
    BaseEntityUsers baseEntityUser;

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

    @OneToMany(mappedBy = "spOfficer")
    List<PoliceStation> policeStations = new ArrayList<>();

    @OneToMany(mappedBy = "spOfficer")
    List<StationHouseOfficer> stationHouseOfficers = new ArrayList<>();

    public SPOfficer(BaseEntityUsers baseEntityUser, TitleEnum title, String fName, String lName, Integer age, LocalDate DOB, GenderEnum gender, String mobileNo) {
        this.baseEntityUser = baseEntityUser;
        this.title = title;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.DOB = DOB;
        this.gender = gender;
        this.mobileNo = mobileNo;
    }
}
