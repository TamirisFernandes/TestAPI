package br.com.restassuredapitesting.runner;

import br.com.restassuredapitesting.tests.booking.tests.DeleteBookingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitesting.suites.AcceptanceTests.class)
@Suite.SuiteClasses({

        //Excluir um reserva com sucesso
        DeleteBookingTest.class,
        AcceptanceTests.class,
})
public class AcceptanceTests {
}
