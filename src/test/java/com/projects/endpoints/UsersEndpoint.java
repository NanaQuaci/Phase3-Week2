package com.projects.endpoints;

import com.projects.tests.base.BaseTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UsersEndpoint extends BaseTest {

    public Response createUser(Object userPayload) {
        return given()
                .spec(requestSpec)
                .body(userPayload)
                .when()
                .post("/users");
    }

    public Response getAllUsers() {
        return when()
                .get("/users");
    }

    public Response getUserById(int id) {
        return when()
                .get("/users/" + id);
    }

    public Response updateUser(int id, Object userPayload) {
        return given()
                .spec(requestSpec)
                .body(userPayload)
                .when()
                .put("/users/" + id);
    }

    public Response deleteUser(int id) {
        return when()
                .delete("/users/" + id);
    }
}
