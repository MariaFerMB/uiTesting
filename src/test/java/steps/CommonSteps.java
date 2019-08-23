package steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.HomePage;


public class CommonSteps {

   // private HomePage homePage;
    private WebDriver driver;

    public CommonSteps(){
        driver =Hook.driver;
        //homePage =new HomePage(driver);
    }

    @Given("I am in the Falabella homepage$")
    public void stayInFalabellaHomePage(){
        Hook.driver.get("https://www.falabella.com.co/falabella-co/");
    }


}
