package com.app.entities.end_users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.app.entities.Address;
import com.app.entities.BaseEntity;
import com.app.entities.FirstInformationReport;
import com.app.entities.PoliceStation;
import com.app.entities.enums.DutyStatus;
import com.app.entities.enums.GenderEnum;
import com.app.entities.enums.RoleEnum;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Investigating_Officers")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class InvestigatingOfficer extends BaseEntity {

	@Column(length = 30,nullable = false)
	private String officerFirstName;

	@Column(length = 30,nullable = false)
	private String officerLastName;

	@Column(length = 30,nullable = false, unique = true)
	private String mobileNo;

	@Column(length = 20,nullable = false)
	private String designation;

	@Enumerated(EnumType.STRING)
	private GenderEnum gender;

	@Column(length = 30,nullable = false , unique = true)
	private String email;

	@Column(name="date_of_birth")
	private LocalDate DOB;

	@Column(nullable = false)
	private LocalDate joiningDate;

	@Column(columnDefinition="int default '0'")
	private int numberOfCases;

	@Column(columnDefinition="int default '0'")
	private int noOfCasesSolved;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private RoleEnum role;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "addressLine1", column = @Column(name = "officer_address_line_one")),
			@AttributeOverride(name = "addressLine2", column = @Column(name = "officer_address_line_two")),
			@AttributeOverride(name = "district", column = @Column(name = "officer_address_district")),
			@AttributeOverride(name = "state", column = @Column(name = "officer_address_state")),
			@AttributeOverride(name = "country", column = @Column(name = "officer_address_country")),
			@AttributeOverride(name = "pincode", column = @Column(name = "officer_address_pincode")),
	})
	private Address officerAddress;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private DutyStatus dutyStatus;

	@ManyToOne
	@JoinColumn(name = "station_id",nullable = false)
	private PoliceStation station;

	@OneToMany(mappedBy = "investigatingOfficer")
	private List<FirstInformationReport> cases = new ArrayList<>();
}
