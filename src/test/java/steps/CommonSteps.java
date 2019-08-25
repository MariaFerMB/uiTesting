package steps;

import cucumber.api.java.en.Given;
import helper.DrivenHelper;


public class CommonSteps {

    private DrivenHelper drivenHelper;

    public CommonSteps() {
        drivenHelper = new DrivenHelper(Hook.driver);

    }

    @Given("I am in the Falabella homepage$")
    public void stayInFalabellaHomePage(){
        drivenHelper.openPage("https://www.falabella.com.co/falabella-co/");

    }


}
