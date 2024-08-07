package com.example.jsonmapper;

import static com.example.jsonmapper.ObjectToJsonMapper.toJson;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class ObjectToJsonMapperTest {


    @Test
    void objectToJsonMapper() throws IllegalAccessException {
        Address address = new Address()
            .setStreetAddress("21 2nd Street")
            .setCity("New York")
            .setState("NY")
            .setPostalCode(null);

        PhoneNumber homePhone = new PhoneNumber()
            .setType("home")
            .setNumber("212 555-1234");

        PhoneNumber officePhone = new PhoneNumber()
            .setType("office")
            .setNumber("646 555-4567");

        Person person = new Person()
            .setFirstName("John")
            .setLastName("Smith")
            .setAge(27)
            .setActive(true)
            .setAddress(address)
            .setPhoneNumbers(List.of(homePhone, officePhone))
            .setChildren(new ArrayList<>());

        String jsonString = toJson(person);

        assertDoesNotThrow(() -> new JSONObject(jsonString));
        System.out.println(jsonString);
    }
}