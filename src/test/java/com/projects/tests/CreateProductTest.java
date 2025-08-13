package com.projects.tests;

import com.projects.base.BaseTest;
import com.projects.endpoints.PostEndpoint;
import com.projects.testdata.PostTestData;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class CreateProductTest extends BaseTest {

    PostEndpoint post = new PostEndpoint();

    @Test
    void createProduct_returns201_andContainsTitle() {
        post.createProduct(PostTestData.newProductPayload())
                .then()
                .statusCode(200) // FakeStore returns 200 for POST
                .body("title", equalTo(PostTestData.newProductPayload().get("title")));
    }
}
