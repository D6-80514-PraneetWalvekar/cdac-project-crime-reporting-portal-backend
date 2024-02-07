package com.app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class complaintsDTO {

    private String complainant;
    private String incidentDescription;
    private LocalDate incidentDate;
    private String suspects;
    private String incidentPlace;
    private String witness;
    private String additionalInfo;
    private boolean isFIR;
}
