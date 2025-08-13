package com.projects.tests;

import com.projects.base.BaseTest;
import com.projects.endpoints.DeleteEndpoint;
import org.junit.jupiter.api.Test;

public class DeleteProductTest extends BaseTest {

    DeleteEndpoint delete = new DeleteEndpoint();

    @Test
    void deleteProduct_returns200() {
        delete.deleteProduct(1)
                .then()
                .statusCode(200);
    }
}
