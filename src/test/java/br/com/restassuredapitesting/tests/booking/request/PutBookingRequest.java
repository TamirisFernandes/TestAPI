package br.com.restassuredapitesting.tests.booking.request;

import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutBookingRequest{
    BookingPayloads bookingPayloads = new BookingPayloads();

    public Response updateBookingToken(int id, String token){
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Cookie",token)
                .when()
                .body(BookingPayloads.payloadValidBooking().toString())
                .put("booking/"+ id);
    }
}
