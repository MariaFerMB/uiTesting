package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.Configuration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SignInSteps {

    private HomePage homePage;

    public SignInSteps() {
        homePage = new HomePage(Hook.driver);
    }

    @When("I sign in with valid credentials$")
    public void singInWithValidCredentials(){
        homePage.signIn("challengecorreo@gmail.com","clavechallenge");
    }

    @When("I sign in with invalid credentials$")
    public void singInWithInvalidCredentials(){
        homePage.signIn("challenge@gmail.com","clavechallenge");
    }

    @Then("I should be signed in$")
    public void shouldBeSignedIn(){
        assertThat(homePage.verifySingIn(), equalTo("Bienvenid@,"+"\n"+ "David"));
    } //remplazar

    @Then("I should see a sign in error$")
    public void shouldSeeSignedInError(){
        assertThat(homePage.verifyNotSignIn(), equalTo(Configuration.error));
    }



}
