package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.runner.SchemaTests;
import br.com.restassuredapitesting.suites.AllTestes;
import br.com.restassuredapitesting.suites.E2eTests;
import br.com.restassuredapitesting.tests.auth.resquests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.payloads.BookingPayloads;
import br.com.restassuredapitesting.tests.booking.request.AcceptanceRequest;
import br.com.restassuredapitesting.tests.booking.request.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.utils.Utils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;

public class AcceptanceTest extends BaseTest {

        AcceptanceRequest acceptanceRequest = new AcceptanceRequest();
        GetBookingRequest getBookingRequest = new GetBookingRequest();
        PostAuthRequest postAuthRequest = new PostAuthRequest();

        @Test
        @Severity(SeverityLevel.BLOCKER)
        @Category({AllTestes.class})
        @DisplayName("Lista Id das reservas")

        public void listaIdDeReservas() {
                acceptanceRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .body("size()", greaterThan(0));
        }

        @Test
        @Severity(SeverityLevel.BLOCKER)
        @Category({AllTestes.class, SchemaTests.class})
        @DisplayName("Listar uma reserva específica")

        public void listarUmaReservaEspecífica() {
                int primeiroId = getBookingRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");

                acceptanceRequest.bookingReturnById(primeiroId)
                        .then()
                        .statusCode(200)
                        .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "specificBooking"))));
        }

        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class, SchemaTests.class})
        @DisplayName("Listar IDs de reservas utilizando o filtro firstname")

        public void returnIdsFilterFirstName(){
                int primeiroId = getBookingRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");

                String firstname = getBookingRequest.bookingReturnById(primeiroId)
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("lastname");

                acceptanceRequest.returnIdsFilterFirstName(firstname)
                        .then()
                        .statusCode(200)
                        .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
        }

        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class, SchemaTests.class})
        @DisplayName("Listar IDs de reservas utilizando o filtro lastname")

        public void returnIdsFilterLastName(){
                int primeiroId = getBookingRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");

                String lastname = getBookingRequest.bookingReturnById(primeiroId)
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("lastname");

                acceptanceRequest.returnIdsFilterLastName(lastname)
                        .then()
                        .statusCode(200)
                        .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
        }

        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class, SchemaTests.class})
        @DisplayName("Listar IDs de reservas utilizando o filtro checkin")

        public void returnIdsFilterCheckIn(){
                int primeiroId = getBookingRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");

                String checkin = getBookingRequest.bookingReturnById(primeiroId)
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("bookingdates.checkin");

                acceptanceRequest.returnIdsFilterCheckIn(checkin)
                        .then()
                        .statusCode(200)
                        .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
        }

        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class, SchemaTests.class})
        @DisplayName("Listar IDs de reservas utilizando o filtro checkout")

        public void returnIdsFilterCheckout(){
                int primeiroId = getBookingRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");

                String checkout = getBookingRequest.bookingReturnById(primeiroId)
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("bookingdates.checkout");

                acceptanceRequest.returnIdsFilterCheckout(checkout)
                        .then()
                        .statusCode(200)
                        .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
        }

        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class, SchemaTests.class})
        @DisplayName("Listar IDs de reservas utilizando o filtro checkout and checkout")

        public void returnIdsFilterCheckoutAndCheckout(){
                int primeiroId = getBookingRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");

                String checkout= getBookingRequest.bookingReturnById(primeiroId)
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("bookingdates.checkout");

                acceptanceRequest.returnFilterChekoutAndChekout(checkout, checkout )
                        .then()
                        .statusCode(500);
        }

        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class, SchemaTests.class})
        @DisplayName("Listar IDs de reservas utilizando o filtro name, checkin and checkout date")

        public void returnFilterNameAndCheckinAndCheckout(){
                int primeiroId = getBookingRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");

                Response filtrosReservas = getBookingRequest.bookingReturnById(primeiroId);

                String name = filtrosReservas.path("firstname");
                String checkin = filtrosReservas.path("bookingdates.checkin");
                String checkout = filtrosReservas.path("bookingdates.checkout");

                acceptanceRequest.returnFilterNameAndCheckinAndCheckout(name,checkin, checkout)
                        .then()
                        .statusCode(200)
                        .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
        }
        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class})
        @DisplayName("Criar Nova Reserva")
        public void validacriateNewBooking(){
                acceptanceRequest.criateNewBooking(BookingPayloads.payloadNewBooking().toString())
                        .then()
                        .statusCode(200);
        }
        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class})
        @DisplayName("Alterar uma reserva usando o token")
        public void validarAlteracaoDeUmaReservaUtilizandoToken(){
                int primeiroId = getBookingRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");

                acceptanceRequest.updateBookingToken(primeiroId,postAuthRequest.getToken())
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("firstname")
                        .equals("Cristiano");
        }
        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class})
        @DisplayName("Alterar uma reserva usando o Basic Auth")
        public void validarAlteracaoDeUmaReservaUtilizandoBasicAuth(){
                int primeiroId = getBookingRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");

                acceptanceRequest.updateBookingBasicAuth(primeiroId)
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("firstname")
                        .equals("Cristiano");
        }
        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class, E2eTests.class})
        @DisplayName("Visualizar erro de servidor 500 quando enviar filtro mal formatado")
        public void validateInvalidFilter() {
                acceptanceRequest.returnIdsFilterCheckout("p")
                        .then()
                        .statusCode(500);
        }
        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class, E2eTests.class})
        @DisplayName("Validar retorno 500 quando o payload da reserva estiver inválido")
        public void validateBookingPayloadInvalid(){
                acceptanceRequest.returnIdsFilterCheckIn("p")
                .then()
                .statusCode(500);
        }

        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class, E2eTests.class})
        @DisplayName("Validar a criação de mais de um livro em sequencia")
        public void validateBookingsInSequence(){
                acceptanceRequest.criateNewBooking(BookingPayloads.payloadNewBooking().toString())
                        .then()
                        .statusCode(200);
                acceptanceRequest.criateNewBooking(BookingPayloads.payloadNewBooking().toString())
                        .then()
                        .statusCode(200);

        }

        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class, E2eTests.class})
        @DisplayName("Criar uma reserva enviando mais parâmetros no payload da reserva")
        public void validateBookingWhithMoreParam(){
                JSONObject JSONPayload = BookingPayloads.payloadNewBooking();
                JSONPayload.put("middlename","da Silva");

                acceptanceRequest.criateNewBooking(JSONPayload.toString())
                        .then()
                        .statusCode(200);
        }

        @Test
        @Severity(SeverityLevel.CRITICAL)
        @Category({AllTestes.class, E2eTests.class})
        @DisplayName("Tentar alterar uma reserva quando o token não for enviado")
        public void changeBookingWhitoutToken(){
                int primeiroId = getBookingRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");

                acceptanceRequest.updateBookingToken(primeiroId, "")
                        .then()
                        .statusCode(403);
        }

        @Test
        @Severity(SeverityLevel.CRITICAL)
        @Category({AllTestes.class, E2eTests.class})
        @DisplayName("Tentar alterar uma reserva quando o token enviado for inválido")
        public void changeBookingWithInvalidToken(){
                int primeiroId = getBookingRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");

                acceptanceRequest.updateBookingToken(primeiroId, "354641x6")
                        .then()
                        .statusCode(403);
        }
        @Test
        @Severity(SeverityLevel.NORMAL)
        @Category({AllTestes.class, E2eTests.class})
        @DisplayName("Tentar alterar uma reserva que não existe")
        public void changeBookingInvalid(){

                acceptanceRequest.updateBookingToken(0, postAuthRequest.getToken())
                        .then()
                        .statusCode(405);
        }


}