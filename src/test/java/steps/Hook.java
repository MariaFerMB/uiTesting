package steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverFactory;

public class Hook {


    @Before
    public void setup() {
       // driver = DriverFactory.getDriver();
    }

    @After
    public void close() {
        DriverFactory.deleteDriver();
    }
}
