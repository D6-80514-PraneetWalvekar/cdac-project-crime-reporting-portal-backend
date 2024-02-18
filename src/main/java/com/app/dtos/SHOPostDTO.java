package com.app.dtos;

import com.app.entities.Address;
import com.app.entities.enums.DutyStatus;
import com.app.entities.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class SHOPostDTO {
    private String fName;

    private String lName;

    private Integer age;

    private LocalDate DOB;

    private GenderEnum gender;

    private String baseEntityUserEmail;
    private String baseEntityUserPassword;

    private String mobileNo;
    private String designation;

    private LocalDate joiningDate;

    private DutyStatus dutyStatus;

    private String policeStation;

}
