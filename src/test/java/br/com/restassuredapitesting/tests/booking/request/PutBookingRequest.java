package br.com.restassuredapitesting.tests.booking.request;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutBookingRequest extends BaseTest {

    @Step("Atualiza uma reserva especifica com o parâmetro token")
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
