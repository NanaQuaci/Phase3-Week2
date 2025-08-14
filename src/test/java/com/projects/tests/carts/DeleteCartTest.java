package com.projects.tests.carts;

import com.projects.endpoints.CartsEndpoint;
import com.projects.testdata.CartTestData;
import com.projects.tests.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

@Epic("Cart Management")
@Feature("Delete Cart")
public class DeleteCartTest extends BaseTest {

    private final CartsEndpoint cartAPI = new CartsEndpoint();

    @Test
    @Story("Delete Existing Cart")
    @Description("Verify that an existing cart can be deleted by ID.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Delete Cart - Verify deletion response")
    public void testDeleteCart() {
        cartAPI.deleteCart(CartTestData.EXISTING_CART_ID)
                .then()
                .statusCode(200)
                .body("id", equalTo(CartTestData.EXISTING_CART_ID));
    }
}
