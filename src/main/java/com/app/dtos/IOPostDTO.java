package com.app.dtos;

import com.app.entities.Address;
import com.app.entities.enums.DutyStatus;
import com.app.entities.enums.RoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class IOPostDTO {

        private String fName;
        private String lName;

        private String email;
        private String mobileNo;

        private String designation;

        private LocalDate joiningDate;
        private Address officerAddress;

        private RoleEnum role;
        private DutyStatus dutyStatus;
}
