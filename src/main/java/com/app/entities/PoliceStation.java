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

	@Column(length = 50)
	private String address;

	@Column(length = 50)
	private String district;

	@Column(length = 50)
	private String state;

	@Column(length = 50)
	private String pincode;


	@OneToOne(mappedBy = "station")
	private StationHouseOfficer sho;

	@OneToMany(mappedBy = "station" )
	private List<InvestigatingOfficer> ioOfficers = new ArrayList<>();

	@OneToMany(mappedBy = "policeStation" )
	private List<Complaint> complaints = new ArrayList<>();

	@ManyToOne
	private SPOfficer spOfficer;
}
