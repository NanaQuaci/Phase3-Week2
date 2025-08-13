package com.projects.endpoints;

import com.projects.base.BaseTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostEndpoint extends BaseTest {

    public Response createProduct(Object productPayload) {
        return given()
                .spec(requestSpec)
                .body(productPayload)
                .when()
                .post("/products");
    }
}
