package com.app.dtos;

import java.time.LocalDate;

import javax.persistence.AccessType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.entities.Address;
import com.app.entities.enums.GenderEnum;
import com.app.entities.enums.RoleEnum;
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

	private Long Id ;
	private String baseEntityUserFName;
	private String baseEntityUserLName;
	@Email(message = "Invalid Email!!!")
	private String baseEntityUserEmail;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String baseEntityUserPassword;
	private RoleEnum baseEntityUserRole;

	private String baseEntityUserMobileNo;
	private GenderEnum baseEntityUserGender;
	private LocalDate baseEntityUserDOB;
	private Integer baseEntityUserAge;

	private String fatherName;
	private String aaddharNo;
	private String occupation;
	
	private TitleEnum baseEntityUserTitle;

}
