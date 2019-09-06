package steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utils.Configuration;

public class Hook {

    public static WebDriver driver;
    private static final String DRIVER_PROPERTIES = "src/test/resources/data/driver.properties";

    @Before
    public void setup() {
        driver = Configuration.getDriver(DRIVER_PROPERTIES);
    }

    @After
    public void close() {
        driver.quit();
    }
}
