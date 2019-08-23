package steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utils.helper.DrivenHelper;

public class Hook {

    public static WebDriver driver;

    @Before
    public void setup(){
        driver = DrivenHelper.getDriver();
    }

    @After
    public void close(){
        driver.quit();
    }
}
