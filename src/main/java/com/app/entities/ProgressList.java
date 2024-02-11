package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.entities.end_users.InvestigatingOfficer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Investing_officersJob")
public class ProgressList extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "io_ID",nullable = false)
	private InvestigatingOfficer officerID;

	@OneToOne
	@JoinColumn(name = "complaint_ID",nullable = false)
	private Complaint complaint;

	@Column
	private String remark;

	@Column(length = 25,nullable = false)
	private String status;
//	@ManyToOne
//	@JoinColumn(name = "Crime_type",nullable = false)
//	private CrimeType type;

	@Column
	private String crimeSubType;

	@Column
	private int duration;
}	
