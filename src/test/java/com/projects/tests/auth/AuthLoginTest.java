package com.projects.tests.auth;

import com.projects.endpoints.AuthEndpoint;
import com.projects.testdata.AuthTestData;
import com.projects.tests.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Fakestore API Tests")
@Feature("Authentication")
@Owner("Collins Adu")
public class AuthLoginTest extends BaseTest {

    @Test
    @Story("User Login")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Login with valid credentials - Should return token")
    @Description("Verify that a valid username and password returns a JWT token for authentication.")
    public void testLoginWithValidCredentials() {
        AuthEndpoint.login(AuthTestData.VALID_USERNAME, AuthTestData.VALID_PASSWORD)
                .then()
                .statusCode(200)
                .body("token", notNullValue());
    }

    @Test
    @Story("User Login")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Login with invalid credentials - Should return 401")
    @Description("Verify that an invalid username or password returns a 401 Unauthorized error.")
    public void testLoginWithInvalidCredentials() {
        AuthEndpoint.login(AuthTestData.INVALID_USERNAME, AuthTestData.INVALID_PASSWORD)
                .then()
                .statusCode(401)
                .body("token", nullValue());
    }
}
