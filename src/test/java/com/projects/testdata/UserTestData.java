package com.projects.testdata;

import java.util.HashMap;
import java.util.Map;

public class UserTestData {

    public static Map<String, Object> validUserPayload() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", "john@gmail.com");
        payload.put("username", "johnd");
        payload.put("password", "m38rmF$");

        Map<String, String> name = new HashMap<>();
        name.put("firstname", "John");
        name.put("lastname", "Doe");
        payload.put("name", name);

        Map<String, Object> address = new HashMap<>();
        address.put("city", "kilcoole");
        address.put("street", "7835 new road");
        address.put("number", 3);
        address.put("zipcode", "12926-3874");

        Map<String, String> geolocation = new HashMap<>();
        geolocation.put("lat", "-37.3159");
        geolocation.put("long", "81.1496");
        address.put("geolocation", geolocation);

        payload.put("address", address);
        payload.put("phone", "1-570-236-7033");

        return payload;
    }

    public static Map<String, Object> invalidUserPayload_MissingFields() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "incompleteUser");
        return payload;
    }

    public static Map<String, Object> updatedUserPayload() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", "updatedemail@gmail.com");
        payload.put("username", "updateduser");
        payload.put("password", "newPass123");
        return payload;
    }

    public static Map<String, Object> fakeUserPayload() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", "fake@gmail.com");
        payload.put("username", "fakeuser");
        payload.put("password", "fakePass");
        return payload;
    }
}
