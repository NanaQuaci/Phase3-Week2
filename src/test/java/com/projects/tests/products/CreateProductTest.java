package com.projects.tests.products;

import com.projects.endpoints.ProductsEndpoint;
import com.projects.testdata.ProductTestData;
import com.projects.tests.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Product Management API")
@Feature("Create Product")
public class CreateProductTest extends BaseTest {

    private final ProductsEndpoint productAPI = new ProductsEndpoint();

    @Test
    @Story("POST: Create a new product")
    @Description("Verify that a product can be created successfully and contains the expected title and price.")
    @Severity(SeverityLevel.CRITICAL)
    void createProduct_returns200_andContainsTitleAndPrice() {
        var payload = ProductTestData.newProductPayload();

        productAPI.createProduct(payload)
                .then()
                .statusCode(200)
                .body("title", equalTo(payload.get("title")))
                .body("price", equalTo(payload.get("price")));
    }

    @Test
    @Story("POST: Create a new product with invalid data")
    @Description("Verify that creating a product with missing title returns 400 or error message.")
    @Severity(SeverityLevel.NORMAL)
    void createProduct_withMissingTitle_returnsError() {
        var payload = ProductTestData.invalidProductPayload_MissingTitle();

        productAPI.createProduct(payload)
                .then()
                .statusCode(anyOf(is(400), is(500)))
                .body(containsString("title"));
    }
}
