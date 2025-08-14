package com.projects.testdata;

import java.util.HashMap;
import java.util.Map;

public class ProductTestData {

    public static final int EXISTING_PRODUCT_ID = 1;
    public static final int NON_EXISTENT_PRODUCT_ID = 99999;

    public static Map<String, Object> newProductPayload() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "New Test Product");
        payload.put("price", 29.99);
        payload.put("description", "A sample test product.");
        payload.put("image", "https://example.com/product.jpg");
        payload.put("category", "electronics");
        return payload;
    }

    public static Map<String, Object> invalidProductPayload_MissingTitle() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("price", 15.99);
        payload.put("description", "Product without a title");
        payload.put("image", "https://example.com/image.jpg");
        payload.put("category", "electronics");
        return payload;
    }

    public static Map<String, Object> updatedProductPayload() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "Updated Test Product");
        payload.put("price", 35.50);
        payload.put("description", "Updated product description");
        payload.put("image", "https://example.com/updated.jpg");
        payload.put("category", "electronics");
        return payload;
    }
}
