package online.automationintesting.tests;

import online.automationintesting.models.LoginBody;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import online.automationintesting.specs.BookingSpec;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class LoginInTest extends ApiTestBase {

    @Test
    @Tag("api")
            void loginCookieTest(){

    LoginBody loginAuthData = new LoginBody();
        loginAuthData.setUsername("admin");
        loginAuthData.setPassword("password");
    String authCookieKey = "token";
    String authCookieValue =
            given(BookingSpec.bookingloginRequestSpec)
                    .contentType(JSON)
                    .body(loginAuthData)
                    .when()
                    .post("/auth/login")
                    .then()
                    .statusCode(200)
                    .extract()
                    .cookie(authCookieKey);

        System.out.println("token is " + authCookieValue);

}}
