package com.app.dtos;

import com.app.entities.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class ShoDTO {

    private String fName;

    private String lName;

    private int age;

    private LocalDate DoB;

    private Gender gender;

    private String email;

    private String mobileNo;
    private String designation;

    private LocalDate joiningDate;

    private String dutyStatus;

    private String policeStation;
}
