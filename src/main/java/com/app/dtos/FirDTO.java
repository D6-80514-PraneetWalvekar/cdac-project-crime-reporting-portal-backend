package com.app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter @Setter
@NoArgsConstructor
public class FirDTO {

    private Long complaintId;
    private String complaintPoliceStationAddress;
    private String complaintCitizenFName;
    private String complaintIncidentDescription;
    private LocalDate complaintIncidentDate;
    private String complaintSuspects;
    private String complaintIncidentPlace;
    private String complaintWitness;
    private String complaintAdditionalInfo;
    private String remark;
    private String status;
    private String investigatingOfficerFName;
}
