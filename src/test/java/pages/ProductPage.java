package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//*[@class='fb-btn fb-btn-primary fb-product-cta__controls--actions--choose full-width-btn']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id='fb-overlay']//*[@class='fb-overlay__inject']")
    private WebElement pop;


    private ConfirmationProductPopUp confirmationProductPopUp;

    public ProductPage(WebDriver driver) {
        super(driver);
        confirmationProductPopUp = new ConfirmationProductPopUp(driver);
    }

    public void addShoppingCartProduct() {
        drivenHelper.waitVisible(addToCartButton);
        addToCartButton.click();
        drivenHelper.waitVisible(pop);
    }

    public String getAddProductConfirmationMessage() {
        return confirmationProductPopUp.getConfirmationTitle();
    }

}
