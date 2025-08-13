package com.projects.tests;

import com.projects.base.BaseTest;
import com.projects.endpoints.GetEndpoint;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class ReadProductTest extends BaseTest {

    GetEndpoint get = new GetEndpoint();

    @Test
    void getAllProducts_returns200_andListNotEmpty() {
        get.getAllProducts()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    void getProductById_returns200_andHasId() {
        get.getProductById(1)
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }
}
