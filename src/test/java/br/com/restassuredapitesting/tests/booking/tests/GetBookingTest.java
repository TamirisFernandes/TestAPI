package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AllTestes;
import br.com.restassuredapitesting.suites.ContractTests;
import br.com.restassuredapitesting.suites.SchemaTests;
import br.com.restassuredapitesting.tests.booking.request.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;


@Feature("Feature - Retorno de Reservas")
public class GetBookingTest extends BaseTest{
    
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTestes.class})
    @DisplayName("Listar Ids de Reservas")
    public void validaListagemDeIdsDasReservas(){

        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTestes.class, ContractTests.class, SchemaTests.class})
    @DisplayName("Garantir o schema do retorno da listagem de reservas")
    public void validaSchemaDaListagemDeReservas(){
        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking","bookings"))));

    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTestes.class, SchemaTests.class })
    @DisplayName("Garantir o schema do retorno de uma reserva específica")
    public void validaSchemaDoRetornoById(){
        int primeiroId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        getBookingRequest.bookingReturnById(primeiroId)
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking","specificBooking"))));
    }
}

