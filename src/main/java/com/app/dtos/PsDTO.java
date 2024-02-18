package com.app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PsDTO {

    private String address;

    private String district;

    private String state;

    private String pincode;
}
