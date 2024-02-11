package com.app.dtos;

import java.time.LocalDate;

import javax.persistence.AccessType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.entities.enums.GenderEnum;
import com.app.entities.enums.TitleEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CitizenGetDTO {
	
	private TitleEnum title;
	
	private Long Id;
	@NotBlank(message = " required!")
	private String fName;
	@NotBlank(message = " required!")
	private String lName;
	
	private GenderEnum gender;
	@NotBlank(message = " required!")
	private LocalDate DOB;
	@NotBlank(message = "required!")
	private String mobileNo;
	@NotBlank(message = "required!")
	private String addharNo;
	private String occupation;
	@NotBlank(message = "required!")
	private int age;
	@NotBlank(message = "Email required!")
	@Email(message = "Invalid Email Format")
	private String email;
	@NotBlank(message = "required!")
	private String fatherName;
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank(message = "Required!")
	private String password;
	
	
}
