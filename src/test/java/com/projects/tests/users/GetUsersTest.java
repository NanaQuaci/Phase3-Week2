package com.projects.tests.users;

import com.projects.tests.base.BaseTest;
import com.projects.endpoints.UsersEndpoint;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Users API")
@Feature("Retrieve Users")
public class GetUsersTest extends BaseTest {

    UsersEndpoint usersEndpoint = new UsersEndpoint();

    @Test
    @Story("GET: Retrieve All Users")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that all users can be retrieved successfully")
    void getAllUsers_ShouldReturn200AndList() {
        usersEndpoint.getAllUsers()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Story("GET: Retrieve User by ID")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a single user can be retrieved by ID")
    void getSingleUser_ShouldReturn200AndCorrectUser() {
        int userId = 1;

        usersEndpoint.getUserById(userId)
                .then()
                .statusCode(200)
                .body("id", equalTo(userId));
    }

    @Test
    @Story("GET: Retrieve Non-Existing User")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that retrieving a non-existing user returns 404")
    void getSingleUser_InvalidId_ShouldReturn404() {
        int invalidId = 9999;

        usersEndpoint.getUserById(invalidId)
                .then()
                .statusCode(404);
    }
}
