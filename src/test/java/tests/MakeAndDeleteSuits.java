package tests;

import models.CreateRoomBody;
import models.LoginBody;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.BookingSpec;


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
                given(BookingSpec.bookingloginRequestSpec)
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
        createRoomBody.setFeatures(null);


        step("Create new room", () ->
                given(BookingSpec.bookingloginRequestSpec)
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
    void DeleteRoomTest() {

        LoginBody loginAuthData = new LoginBody();
        loginAuthData.setUsername("admin");
        loginAuthData.setPassword("password");
        String authCookieKey = "token";
        String authCookieValue = step("get new token", () ->
                given(BookingSpec.bookingloginRequestSpec)
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
        createRoomBody.setFeatures(null);

        step("Create new room", () -> {
            given(BookingSpec.bookingloginRequestSpec)
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
            given(BookingSpec.bookingloginRequestSpec)
                    .cookie(authCookieKey, authCookieValue)
                    .when()
                    .delete("/room/3")
                    .then()
                    .log().all()
                    .statusCode(202);
        });


    }
}
