package com.projects.endpoints;

import static io.restassured.RestAssured.when;
import io.restassured.response.Response;

public class DeleteEndpoint {

    public Response deleteProduct(int id) {
        return when().delete("/products/" + id);
    }
}
