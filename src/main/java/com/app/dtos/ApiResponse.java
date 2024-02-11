package com.app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class ApiResponse {
    LocalDate timeStamp;
    String message;

    public ApiResponse(String message) {
        this.message = message;
        timeStamp = LocalDate.now();
    }
}
