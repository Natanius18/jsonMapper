package com.example.jsonmapper;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    private LocalDateTime dateOfBirth;
    private boolean isActive;
    private Address address;
    private List<PhoneNumber> phoneNumbers;
    private List<Person> children;
}
