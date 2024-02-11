package com.app.dtos;

import com.app.entities.Address;
import com.app.entities.enums.GenderEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@NoArgsConstructor
public class ShoDTO {

	@NotBlank
    private String fName;
	@NotBlank
    private String lName;

    private int age;

    private LocalDate DoB;

    private GenderEnum gender;
    @NotBlank
    private String email;
    
    private String mobileNo;
    private String designation;
    
    private LocalDate joiningDate;

    private String dutyStatus;

    private String policeStation;
    
    private Address officerAddress;
}
