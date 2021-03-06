package br.com.restassuredapitesting.runner;

import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.tests.auth.tests.PostAuthTest;
import br.com.restassuredapitesting.tests.booking.tests.AcceptanceTest;
import br.com.restassuredapitesting.tests.booking.tests.DeleteBookingTest;
import br.com.restassuredapitesting.tests.booking.tests.GetBookingTest;
import br.com.restassuredapitesting.tests.booking.tests.PutBookingTest;
import br.com.restassuredapitesting.tests.ping.tests.GetPingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitesting.suites.AllTestes.class)
@Suite.SuiteClasses({
        GetPingTest.class,
        GetBookingTest.class,
        PostAuthTest.class,
        PutBookingTest.class,
        DeleteBookingTest.class,
        AcceptanceTest.class,
})


public class AllTestes {
}
