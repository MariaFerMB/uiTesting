package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.DriverFacade;
import pages.ProductPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;
import utils.DriverFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ShoppingCartSteps {

    private ProductsPage productsPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;


    public ShoppingCartSteps() {
        productsPage = new ProductsPage(DriverFactory.getDriver());
        productPage = new ProductPage(DriverFactory.getDriver());
        shoppingCartPage = new ShoppingCartPage(DriverFactory.getDriver());
    }

    @Given("I am in a product page")
    public void iAmInAProductPage() {
        productsPage.openProduct();
    }

    @When("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        productPage.addShoppingCartProduct();
    }

    @Then("I should see a pop up with the confirmation")
    public void iShouldSeeAPopUpWithTheConfirmation() {
        assertThat(productPage.getAddProductConfirmationMessage(), equalTo("Agregado"));
    }

    @And("I go to the shopping cart page")
    public void iHaveAProductInMyShoppingCart() {
        shoppingCartPage.openPage();
    }

    @And("I delete the product")
    public void iDeleteTheProduct() {
        shoppingCartPage.deleteProduct();
    }


    @Then("I should see a message: ([^\"]*)")
    public void iShouldSeeAMessage(String message) {
        assertThat(shoppingCartPage.getEmptyShoppingCartMessage(), equalTo(message));
    }
}
