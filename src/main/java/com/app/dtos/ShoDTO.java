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

    private String officerFirstName;

    private String officerLastName;

    private int age;

    private LocalDate DOB;

    private GenderEnum gender;

    private String email;

    private String mobileNo;
    private String designation;

    private LocalDate joiningDate;

    private String dutyStatus;

    private String policeStation;

    private Address officerAddress;
}
