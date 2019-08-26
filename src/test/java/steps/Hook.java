package steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utils.Configuration;

public class Hook {

    public static WebDriver driver;

    @Before
    public void setup(){
        driver = Configuration.getDriver("src/test/resources/data/driver.properties");
    }
    @After
    public void close(){
        driver.quit();
    }
}
