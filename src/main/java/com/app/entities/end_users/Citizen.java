package com.app.entities.end_users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.app.entities.Address;
import com.app.entities.BaseEntity;
import com.app.entities.Complaint;
import com.app.entities.enums.GenderEnum;
import com.app.entities.enums.TitleEnum;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "citizens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Citizen extends BaseEntityUsers {

	@Column(length = 30,nullable = false)
	private String fatherName;

	@Column(length = 14 ,nullable = false , unique = true)
	private String addharNo;

	@Column(nullable = false )
	private int age;

	@Column(name="data_of_birth")
	private LocalDate DOB;


	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "addressLine1", column = @Column(name = "current_address_line_one")),
			@AttributeOverride(name = "addressLine2", column = @Column(name = "current_address_line_two")),
			@AttributeOverride(name = "district", column = @Column(name = "current_address_district")),
			@AttributeOverride(name = "state", column = @Column(name = "current_address_state")),
			@AttributeOverride(name = "country", column = @Column(name = "current_address_country")),
			@AttributeOverride(name = "pincode", column = @Column(name = "current_address_pincode")),
	})
	private Address currentAddress;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "addressLine1", column = @Column(name = "permanent_address_line_one")),
			@AttributeOverride(name = "addressLine2", column = @Column(name = "permanent_address_line_two")),
			@AttributeOverride(name = "district", column = @Column(name = "permanent_address_district")),
			@AttributeOverride(name = "state", column = @Column(name = "permanent_address_state")),
			@AttributeOverride(name = "country", column = @Column(name = "permanent_address_country")),
			@AttributeOverride(name = "pincode", column = @Column(name = "permanent_address_pincode")),
	})
	private Address permanentAddress;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private GenderEnum gender;
	@Column(length = 25)
	private String occupation;

	@OneToMany(mappedBy ="citizen", cascade = CascadeType.ALL,orphanRemoval = true)
	List<Complaint> complaints = new ArrayList<Complaint>();
	
	public void addUserInComplaint(Complaint newComplaint) {
		this.getComplaints().add(newComplaint);
	}
	
	

}
