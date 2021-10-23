package br.com.restassuredapitesting.tests.auth.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.runner.AllTestes;
import br.com.restassuredapitesting.suites.SmokeTests;
import br.com.restassuredapitesting.tests.auth.resquests.PostAuthRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.notNullValue;

public class PostAuthTest extends BaseTest {

    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Test
    @Category({AllTestes.class, SmokeTests.class})
    public void validaRetornoDeTokenParaUsuario(){
    postAuthRequest.tokenReturn()
            .then()
            .statusCode(200)
            .body("token", notNullValue());


    }
}
