package br.com.restassuredapitesting.tests.ping.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AllTestes;
import br.com.restassuredapitesting.tests.ping.request.GetPingRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;


public class GetPingTest extends BaseTest {
    GetPingRequest getPingRequest = new GetPingRequest();
    @Test
    @Category({AllTestes.class})

    public void validaApiOnLine(){

      getPingRequest.pingReturnApi()
                .then()
                .statusCode(201);
    }



}
