package com.projects.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

public abstract class BaseTest {
    public static RequestSpecification requestSpec;

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
        requestSpec = new RequestSpecBuilder()
                .setContentType("application/json")
                .build();
    }
}
