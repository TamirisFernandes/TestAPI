package br.com.restassuredapitesting.tests.booking.request;

import br.com.restassuredapitesting.base.BaseTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class GetBookingRequest extends BaseTest {

    @Step("Retorna os Ids da listagem de reservas")
    public Response bookingReturnIds() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking");

    }

    @Step("retorna uma reserva específica")
    public Response bookingReturnById(int id) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking/" + id);

    }
}