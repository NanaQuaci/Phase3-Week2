package com.projects.testdata;

import java.util.HashMap;
import java.util.Map;

public class PostTestData {

    public static Map<String, Object> newProductPayload() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "Automation Test Product");
        payload.put("price", 29.99);
        payload.put("description", "A product created during automation testing");
        payload.put("image", "https://i.pravatar.cc");
        payload.put("category", "electronics");
        return payload;
    }
}
