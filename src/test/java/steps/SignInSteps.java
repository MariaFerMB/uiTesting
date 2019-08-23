package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SignInSteps {
    private HomePage homePage;
    private WebDriver driver;


    public SignInSteps() {
        driver =Hook.driver;
        homePage = new HomePage(driver);
    }

    @When("I sign in with valid credentials$")
    public void singInValid(){
        homePage.signIn("challengecorreo@gmail.com","clavechallenge");
    }

    @When("I sign in with invalid credentials$")
    public void singInInvalid(){
        homePage.signIn("challenge@gmail.com","clavechallenge");
    }

    @Then("I should be signed in$")
    public void beSignedIn(){
        assertThat(homePage.verifySingIn(), equalTo("Bienvenid@,"+"\n"+ "David"));
    }

    @Then("I should see a sign in error$")
    public void showErrorSignedIn(){
        assertThat(homePage.verifyNotSignIn(), equalTo(true));
    }



}
