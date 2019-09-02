package steps;

import cucumber.api.java.en.Given;
import helper.DriverHelper;


public class CommonSteps {

    private final DriverHelper drivenHelper;

    public CommonSteps() {
        drivenHelper = new DriverHelper(Hook.driver);

    }

    @Given("I am in the Falabella homepage$")
    public void stayInFalabellaHomePage(){
        drivenHelper.openPage("https://www.falabella.com.co/falabella-co/");

    }


}
