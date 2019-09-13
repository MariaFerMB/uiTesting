package pages;

import components.ConfirmationProductPopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//*[@class='fb-btn fb-btn-primary fb-product-cta__controls--actions--choose full-width-btn']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id='fb-overlay']//*[@class='fb-overlay__inject']")
    private WebElement productPopUp;


    private final ConfirmationProductPopUp confirmationProductPopUp;

    public ProductPage(WebDriver driver) {
        super(driver);
        confirmationProductPopUp = new ConfirmationProductPopUp(driver);
    }

    /**
     * Add the product of the shopping cart
     * Wait for the appear of confirmation pop-up
     */
    public void addShoppingCartProduct() {
        drivenFacade.waitVisible(addToCartButton);
        addToCartButton.click();
        drivenFacade.waitVisible(productPopUp);
    }

    public String getAddProductConfirmationMessage() {
        return confirmationProductPopUp.getConfirmationTitle();
    }

}
