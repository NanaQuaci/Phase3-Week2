package com.projects.endpoints;

import com.projects.base.BaseTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutEndpoint extends BaseTest {

    public Response updateProduct(int id, Object productPayload) {
        return given()
                .spec(requestSpec)
                .body(productPayload)
                .when()
                .put("/products/" + id);
    }
}
