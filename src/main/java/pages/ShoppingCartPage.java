package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    private static final String SHOPPING_CART_URL = "https://www.falabella.com.co/falabella-co/basket";


    @FindBy(xpath = "//*[@class='fb-product__action-list__item fb-product__action-list__item--delete js-product__action-list--delete']")
    private WebElement deleteLink;

    @FindBy(xpath = "//*[@id='fb-basket-products']//*[@class='fb-order-status__empty-basket']")
    private WebElement emptyShoppingCartMessage;

    @FindBy(xpath = "//*[@class='fb-order-status__subtitle']}")
    private WebElement numberProducts;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        drivenFacade.openPage(SHOPPING_CART_URL);
    }

    public void deleteProduct() {
        deleteLink.click();
        drivenFacade.waitVisible(emptyShoppingCartMessage);
    }

    public String getEmptyShoppingCartMessage() {
        drivenFacade.waitVisible(emptyShoppingCartMessage);
        return emptyShoppingCartMessage.getText().replaceAll("\\n", "");
    }


}
