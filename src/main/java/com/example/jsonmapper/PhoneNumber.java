package com.example.jsonmapper;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PhoneNumber {
    private String type;
    private String number;
}
