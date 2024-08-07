package com.example.jsonmapper;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;

}
