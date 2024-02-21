package com.app.dtos;

import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmailDTO {
	@Email(message = "Invalid email format")
	private String email;
}
