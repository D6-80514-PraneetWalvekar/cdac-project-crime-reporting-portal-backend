package com.app.dtos;

import com.app.entities.Address;
import com.app.entities.enums.DutyStatus;
import com.app.entities.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class IOPostDTO {

        private String fName;
        private String lName;

        private String baseEntityUserEmail;
        private String baseEntityUserPassword;

        private String mobileNo;

        private String designation;

        private LocalDate joiningDate;

        private DutyStatus dutyStatus;
}
