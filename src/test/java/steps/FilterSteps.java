package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.ProductsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FilterSteps {
    private HomePage homePage;
    private ProductsPage productsPage;


    public FilterSteps() {
        homePage = new HomePage(Hook.driver);
        productsPage = new ProductsPage(Hook.driver);
    }

    @And("I search for {string}")
    public void iSearchFor(String search) {
        homePage.search(search);
    }

    @When("I apply the filter for {string} between {string} and {string}")
    public void iApplyTheFilterForPriceBetweenAnd(String filterName, String start, String end) {
        productsPage.applyPriceFilter(filterName, start, end);
    }

    @Then("I should see just products with prices between {int} and {int}")
    public void iShouldSeeJustProductsWithPricesInThisRange(int start, int end) {
        assertThat(productsPage.verifyPriceFilter(start, end), equalTo(true));

    }

}
