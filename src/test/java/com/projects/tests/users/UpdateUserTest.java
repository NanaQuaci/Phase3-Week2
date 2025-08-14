package com.projects.tests.users;

import com.projects.tests.base.BaseTest;
import com.projects.endpoints.UsersEndpoint;
import com.projects.testdata.UserTestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Users API")
@Feature("Update User")
public class UpdateUserTest extends BaseTest {

    UsersEndpoint usersEndpoint = new UsersEndpoint();

    @Test
    @Story("PUT: Modify Existing User")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a user's details can be updated successfully")
    void updateUser_ShouldReturn200AndUpdatedData() {
        int userId = 1;
        var payload = UserTestData.updatedUserPayload();

        usersEndpoint.updateUser(userId, payload)
                .then()
                .statusCode(200)
                .body("username", equalTo(payload.get("username")));
    }

    @Test
    @Story("PUT: Update Non-Existing User")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that updating a non-existing user returns 404")
    void updateUser_NonExistingId_ShouldReturn404() {
        int invalidId = 9999;
        var payload = UserTestData.fakeUserPayload();

        usersEndpoint.updateUser(invalidId, payload)
                .then()
                .statusCode(404);
    }
}
