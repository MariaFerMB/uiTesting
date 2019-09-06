package steps;

import cucumber.api.java.en.Given;
import helper.DriverFacade;


public class CommonSteps {

    private static final String HOME_PAGE_URL = "https://www.falabella.com.co/falabella-co/";
    private final DriverFacade drivenHelper;


    public CommonSteps() {
        drivenHelper = new DriverFacade(Hook.driver);

    }

    @Given("I am in the Falabella homepage$")
    public void stayInFalabellaHomePage() {
        drivenHelper.openPage(HOME_PAGE_URL);

    }


}
