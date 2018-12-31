package services;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import response.AssertableResponse;

@Slf4j
public class GoogleBooks {
    private static String BASE_VOLUMES_URL = "/books/v1/volumes";


    @Step("Perform GET book by ISBN")
    public AssertableResponse getBookByIsbn(String isbn) {
        log.info(String.format("Getting Book with the following ISBN: %s ", isbn));
        String url = BASE_VOLUMES_URL;

        Response response =
                RestAssured.given()
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter(),
                        new AllureRestAssured())
                .param("q", isbn)
                .when().get(url)
                .then().extract().response();

        return new AssertableResponse(response);
    }
}
