package br.com.restassuredapitesting.tests.booking.request;

import br.com.restassuredapitesting.base.BaseTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest extends BaseTest {

    public Response bookingReturnIds(){
        return given()
                .header("Content-Type","application/json")
                .when()
                .log().all()
                .get("booking");

    }
}
