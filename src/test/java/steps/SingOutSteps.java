package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SingOutSteps {

    private HomePage homePage;
    private WebDriver driver;

    public SingOutSteps() {
        driver =Hook.driver;
        homePage = new HomePage(driver);
    }


    @When("I sign out$")
    public void singInValid(){
        homePage.signOut();
    }

    @Then("I should be signed out$")
    public void showSignedIn(){
        assertThat(homePage.verifySingOut(), equalTo("Inicia sesión"));
    }


}
