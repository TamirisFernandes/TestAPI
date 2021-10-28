package br.com.restassuredapitesting.tests.ping.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AllTestes;
import br.com.restassuredapitesting.suites.HealthcheckTests;
import br.com.restassuredapitesting.tests.ping.request.GetPingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Feature("Feature - Api on line")
public class GetPingTest extends BaseTest {
    GetPingRequest getPingRequest = new GetPingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTestes.class, HealthcheckTests.class})
    @DisplayName("Verifica se a Api está on line")
    public void validaApiOnLine(){

      getPingRequest.pingReturnApi()
                .then()
                .statusCode(201);
    }



}
