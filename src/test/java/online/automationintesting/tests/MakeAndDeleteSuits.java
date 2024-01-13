package online.automationintesting.tests;

import online.automationintesting.models.CreateRoomBody;
import online.automationintesting.models.LoginBody;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import online.automationintesting.specs.BookingSpec;


import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class MakeAndDeleteSuits extends ApiTestBase {

    @Test
    @Tag("api")
    void makeRoomTest() {
        LoginBody loginAuthData = new LoginBody();
        loginAuthData.setUsername("admin");
        loginAuthData.setPassword("password");
        String authCookieKey = "token";
        String authCookieValue = step("Get new token", () ->
                given(BookingSpec.loginRequestSpec)
                        .contentType(JSON)
                        .body(loginAuthData)
                        .when()
                        .post("/auth/login")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .cookie(authCookieKey));


        CreateRoomBody createRoomBody = new CreateRoomBody();
        createRoomBody.setRoomName("4");
        createRoomBody.setType("Double");
        createRoomBody.setAccessible(true);
        createRoomBody.setDescription("Pet-friendly");
        createRoomBody.setImage("https://www.mwtestconsultancy.co.uk/img/room1.jpg");
        createRoomBody.setRoomPrice("5");
        createRoomBody.setFeatures(List.of(new String[]{"WiFi", "TV"}));


        step("Create new room", () ->
                given(BookingSpec.loginRequestSpec)
                        .contentType(JSON)
                        .cookie(authCookieKey, authCookieValue)
                        .body(createRoomBody)
                        .when()
                        .post("/room/")
                        .then()
                        .log().all()
                        .statusCode(201)
                        .body("description", is("Pet-friendly")));

    }

    @Test
    @Tag("api")
    void deleteRoomTest() {

        LoginBody loginAuthData = new LoginBody();
        loginAuthData.setUsername("admin");
        loginAuthData.setPassword("password");
        String authCookieKey = "token";
        String authCookieValue = step("get new token", () ->
                given(BookingSpec.loginRequestSpec)
                        .contentType(JSON)
                        .body(loginAuthData)
                        .when()
                        .post("/auth/login")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .cookie(authCookieKey));


        CreateRoomBody createRoomBody = new CreateRoomBody();
        createRoomBody.setRoomName("7");
        createRoomBody.setType("Double");
        createRoomBody.setAccessible(true);
        createRoomBody.setDescription("Pet-friendly");
        createRoomBody.setImage("https://www.mwtestconsultancy.co.uk/img/room1.jpg");
        createRoomBody.setRoomPrice("5");
        createRoomBody.setFeatures(null);

        step("Create new room", () -> {
            given(BookingSpec.loginRequestSpec)
                    .contentType(JSON)
                    .cookie(authCookieKey, authCookieValue)
                    .body(createRoomBody)
                    .when()
                    .post("/room/")
                    .then()
                    .log().all()
                    .statusCode(201)
                    .body("description", is("Pet-friendly"));

        });


        step("Delete new room", () -> {
            given(BookingSpec.loginRequestSpec)
                    .cookie(authCookieKey, authCookieValue)
                    .when()
                    .delete("/room/2")
                    .then()
                    .log().all()
                    .statusCode(202);
        });

    }
}
