package br.com.restassuredapitesting.tests.booking.request;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class AcceptanceRequest extends BaseTest {

    @Step("Lista id das reservas")
    public Response bookingReturnIds() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking");
    }

    @Step("Lista uma reserva específica")
    public Response bookingReturnById(int id) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking/" + id);
    }

    @Step("Listar IDs de reservas utilizando o filtro firstname")
    public Response returnIdsFilterFirstName(String firstname) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking?firstname=" + firstname);

    }

    @Step("Listar IDs de reservas utilizando o filtro lastname")
    public Response returnIdsFilterLastName(String lastname) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking?firstname=" + lastname);

    }

    @Step("Listar IDs de reservas utilizando o filtro checkin")
    public Response returnIdsFilterCheckIn(String checkin) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking?checkin=" + checkin);
    }
    @Step("Listar IDs de reservas utilizando o filtro checkout")
    public Response returnIdsFilterCheckout(String checkout) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("booking?checkout=" + checkout);
    }
    @Step("Listar IDs de reservas utilizando o filtro checkout and checkout")
    public Response returnFilterChekoutAndChekout(String checkout1, String checkout2){
        return given()
                .queryParam("checkout", checkout1)
                .queryParam("checkout", checkout2)
                .get("booking");
    }

    @Step("Listar IDs de reservas utilizando o filtro name, checkin and checkout date")
    public Response returnFilterNameAndCheckinAndCheckout(String name,String checkin, String checkout){
        return given()
                .queryParam("name", name)
                .queryParam("checkin", checkin)
                .queryParam("checkout", checkout)
                .get("booking");

    }

    @Step("Criar uma nova reserva")
    public Response criateNewBooking(String payload){
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .when()
                .body(payload)
                .post("booking");
    }
    @Step("Alterar uma reserva usando o token")
    public Response updateBookingToken(int id, String token){
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Cookie",token)
                .when()
                .body(BookingPayloads.payloadValidBooking().toString())
                .put("booking/"+ id);
    }
    @Step("Alterar uma reserva usando o Basic Auth")
    public Response updateBookingBasicAuth(int id) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .body(BookingPayloads.payloadValidBooking().toString())
                .put("booking/" + id);
    }
    public Response returnStatus418() {
        return given()
                .header("Content-Type", "application/json")
//                .header("Accept", "418")
                .when()
                .get("booking");
    }

}