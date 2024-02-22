package com.app.dtos;

import com.app.entities.enums.DutyStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class IoDetailDTO {

    private Long id;
    private String fName;
    private String lName;

    private String designation;

    private LocalDate joiningDate;

    private LocalDate DOB;

    private String baseEntityUserEmail;

    private DutyStatus dutyStatus;

    private String mobileNo;

    private String stationState;

}
