package com.projects.tests.products;

import com.projects.endpoints.ProductsEndpoint;
import com.projects.testdata.ProductTestData;
import com.projects.tests.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Product Management API")
@Feature("Delete Product")
public class DeleteProductTest extends BaseTest {

    private final ProductsEndpoint productAPI = new ProductsEndpoint();

    @Test
    @Story("DELETE: Remove a product")
    @Description("Verify that deleting a product returns 200 and possibly a success message.")
    @Severity(SeverityLevel.CRITICAL)
    void deleteProduct_returns200() {
        productAPI.deleteProduct(ProductTestData.EXISTING_PRODUCT_ID)
                .then()
                .statusCode(200);
    }

    @Test
    @Story("DELETE: Remove non-existent product")
    @Description("Verify that deleting a non-existent product returns 404.")
    @Severity(SeverityLevel.NORMAL)
    void deleteNonExistentProduct_returns404() {
        productAPI.deleteProduct(ProductTestData.NON_EXISTENT_PRODUCT_ID)
                .then()
                .statusCode(anyOf(is(404), is(400)));
    }
}
