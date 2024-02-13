package com.app.entities.end_users;


import com.app.entities.PoliceStation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SP_Officers")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class SPOfficer extends BaseEntityUsers {
    @OneToMany(mappedBy = "spOfficer")
    List<PoliceStation> policeStations = new ArrayList<>();

    @OneToMany(mappedBy = "spOfficer")
    List<StationHouseOfficer> stationHouseOfficers = new ArrayList<>();

    public SPOfficer(String fName, String lName, String email, String mobileNo) {
        super(fName, lName, email, mobileNo);
    }
}
