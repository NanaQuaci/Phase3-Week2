package com.projects.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import com.projects.tests.base.BaseTest;

public class AuthEndpoint {

    private static final String LOGIN_ENDPOINT = "/auth/login";

    public static Response login(String username, String password) {
        String requestBody = String.format("""
                {
                    "username": "%s",
                    "password": "%s"
                }
                """, username, password);

        return given()
                .spec(BaseTest.requestSpec)
                .body(requestBody)
                .when()
                .post(LOGIN_ENDPOINT);
    }
}
