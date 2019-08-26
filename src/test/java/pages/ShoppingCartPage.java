package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath =  "//*[@class='fb-product__action-list__item fb-product__action-list__item--delete js-product__action-list--delete']")
    private WebElement deleteLink;

    @FindBy(xpath =  "//*[@id='fb-basket-products']//*[@class='fb-order-status__empty-basket']")
    private WebElement emptyShoppingCartMessage;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void deleteProduct(){
        clickElement(deleteLink);
        drivenHelper.waitVisible(emptyShoppingCartMessage);
    }

    public String  getEmptyShoppingCartMessage(){
        drivenHelper.waitVisible(emptyShoppingCartMessage);
        return emptyShoppingCartMessage.getText();
    }



}
