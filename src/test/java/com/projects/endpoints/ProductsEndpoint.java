package com.projects.endpoints;

import com.projects.tests.base.BaseTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductsEndpoint extends BaseTest {

    public Response createProduct(Object productPayload) {
        return given()
                .spec(requestSpec)
                .body(productPayload)
                .when()
                .post("/products");
    }

    public Response getAllProducts() {
        return given()
                .spec(requestSpec)
                .when()
                .get("/products");
    }

    public Response getProductById(int id) {
        return given()
                .spec(requestSpec)
                .pathParam("id", id)
                .when()
                .get("/products/{id}");
    }

    public Response getCategories() {
        return given()
                .spec(requestSpec)
                .when()
                .get("/products/categories");
    }

    public Response updateProduct(int id, Object productPayload) {
        return given()
                .spec(requestSpec)
                .pathParam("id", id)
                .body(productPayload)
                .when()
                .put("/products/{id}");
    }

    public Response deleteProduct(int id) {
        return given()
                .spec(requestSpec)
                .pathParam("id", id)
                .when()
                .delete("/products/{id}");
    }
}
