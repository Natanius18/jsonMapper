package com.example.jsonmapper;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private boolean isActive;
    private Address address;
    private List<PhoneNumber> phoneNumbers;
    private List<Person> children;
}
