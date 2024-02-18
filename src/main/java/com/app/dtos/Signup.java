package com.app.dtos;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.entities.enums.GenderEnum;
import com.app.entities.enums.RoleEnum;
import com.app.entities.enums.TitleEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Signup {

	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	@Email(message = "Invalid Email!!!")
	private String baseEntityUserEmail;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String baseEntityUserPassword;

	private TitleEnum title;
	private String fName;
	private String lName;
	private Integer age;
	private LocalDate DOB;
	private GenderEnum gender;
	private String mobileNo;
	private String fatherName;
	private String aaddharNo;
	private String occupation;

	
	
}
