package com.app.dtos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.entities.PoliceStation;
import com.app.entities.end_users.Citizen;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ComplaintDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long complaintId;
	
	@NotBlank(message = "Please provide some Description")
	private String incidentDescription;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate incidentDate;

	private String suspects;

	@NotBlank
	private PoliceStation policeStation;

	@NotBlank
	private String incidentPlace;
	private String witness;
	private String additionalInfo;
	
//	private Citizen citizen;
//	@Column
//	private boolean isFIR = false;
	
}
