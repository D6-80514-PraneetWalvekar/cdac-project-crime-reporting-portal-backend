package com.app.entities.end_users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import com.app.entities.Address;
import com.app.entities.BaseEntity;
import com.app.entities.FirstInformationReport;
import com.app.entities.PoliceStation;
import com.app.entities.enums.DutyStatus;
import com.app.entities.enums.GenderEnum;
import com.app.entities.enums.RoleEnum;
import com.app.entities.enums.TitleEnum;
import org.springframework.aop.IntroductionInterceptor;
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
public class InvestigatingOfficer extends BaseEntityUsers {


	@Column(length = 20)
	private String designation;
	@Column
	private LocalDate joiningDate;

	@Column(columnDefinition="int default '0'")
	private Integer numberOfCases;

	@Column(columnDefinition="int default '0'")
	private Integer noOfCasesSolved;

	@Enumerated(EnumType.STRING)
	@Column
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
	@Column
	private DutyStatus dutyStatus;

	@ManyToOne
	@JoinColumn(name = "station_id",nullable = false)
	private PoliceStation station;

	@OneToMany(mappedBy = "investigatingOfficer")
	private List<FirstInformationReport> cases = new ArrayList<>();

	public InvestigatingOfficer(String fName, String lName, String email, String mobileNo, PoliceStation station) {
		super(fName, lName, email, mobileNo);
		this.station = station;
	}
}
