package response;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(chain = true)
public class AssertableResponse {

    private Response response;

    public AssertableResponse assertStatus(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
        return this;
    }

    public <T> T getResponseBody(Class<T> klazz) {
        return response.then()
                .extract().as(klazz);
    }

}
