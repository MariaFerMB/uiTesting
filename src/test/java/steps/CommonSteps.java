package steps;

import cucumber.api.java.en.Given;
import pages.HomePage;


public class CommonSteps {

    private HomePage homePage;

    public CommonSteps(){
        homePage =new HomePage(Hook.driver);
    }



    @Given("I am in the Falabella homepage$")
    public void stayInFalabellaHomePage(){
       // Hook.driver.get("https://www.falabella.com.co/falabella-co/");
        String lol ="lol";
        System.out.println(lol);

    }


}
