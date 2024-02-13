package com.app.dtos;

import com.app.entities.Address;
import com.app.entities.enums.DutyStatus;
import com.app.entities.enums.GenderEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter @Setter
public class SHOPostDTO {
    private String fName;

    private String lName;

    private Integer age;

    private LocalDate DOB;

    private GenderEnum gender;

    private String email;

    private String mobileNo;
    private String designation;

    private LocalDate joiningDate;

    private DutyStatus dutyStatus;

    private String policeStation;

    private Address officerAddress;
}
