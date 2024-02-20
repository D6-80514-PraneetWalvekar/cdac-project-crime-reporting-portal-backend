package com.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TransferDTO {
    private String shoOneEmail;
    private String psTwoAddress;


    private String shoTwoEmail;
    private String psOneAddress;
}
