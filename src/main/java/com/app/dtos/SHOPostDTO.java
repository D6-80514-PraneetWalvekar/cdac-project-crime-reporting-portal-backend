package com.app.dtos;

import com.app.entities.Address;
import com.app.entities.enums.GenderEnum;

import java.time.LocalDate;

public class SHOPostDTO {
    private String fName;

    private String lName;

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
