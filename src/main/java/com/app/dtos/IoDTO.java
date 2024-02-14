package com.app.dtos;

import com.app.entities.PoliceStation;
import com.app.entities.enums.DutyStatus;
import com.app.entities.enums.RoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class IoDTO {

    private String fName;
    private String lName;

    private String designation;

    private LocalDate joiningDate;

    private Integer numberOfCases;
    private Integer noOfCasesSolved;
}
