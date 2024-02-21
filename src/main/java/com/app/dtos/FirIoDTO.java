package com.app.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class FirIoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String complaintCitizenFName;
    private String complaintIncidentDescription;
    private LocalDate complaintIncidentDate;
    private String complaintSuspects;
    private String complaintIncidentPlace;
    private String complaintWitness;
    private String complaintAdditionalInfo;

    private String remark;
    private String status;
}
