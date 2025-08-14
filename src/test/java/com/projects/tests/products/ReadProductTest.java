package com.projects.tests.products;

import com.projects.endpoints.ProductsEndpoint;
import com.projects.testdata.ProductTestData;
import com.projects.tests.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Product Management API")
@Feature("Read Product")
public class ReadProductTest extends BaseTest {

    private final ProductsEndpoint productAPI = new ProductsEndpoint();

    @Test
    @Story("GET: Retrieve all products")
    @Description("Verify that retrieving all products returns a non-empty list with valid IDs.")
    @Severity(SeverityLevel.CRITICAL)
    void getAllProducts_returns200_andListNotEmpty() {
        productAPI.getAllProducts()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("id", everyItem(notNullValue()));
    }

    @Test
    @Story("GET: Retrieve product by ID")
    @Description("Verify that retrieving a product by ID returns the correct product.")
    @Severity(SeverityLevel.CRITICAL)
    void getProductById_returns200_andHasId() {
        productAPI.getProductById(ProductTestData.EXISTING_PRODUCT_ID)
                .then()
                .statusCode(200)
                .body("id", equalTo(ProductTestData.EXISTING_PRODUCT_ID))
                .body("title", notNullValue());
    }

    @Test
    @Story("GET: Retrieve non-existent product")
    @Description("Verify that retrieving a product with an invalid ID returns 404.")
    @Severity(SeverityLevel.NORMAL)
    void getProductById_invalidId_returns404() {
        productAPI.getProductById(ProductTestData.NON_EXISTENT_PRODUCT_ID)
                .then()
                .statusCode(anyOf(is(404), is(400)))
                .body(containsString("Not Found"));
    }
}
