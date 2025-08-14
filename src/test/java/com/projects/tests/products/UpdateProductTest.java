package com.projects.tests.products;

import com.projects.endpoints.ProductsEndpoint;
import com.projects.testdata.ProductTestData;
import com.projects.tests.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Product Management API")
@Feature("Update Product")
public class UpdateProductTest extends BaseTest {

    private final ProductsEndpoint productAPI = new ProductsEndpoint();

    @Test
    @Story("PUT: Update product details")
    @Description("Verify that a product can be updated successfully and the title matches the new value.")
    @Severity(SeverityLevel.CRITICAL)
    void updateProduct_returns200_andUpdatedTitle() {
        var payload = ProductTestData.updatedProductPayload();

        productAPI.updateProduct(ProductTestData.EXISTING_PRODUCT_ID, payload)
                .then()
                .statusCode(200)
                .body("title", equalTo(payload.get("title")))
                .body("price", equalTo(payload.get("price")));
    }

    @Test
    @Story("PUT: Update non-existent product")
    @Description("Verify that updating a non-existent product returns 404 or appropriate error.")
    @Severity(SeverityLevel.NORMAL)
    void updateProduct_invalidId_returns404() {
        var payload = ProductTestData.updatedProductPayload();

        productAPI.updateProduct(ProductTestData.NON_EXISTENT_PRODUCT_ID, payload)
                .then()
                .statusCode(anyOf(is(404), is(400)));
    }
}
