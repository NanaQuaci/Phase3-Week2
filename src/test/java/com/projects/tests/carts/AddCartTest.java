package com.projects.tests.carts;

import com.projects.endpoints.CartsEndpoint;
import com.projects.testdata.CartTestData;
import com.projects.tests.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Cart Management")
@Feature("Add Cart")
public class AddCartTest extends BaseTest {

    private final CartsEndpoint cartAPI = new CartsEndpoint();

    @Test
    @Story("Add a New Cart")
    @Description("Verify that a new cart can be created with valid details.")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Add New Cart - Verify creation")
    public void testAddNewCart() {
        cartAPI.addCart(CartTestData.TEST_USER_ID, CartTestData.sampleProductList())
                .then()
                .statusCode(200)
                .body("userId", equalTo(CartTestData.TEST_USER_ID))
                .body("products", not(empty()));
    }
}
