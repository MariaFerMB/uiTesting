package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utils.DriverFactory;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SignInSteps {

    private HomePage homePage;

    public SignInSteps() {
        homePage = new HomePage(DriverFactory.getDriver());
    }

    @When("I sign in with the next credentials$")
    public void singInWithCredentials(Map<String, String> data) {
        homePage.signIn(data);
    }


    @Then("I should see the sign in error message: ([^\"]*)")
    public void iShouldSeeTheSignInErrorMessage(String errorMessage) {
        assertThat(homePage.getSignInErrorMessage(), equalTo(errorMessage));
    }

    @Then("I should see the sign in message: {string}")
    public void iShouldSeeTheSignInMessage(String signMessage) {
        assertThat(homePage.getSignInMessage(), equalTo(signMessage));
    }


}
