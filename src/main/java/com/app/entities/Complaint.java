package com.app.entities;

import java.time.LocalDate;

import javax.persistence.*;

import com.app.entities.end_users.Citizen;
import org.springframework.format.annotation.DateTimeFormat;


import com.app.entities.end_users.Citizen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="complaints")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Complaint extends BaseEntity{

	@Column
	private String incidentDescription;

	private LocalDate incidentDate;

	@Column
	private String suspects;

	@ManyToOne
	private PoliceStation policeStation;

	@Column(length = 25 , nullable = false)
	private String incidentPlace;

	@Column(length = 25 , nullable = false)
	private String witness;

	@Column
	private String additionalInfo;

	@Column
	private boolean isFIR = false;

	
	@ManyToOne
	@JoinColumn(name = "citizen_id")
	private Citizen citizen;

	public Complaint(String incidentDescription, LocalDate incidentDate, String suspects, PoliceStation policeStation, String incidentPlace, String witness, String additionalInfo, boolean isFIR, Citizen citizen) {
		this.incidentDescription = incidentDescription;
		this.incidentDate = incidentDate;
		this.suspects = suspects;
		this.policeStation = policeStation;
		this.incidentPlace = incidentPlace;
		this.witness = witness;
		this.additionalInfo = additionalInfo;
		this.isFIR = isFIR;
		this.citizen = citizen;
	}
}
