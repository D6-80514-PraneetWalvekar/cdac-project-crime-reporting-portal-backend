package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "user")
public class User extends BaseEntity {
	
	@Enumerated(EnumType.STRING)
	@Column(length = 5)
	private TitleEnum title;
	@Column(length = 25,nullable = false)
	private String name;
	@Column(length = 25,nullable = false)
	private String fatherName; 
	@Column
	private String address;//---------------------------------------
	@Column(length = 30,nullable = false, unique = true)
	private String email;
	@Column(length = 12 ,nullable = false , unique = true)
	private String mobileNo;
	@Column(length = 14 ,nullable = false , unique = true)
	private String addharNo;
	@Column(nullable = false )
	private int age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate DOB;
	@Column(length = 30)
	private String currentAddress; //--------------------------------
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private GenderEnum gender;
	@Column(length = 25)
	private String occupation;
	@OneToMany(mappedBy ="user", cascade = CascadeType.ALL,orphanRemoval = true)
	List<Complaint> complaints = new ArrayList<Complaint>();
//	@Column(length = 20)
//	private String language;
	
	
}
