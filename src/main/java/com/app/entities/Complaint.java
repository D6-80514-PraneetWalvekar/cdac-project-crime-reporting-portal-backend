package com.app.entities;

import java.time.LocalDate;

import javax.persistence.*;

import com.app.entities.end_users.Citizen;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="complaints")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Complaint{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long complaintId;
	
	@Column
	private String incidentDescription;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
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

	@ManyToOne
	@JoinColumn(name = "citizen_id" , nullable = false)
	private Citizen citizen;

	@Column
	private boolean isFIR = false;

}
