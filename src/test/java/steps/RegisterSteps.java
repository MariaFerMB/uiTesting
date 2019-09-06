package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.RegisterPage;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class RegisterSteps {

    private HomePage homePage;
    private RegisterPage registerPage;

    public RegisterSteps() {
        homePage = new HomePage(Hook.driver);
        registerPage = new RegisterPage(Hook.driver);
    }

    @When("I try to register")
    public void iTryToRegister() {
        homePage.openRegister();
    }


    @And("I fill all the field except for \"celular\"")
    public void iFillAllTheFieldExceptFor(Map<String, String> data) {
        registerPage.fillForm(data);

    }

    @And("I try to save my data")
    public void iTryToSaveMyData() {
        registerPage.saveData();
    }

    @Then("I should see a error message: ([^\"]*)")
    public void iShouldSeeAErrorMessage(String errorMessage) {
        assertThat(registerPage.getCelVacioMenssage(), equalTo(errorMessage));
    }
}
