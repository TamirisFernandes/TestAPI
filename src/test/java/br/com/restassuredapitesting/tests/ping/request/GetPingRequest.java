package br.com.restassuredapitesting.tests.ping.request;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetPingRequest {

    @Step("Retorna Api on line")
    public Response pingReturnApi(){
        return given()
                .header("Content-Type","application/json")
                .when()
                .get("ping");

    }
}
