package tests;

import models.BadMessageResponse;
import models.MessagesRequest;
import models.MessagesResponse;
import org.junit.jupiter.api.Test;
import specs.BookingSpec;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendTextMessageTests extends ApiTestBase {

    @Test
    void SendingMessagePositiveTest() {
        MessagesRequest hotelAuthData = new MessagesRequest();
        hotelAuthData.setMessageid("1");
        hotelAuthData.setName("Jacob Jacobi");
        hotelAuthData.setEmail("meow@gmail.com");
        hotelAuthData.setPhone("73600846746");
        hotelAuthData.setSubject("My booking");
        hotelAuthData.setDescription("Hey can I book a single room?");


        MessagesResponse bookresponse = given(BookingSpec.bookingRequestSpec)
                .body(hotelAuthData)
                .when()
                .post("/message/")
                .then()
                .spec(BookingSpec.bookingResponseSpec)
                .extract().as(MessagesResponse.class);

        assertEquals("Jacob Jacobi", bookresponse.getName());
        assertEquals("meow@gmail.com", bookresponse.getEmail());
        assertEquals("73600846746", bookresponse.getPhone());
        assertEquals("My booking", bookresponse.getSubject());
        assertEquals("Hey can I book a single room?", bookresponse.getDescription());

    }

    @Test
    void SendingMessageBadEmailTest() {

        MessagesRequest hotelAuthData = new MessagesRequest();
        hotelAuthData.setMessageid("1");
        hotelAuthData.setName("Jacob Jacobi");
        hotelAuthData.setEmail("meowgmail.com");
        hotelAuthData.setPhone("73600846746");
        hotelAuthData.setSubject("My booking");
        hotelAuthData.setDescription("Hey can I book a single room?");


        given(BookingSpec.bookingRequestSpec)
                .body(hotelAuthData)
                .when()
                .post("/message/")
                .then()
                .spec(BookingSpec.bookingBadEmailResponseSpec)
                .extract().as(BadMessageResponse.class);

    }
}