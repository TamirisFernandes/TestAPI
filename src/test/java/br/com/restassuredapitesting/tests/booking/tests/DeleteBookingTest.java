package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;

import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTestes;
import br.com.restassuredapitesting.suites.E2eTests;
import br.com.restassuredapitesting.tests.auth.resquests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.request.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.request.GetBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Feature("Feature - Exclui reserva com sucesso")

public class DeleteBookingTest extends BaseTest{

    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTestes.class, AcceptanceTests.class})
    @DisplayName("Exclui uma reserva somente utilizando o token")
    public void deleteBookingSuccess(){
        int primeiroId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");


        deleteBookingRequest.deleteBookingToken(primeiroId, postAuthRequest.getToken())
                .then()
                .statusCode(201);

    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTestes.class, AcceptanceTests.class, E2eTests.class})
    @DisplayName("Tentar excluir um reserva que não existe")
    public void deleteInvalidBooking(){

        deleteBookingRequest.deleteBookingToken(99999999, postAuthRequest.getToken())
                .then()
                .statusCode(405);

    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTestes.class, AcceptanceTests.class, E2eTests.class})
    @DisplayName("Tentar excluir uma reserva sem autorização")
    public void deleteBookingWithoutAuth(){
        int primeiroId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");


        deleteBookingRequest.deleteBookingToken(primeiroId,"a")
                .then()
                .statusCode(403);

    }
}
