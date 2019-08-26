package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utils.VerifyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SignInSteps {

    private HomePage homePage;

    public SignInSteps() {
        homePage = new HomePage(Hook.driver);
    }

    @When("I sign in with valid credentials$")
    public void singInWithValidCredentials(){
        homePage.signIn("src/test/resources/data/validCredentials.properties");
    }

    @When("I sign in with invalid credentials$")
    public void singInWithInvalidCredentials(){
        homePage.signIn("src/test/resources/data/invalidCredentials.properties");
    }

    @Then("I should be signed in$")
    public void shouldBeSignedIn(){
        String filePath ="src/test/resources/data/verifyMessage/signMessage.properties";
        assertThat(homePage.verifySingIn(), equalTo(VerifyMessage.getVerifyMessage(filePath)));
    }

    @Then("I should see a sign in error$")
    public void shouldSeeSignedInError(){
        String filePath ="src/test/resources/data/verifyMessage/errorSignInMessage.properties";
        assertThat(homePage.verifyNotSignIn(), equalTo(VerifyMessage.getVerifyMessage(filePath)));
    }



}
