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
    private WebDriver driver;

    public SignOutSteps() {
        driver =Hook.driver;
        homePage = new HomePage(driver);
    }


    @When("I sign out$")
    public void singInValid(){
        homePage.signOut();
    }

    @Then("I should be signed out$")
    public void showSignedIn(){
        String filePath ="src/test/resources/data/verifyMessage/signOutMessage.properties";
        assertThat(homePage.verifySingOut(), equalTo(VerifyMessage.getVerifyMessage(filePath)));
    }


}
