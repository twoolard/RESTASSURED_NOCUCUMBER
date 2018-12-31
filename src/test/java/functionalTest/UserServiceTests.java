package functionalTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

import java.util.List;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import model.userService.ErrorResponse;
import model.userService.Page;
import model.userService.User;
import response.AssertableResponse;
import services.UserService;
import utils.properties.TestConstant;
import utils.properties.TestProperties;

public class UserServiceTests {

    private static User user;
    private final static Faker faker = new Faker();
    private UserService userService = new UserService();


    @BeforeClass
    static void setUp() {
        RestAssured.baseURI = TestProperties.getProperty(TestConstant.REGRES_URL);
        user = User.builder().name(faker.name().name())
                .job(faker.job().title())
                .email("testEmail@gmail.com")
                .password("Test123")
                .build();
    }

    @Test
    void testCanCreateUser() {
        AssertableResponse response = userService.createUser(user);

        response.assertStatus(HttpStatus.SC_CREATED);
        User user = response.getResponseBody(User.class);
        assertThat(user.getId(), not(isEmptyString()));
        assertThat(user.getCreatedAt(), not(isEmptyString()));
        assertThat(user.getName(), equalTo(this.user.getName()));
        assertThat(user.getJob(), equalTo(this.user.getJob()));
    }

    @Test
    void testGetAllUsers() {
        AssertableResponse response = userService.getAllUsers();
        response.assertStatus(HttpStatus.SC_OK);

        List<User> allUsers = response.getResponseBody(Page.class).getData();
        allUsers.forEach(user -> {
            assertThat(user.getId(), not(isEmptyString()));
            assertThat(user.getAvatar(), not(isEmptyString()));
            assertThat(user.getFirstName(), not(isEmptyString()));
            assertThat(user.getLastName(), not(isEmptyString()));
        });
    }

    @Test
    void testUpdateUserPUT() {
        AssertableResponse response = userService.updateUser(user, "2");
        response.assertStatus(HttpStatus.SC_OK);

        User user = response.getResponseBody(User.class);
        assertThat(user.getUpdatedAt(), not(isEmptyString()));
    }

    @Test
    void testUpdateUserPATCH() {
        AssertableResponse response = userService.updateUserPatch(user, "2");
        response.assertStatus(HttpStatus.SC_OK);

        User user = response.getResponseBody(User.class);
        assertThat(user.getUpdatedAt(), not(isEmptyString()));
    }

    @Test
    void testDeleteUser() {
        AssertableResponse response = userService.deleteUserById("2");
        response.assertStatus(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    void testCanRegisterUser() {
        AssertableResponse response = userService.registerUser(user);
        response.assertStatus(HttpStatus.SC_CREATED);

        User user = response.getResponseBody(User.class);
        assertThat(user.getToken(), not(isEmptyString()));
    }

    @Test
    void testCannotRegisterWrongUser() {
        User testUser = new User();
        testUser.setEmail("testEmail@gmail.com");

        AssertableResponse response = userService.registerUser(testUser);
        response.assertStatus(HttpStatus.SC_BAD_REQUEST);

        ErrorResponse error = response.getResponseBody(ErrorResponse.class);
        assertThat(error.getError(), not(isEmptyString()));
        assertThat(error.getError(), equalTo("Missing password"));
    }

    @Test
    void testUserCanLogin() {
        AssertableResponse response = userService.loginAsUser(user);
        response.assertStatus(HttpStatus.SC_OK);

        User user = response.getResponseBody(User.class);
        assertThat(user.getToken(), not(isEmptyString()));
    }

    @Test
    void testCannotLoginWrongUser() {
        User user = new User();
        user.setEmail("testEmail@gmail.com");
        AssertableResponse response = userService.loginAsUser(user);

        response.assertStatus(HttpStatus.SC_BAD_REQUEST);

        ErrorResponse error = response.getResponseBody(ErrorResponse.class);
        assertThat(error.getError(), not(isEmptyString()));
        assertThat(error.getError(), equalTo("Missing password"));
    }
}
