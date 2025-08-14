package com.projects.tests.users;

import com.projects.tests.base.BaseTest;
import com.projects.endpoints.UsersEndpoint;
import com.projects.testdata.UserTestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Users API")
@Feature("Create User")
public class AddUserTest extends BaseTest {

    UsersEndpoint usersEndpoint = new UsersEndpoint();

    @Test
    @Story("POST: Add New User")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a new user can be added successfully")
    void addUser_ShouldReturn201AndUser() {
        var payload = UserTestData.validUserPayload();

        usersEndpoint.createUser(payload)
                .then()
                .statusCode(201)
                .body("username", equalTo(payload.get("username")));
    }

    @Test
    @Story("POST: Add User with Missing Fields")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that adding a user without required fields fails")
    void addUser_MissingField_ShouldReturnError() {
        var payload = UserTestData.invalidUserPayload_MissingFields();

        usersEndpoint.createUser(payload)
                .then()
                .statusCode(anyOf(is(400), is(500)));
    }
}
