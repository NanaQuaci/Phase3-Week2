package com.projects.tests;

import com.projects.base.BaseTest;
import com.projects.endpoints.PutEndpoint;
import com.projects.testdata.PutTestData;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class UpdateProductTest extends BaseTest {

    PutEndpoint put = new PutEndpoint();

    @Test
    void updateProduct_returns200_andUpdatedTitle() {
        put.updateProduct(1, PutTestData.updatedProductPayload())
                .then()
                .statusCode(200)
                .body("title", equalTo(PutTestData.updatedProductPayload().get("title")));
    }
}
