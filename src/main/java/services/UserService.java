package services;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import model.userService.User;
import response.AssertableResponse;

@Slf4j
public class UserService {

    private static String BASE_USERS_URL = "/api/users/";
    private static String BASE_REGISTER_URL = "/api/register/";
    private static String BASE_LOGIN_URL = "/api/login/";

    private RequestSpecification setup() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter(),
                        new AllureRestAssured());
    }
    @Step("Create user with POST")
    public AssertableResponse getAllUsers(){
        log.info("Getting paginated list of all users");
        Response response = setup()
                .when().get(BASE_USERS_URL)
                .then().extract().response();

        return new AssertableResponse(response);
    }

    @Step("Create user with POST")
    public AssertableResponse createUser(User user) {
        log.info(String.format("Registering user with the following parameters + %s", user.toString()));
        Response response = setup().body(user)
                .when().post(BASE_USERS_URL)
                .then().extract().response();

        return new AssertableResponse(response);
    }

    @Step("Perform GET by User Id")
    public AssertableResponse getSingleUser(String userId) {
        log.info(String.format("Getting user with the following id: %s", userId));
        String url = String.format("%s%s", BASE_USERS_URL, userId);

        Response response = setup()
                .when().get(url)
                .then().extract().response();

        return new AssertableResponse(response);
    }

    @Step("Update user via PUT method")
    public AssertableResponse updateUser(User user, String userId) {
        log.info(String.format("Updating user via PUT with the following id: %s", userId));
        String url = String.format("%s%s", BASE_USERS_URL, userId);

        Response response = setup()
                .when().body(user).put(url)
                .then().extract().response();

        return new AssertableResponse(response);
    }

    @Step("Update user via PATCH method")
    public AssertableResponse updateUserPatch(User user, String userId) {
        log.info(String.format("Updating user via PATCH with the following id: %s", userId));
        String url = String.format("%s%s", BASE_USERS_URL, userId);

        Response response = setup()
                .when().body(user).patch(url)
                .then().extract().response();

        return new AssertableResponse(response);
    }

    @Step("Delete user by id")
    public AssertableResponse deleteUserById(String userId) {
        log.info(String.format("Deleting user via DELETE with the following id: %s", userId));
        String url = String.format("%s%s", BASE_USERS_URL, userId);

        Response response = setup()
                .when().delete(url)
                .then().extract().response();

        return new AssertableResponse(response);
    }

    @Step("Registering user")
    public AssertableResponse registerUser(User user) {
        log.info(String.format("Register user with the following email: %s", user.getEmail()));


        Response response = setup()
                .when().body(user).post(BASE_REGISTER_URL)
                .then().extract().response();

        return new AssertableResponse(response);
    }

    @Step("Login as a valid user")
    public AssertableResponse loginAsUser(User user) {
        log.info(String.format("Login as user: %s", user.toString()));

        Response response = setup()
                .when().body(user).post(BASE_LOGIN_URL)
                .then().extract().response();

        return new AssertableResponse(response);
    }


}
