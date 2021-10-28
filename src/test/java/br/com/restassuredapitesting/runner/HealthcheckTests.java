package br.com.restassuredapitesting.runner;


import br.com.restassuredapitesting.tests.ping.tests.GetPingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitesting.suites.HealthcheckTests.class)
@Suite.SuiteClasses({
        GetPingTest.class

})
//Verificar se API está online
public class HealthcheckTests {
}
