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

    private static final String SPECIFIC_PRODUCT_URL = "https://www.falabella.com.co/falabella-co/category/cat910963/Celulares-y-Telefonos?isPLP=1";
    private static final String SHOPPING_CART_URL = "https://www.falabella.com.co/falabella-co/basket";

    private DriverFacade drivenHelper;
    private ProductsPage productsPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;


    public ShoppingCartSteps() {
        drivenHelper = new DriverFacade(DriverFactory.getDriver());
        productsPage = new ProductsPage(DriverFactory.getDriver());
        productPage = new ProductPage(DriverFactory.getDriver());
        shoppingCartPage = new ShoppingCartPage(DriverFactory.getDriver());
    }

    @Given("I am in a product page")
    public void iAmInAProductPage() {
        drivenHelper.openPage(SPECIFIC_PRODUCT_URL);
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
        drivenHelper.openPage(SHOPPING_CART_URL);
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
