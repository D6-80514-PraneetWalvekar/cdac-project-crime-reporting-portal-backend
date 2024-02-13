package com.app.entities.end_users;


import com.app.entities.PoliceStation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SP_Officers")
@Getter @Setter
public class SPOfficer extends BaseEntityUsers {
    @OneToMany(mappedBy = "spOfficer")
    List<PoliceStation> policeStations = new ArrayList<>();
    @OneToMany(mappedBy = "spOfficer")
    List<StationHouseOfficer> stationHouseOfficers = new ArrayList<>();


}
