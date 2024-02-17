package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.app.entities.end_users.Citizen;
import com.app.entities.enums.StatusEnum;

@Entity
@Table(name = "bogus_complaints")
public class BogusComplaints {
	
	@javax.persistence.Id
	@Column(unique = true , nullable = false)
	private Long Id;
	@Column
	private String incidentDescription;
	@Column
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

	@Enumerated(EnumType.STRING)
	@Column
	private StatusEnum status ;

	@ManyToOne
	@JoinColumn(name = "citizen_id")
	private Citizen citizen;
}
