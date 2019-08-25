package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.DrivenHelper;
import pages.ProductPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;
import utils.Configuration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ShoppingCartSteps {
    private DrivenHelper drivenHelper;
    private ProductsPage productsPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;


    public ShoppingCartSteps() {
        drivenHelper = new DrivenHelper(Hook.driver);
        productsPage = new ProductsPage(Hook.driver);
        productPage = new ProductPage(Hook.driver);
        shoppingCartPage = new ShoppingCartPage(Hook.driver);
    }

    @Given("I am in a product page")
    public void iAmInAProductPage() {
        drivenHelper.openPage("https://www.falabella.com.co/falabella-co/category/cat910963/Celulares-y-Telefonos?isPLP=1");
        productsPage.opendProduct();
    }

    @When("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        productPage.addShoppingCartProduct();
    }

    @Then("I should see a pop up with the confirmation")
    public void iShouldSeeAPopUpWithTheConfirmation() {
        assertThat(productPage.getAddProductConfirmationMessage(), equalTo("Agregado"));
    }

    @Given("I have a product in my shopping cart")
    public void iHaveAProductInMyShoppingCart() {
        iAmInAProductPage();
        iAddTheProductToTheCart();
        drivenHelper.openPage("https://www.falabella.com.co/falabella-co/basket");
    }

    @When("I delete the product")
    public void iDeleteTheProduct() {
        shoppingCartPage.deleteProduct();
    }

    @Then("I should see a message saying that my cart is empty")
    public void iShouldSeeAMessageSayingThatMyCartIsEmpty() {
        assertThat(shoppingCartPage.getEmptyShoppingCartMessage(), equalTo(Configuration.empty));
    }


}
