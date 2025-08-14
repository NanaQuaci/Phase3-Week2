package com.projects.endpoints;

import com.projects.tests.base.BaseTest;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CartsEndpoint extends BaseTest {

    public Response addCart(int userId, JSONArray products) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", userId);
        requestBody.put("products", products);

        return given()
                .spec(requestSpec)
                .body(requestBody.toString())
                .when()
                .post("/carts");
    }

    public Response getAllCarts() {
        return given()
                .spec(requestSpec)
                .when()
                .get("/carts");
    }

    public Response getSingleCart(int cartId) {
        return given()
                .spec(requestSpec)
                .pathParam("id", cartId)
                .when()
                .get("/carts/{id}");
    }

    public Response updateCart(int cartId, int userId, JSONArray products) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("userId", userId);
        requestBody.put("products", products);

        return given()
                .spec(requestSpec)
                .pathParam("id", cartId)
                .body(requestBody.toString())
                .when()
                .put("/carts/{id}");
    }

    public Response deleteCart(int cartId) {
        return given()
                .spec(requestSpec)
                .pathParam("id", cartId)
                .when()
                .delete("/carts/{id}");
    }
}
