package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.app.entities.end_users.InvestigatingOfficer;
import com.app.entities.end_users.SPOfficer;
import com.app.entities.end_users.StationHouseOfficer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Police_Stations")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PoliceStation extends BaseEntity{


	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "addressLine1", column = @Column(name = "police_station_address_line_one")),
			@AttributeOverride(name = "addressLine2", column = @Column(name = "police_station_address_line_two")),
			@AttributeOverride(name = "district", column = @Column(name = "police_station_address_district")),
			@AttributeOverride(name = "state", column = @Column(name = "police_station_address_state")),
			@AttributeOverride(name = "country", column = @Column(name = "police_station_address_country")),
			@AttributeOverride(name = "pincode", column = @Column(name = "police_station_address_pincode")),
	})
	private Address policeStationAddress;
	@OneToOne(mappedBy = "station")
	private StationHouseOfficer sho;

	@OneToMany(mappedBy = "station" )
	private List<InvestigatingOfficer> ioOfficers = new ArrayList<>();

	@OneToMany(mappedBy = "policeStation" )
	private List<Complaint> complaints = new ArrayList<>();

	@ManyToOne
	private SPOfficer spOfficer;

	public PoliceStation(Address policeStationAddress) {
		this.policeStationAddress = policeStationAddress;
	}
}
