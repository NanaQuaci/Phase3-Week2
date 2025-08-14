package com.projects.tests.users;

import com.projects.tests.base.BaseTest;
import com.projects.endpoints.UsersEndpoint;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

//comment

import static org.hamcrest.Matchers.*;

@Epic("Users API")
@Feature("Delete User")
public class DeleteUserTest extends BaseTest {

    UsersEndpoint usersEndpoint = new UsersEndpoint();

    @Test
    @Story("DELETE: Remove Existing User")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a user can be deleted successfully")
    void deleteUser_ShouldReturn200AndConfirmation() {
        int userId = 1;

        usersEndpoint.deleteUser(userId)
                .then()
                .statusCode(200)
                .body("id", equalTo(userId));
    }

    @Test
    @Story("DELETE: Remove Non-Existing User")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that deleting a non-existing user returns 404")
    void deleteUser_NonExistingId_ShouldReturn404() {
        int invalidId = 9999;

        usersEndpoint.deleteUser(invalidId)
                .then()
                .statusCode(404);
    }
}
