package com.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(name = "address_line_one")
    private String addressLine1;

    @Column(name = "address_line_two")
    private String addressLine2;

    @Column(length = 30)
    private String district;

    @Column(length = 30)
    private String state;

    @Column(length = 30)
    private String country;

    @Column(length = 7)
    private String pincode;

}
