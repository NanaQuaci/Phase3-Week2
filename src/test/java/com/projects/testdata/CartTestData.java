package com.projects.testdata;

import org.json.JSONArray;
import org.json.JSONObject;

public class CartTestData {
    public static final int EXISTING_CART_ID = 1;
    public static final int TEST_USER_ID = 5;

    public static JSONArray sampleProductList() {
        JSONObject product1 = new JSONObject();
        product1.put("productId", 1);
        product1.put("quantity", 2);

        JSONArray productsArray = new JSONArray();
        productsArray.put(product1);
        return productsArray;
    }

    public static JSONArray updatedProductList() {
        JSONObject product1 = new JSONObject();
        product1.put("productId", 2);
        product1.put("quantity", 5);

        JSONArray productsArray = new JSONArray();
        productsArray.put(product1);
        return productsArray;
    }
}
