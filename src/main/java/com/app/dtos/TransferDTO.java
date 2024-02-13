package com.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TransferDTO {
    private Long shoOneID;
    private Long psOneID;
    private Long shoTwoID;
    private Long psTwoID;
}
