package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utils.DriverFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SignOutSteps {

    private HomePage homePage;


    public SignOutSteps() {
        homePage = new HomePage(DriverFactory.getDriver());
    }


    @When("I click in the sign out button$")
    public void singOut() {
        homePage.signOut();
    }


    @Then("I should see the sign out message: {string}")
    public void iShouldSeeTheSignOutMessage(String signOutMessage) {
        assertThat(homePage.getSignOutMessage(), equalTo(signOutMessage));
    }
}
