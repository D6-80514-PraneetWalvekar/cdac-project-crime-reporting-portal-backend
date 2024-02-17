package com.app.dtos;

import java.time.LocalDate;

import com.app.entities.Address;
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
public class LoginDTO {

	private String email;
	private String password;
	
}
