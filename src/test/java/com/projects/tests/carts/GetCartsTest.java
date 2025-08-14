package com.projects.tests.carts;

import com.projects.endpoints.CartsEndpoint;
import com.projects.testdata.CartTestData;
import com.projects.tests.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Cart Management")
@Feature("Retrieve Carts")
public class GetCartsTest extends BaseTest {

    private final CartsEndpoint cartAPI = new CartsEndpoint();

    @Test
    @Story("Get All Carts")
    @Description("Verify that the API returns all carts with correct structure and status code.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Get All Carts - Verify status code and response structure")
    public void testGetAllCarts() {
        cartAPI.getAllCarts()
                .then()
                .statusCode(200)
                .body("$", not(empty()))
                .body("[0].id", notNullValue())
                .body("[0].userId", notNullValue())
                .body("[0].products", notNullValue());
    }

    @Test
    @Story("Get Single Cart")
    @Description("Verify that a single cart can be retrieved by its ID.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Get Single Cart - Verify specific cart details")
    public void testGetSingleCart() {
        cartAPI.getSingleCart(CartTestData.EXISTING_CART_ID)
                .then()
                .statusCode(200)
                .body("id", equalTo(CartTestData.EXISTING_CART_ID))
                .body("userId", notNullValue())
                .body("products", not(empty()));
    }
}
