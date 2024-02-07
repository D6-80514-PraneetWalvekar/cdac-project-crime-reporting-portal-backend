package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="complaint")
//@Getter
//@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString(exclude = {"user","statusCode","incidentCode"})
public class Complaint extends BaseEntity {
	
	@Column
	private String incidentDecrip;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate incidentDate; 
	@Column(nullable = true)
	private String suspects;
	@Column(length = 25 , nullable = false)
	private String policeStationId;
	@Column(length = 25 , nullable = false)
	private String incidentPlace;
	@Column(length = 25 , nullable = false)
	private String witness;
	@Column(nullable = true)
	private String additionalInfo;
	@ManyToOne
	@JoinColumn(name = "user_id" , nullable = false)
	private User user;
//	@ManyToOne
//	@JoinColumn(name = "Status_id",nullable = false)
//	private Status statusCode;
//	@ManyToOne
//	@JoinColumn(name = "crime_id",nullable = false)
//	private Crime incidentCode;
}
