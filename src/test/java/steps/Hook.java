package steps;


import cucumber.api.java.After;
import utils.DriverFactory;

public class Hook {

    @After
    public void close() {
        DriverFactory.deleteDriver();
    }
}
