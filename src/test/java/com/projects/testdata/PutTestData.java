package com.projects.testdata;

import java.util.HashMap;
import java.util.Map;

public class PutTestData {

    public static Map<String, Object> updatedProductPayload() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "Updated Automation Product");
        payload.put("price", 39.99);
        payload.put("description", "Updated product description via automation test");
        payload.put("image", "https://i.pravatar.cc");
        payload.put("category", "jewelery");
        return payload;
    }
}
