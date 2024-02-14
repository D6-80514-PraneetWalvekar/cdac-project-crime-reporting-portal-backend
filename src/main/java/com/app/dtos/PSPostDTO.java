package com.app.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PSPostDTO {
    private String policeStationAddressAddressline1;
    private String policeStationAddressAddressline2;

    private String policeStationAddressDistrict;
    private String policeStationAddressState;
    private String policeStationAddressCountry;

    private String policeStationAddressPincode;
}
