package com.app.entities.end_users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.app.entities.FirstInformationReport;
import com.app.entities.PoliceStation;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Investigating_Officers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvestigatingOfficer extends BaseEntity {

	@Column(length = 20,nullable = false)
	private String designation;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;

	@Column
	private Integer numberOfCases;

	@Column
	private Integer noOfCasesSolved;

	@Column(nullable = false)
	private String dutyStatus;

	@ManyToOne
	@JoinColumn(name = "station_id",nullable = false)
	private PoliceStation station;

	@OneToMany(mappedBy = "investigatingOfficer")
	private List<FirstInformationReport> cases = new ArrayList<>();
}
