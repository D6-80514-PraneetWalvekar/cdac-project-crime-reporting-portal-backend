package com.app.dtos;

import com.app.entities.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IOupdateComplaintDTO {
    private String remark;
    private StatusEnum statusEnum;
}
