package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.VerifyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SignOutSteps {

    private HomePage homePage;


    public SignOutSteps() {

        homePage = new HomePage(Hook.driver);
    }


    @When("I sign out$")
    public void singInValid(){
        homePage.signOut();
    }


    @Then("I should see the sign out message: {string}")
    public void iShouldSeeTheSignOutMessage(String signOutMessage) {
        assertThat(homePage.getSingOutMessage(), equalTo(signOutMessage));
    }
}
