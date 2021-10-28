package br.com.restassuredapitesting.runner;

import br.com.restassuredapitesting.tests.auth.tests.PostAuthTest;
import br.com.restassuredapitesting.tests.booking.tests.GetBookingTest;
import br.com.restassuredapitesting.tests.booking.tests.PutBookingTest;
import br.com.restassuredapitesting.tests.ping.tests.GetPingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitesting.suites.SchemaTests.class)
@Suite.SuiteClasses({
    //Garantir o schema do retorno da lista de reservas
        //Garantir o schema do retorno de uma reserva específica
        GetBookingTest.class


})
public class SchemaTests {
}
