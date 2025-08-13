package com.projects.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.when;

public class GetEndpoint {

    public Response getAllProducts() {
        return when().get("/products");
    }

    public Response getProductById(int id) {
        return when().get("/products/" + id);
    }

    public Response getCategories() {
        return when().get("/products/categories");
    }
}
