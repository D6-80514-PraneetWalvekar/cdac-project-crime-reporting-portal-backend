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
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "ID", column = @Column(name = "io_id"))
public class InvestigatingOfficer extends BaseEntity {

	@OneToOne
	@MapsId
	@JoinColumn(name = "io_id")
	BaseEntityUsers baseEntityUser;

	@Enumerated(EnumType.STRING)
	@Column(length = 5)
	private TitleEnum title;

	@Column(length = 25,nullable = false)
	private String fName;

	@Column(length = 25,nullable = false)
	private String lName;

	@Column
	private Integer age;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate DOB;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private GenderEnum gender;

	@Column(length = 12 ,nullable = false , unique = true)
	private String mobileNo;

	@Column(length = 20)
	private String designation;

	@Column
	private LocalDate joiningDate;

//	@Column(columnDefinition="int default '0'")
//	private Integer numberOfCases;
//
//	@Column(columnDefinition="int default '0'")
//	private Integer noOfCasesSolved;

	@Enumerated(EnumType.STRING)
	@Column
	private DutyStatus dutyStatus;

	@ManyToOne
	@JoinColumn(name = "station_id",nullable = false)
	private PoliceStation station;

	@OneToMany(mappedBy = "investigatingOfficer")
	private List<FirstInformationReport> cases = new ArrayList<>();

}
