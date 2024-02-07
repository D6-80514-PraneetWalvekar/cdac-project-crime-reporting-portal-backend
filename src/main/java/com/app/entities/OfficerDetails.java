package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="officers_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfficerDetails extends BaseEntity {

	
	@Column(length = 30,nullable = false)
	private String officerFirstName;
	@Column(length = 30,nullable = false)
	private String officerLastName;
	@Column(length = 20,nullable = false)
	private String designation;
	@Column(length = 30,nullable = false, unique = true)
	private String mobileNo;
	@Enumerated(EnumType.STRING)
	private GenderEnum gender;
	@Column(length = 30,nullable = false , unique = true)
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate DOB;
	@Column(nullable = true)
	private int numberOfCases;
	@Column(nullable = true)
	private int noOfCasesSolved;
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private RoleEnum role;
	@Column(nullable = false)
	private String dutyStatus;
	@ManyToOne
	@JoinColumn(name = "station_code",nullable = false)
	private policeStation station;
}