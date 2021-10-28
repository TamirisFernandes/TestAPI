package br.com.restassuredapitesting.tests.booking.request;

import br.com.restassuredapitesting.base.BaseTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBookingRequest extends BaseTest {

    @Step("Exclui uma reserva com sucesso")
    public Response deleteBookingToken(int id, String token){
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Cookie",token)
                .when()
                .delete("booking/"+ id);
    }

}
