package com.projects.tests.carts;

import com.projects.endpoints.CartsEndpoint;
import com.projects.testdata.CartTestData;
import com.projects.tests.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Cart Management")
@Feature("Update Cart")
public class UpdateCartTest extends BaseTest {

    private final CartsEndpoint cartAPI = new CartsEndpoint();

    @Test
    @Story("Update Existing Cart")
    @Description("Verify that an existing cart can be updated with new details.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Update Cart - Verify update response")
    public void testUpdateCart() {
        cartAPI.updateCart(CartTestData.EXISTING_CART_ID, CartTestData.TEST_USER_ID, CartTestData.updatedProductList())
                .then()
                .statusCode(200)
                .body("id", equalTo(CartTestData.EXISTING_CART_ID))
                .body("products[0].productId", equalTo(2))
                .body("products[0].quantity", equalTo(5));
    }
}
