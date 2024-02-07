package com.app.entities.end_users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.entities.Complaint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"complaints"})
@Entity
@Table(name = "citizen")
public class Citizen extends BaseEntity {

	@Column(length = 30,nullable = false)
	private String fatherName;

	@Column(length = 100, nullable = false)
	private String address;

	@Column(length = 14 ,nullable = false , unique = true)
	private String aadhaarNo;

	@Column(length = 25)
	private String occupation;

	@OneToMany(mappedBy ="citizen", cascade = CascadeType.ALL,orphanRemoval = true)
	List<Complaint> complaints = new ArrayList<>();

}
