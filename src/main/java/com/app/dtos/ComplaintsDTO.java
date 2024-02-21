package com.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ComplaintsDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String complainant;
    private String incidentDescription;
    private LocalDate incidentDate;
    private String suspects;
    private String incidentPlace;
    private String witness;
    private String additionalInfo;
    private boolean isFIR;
}
