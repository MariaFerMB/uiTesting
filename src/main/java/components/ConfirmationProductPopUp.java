package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class ConfirmationProductPopUp extends PageObject {

    @FindBy(xpath = "//*[@id='fb-overlay']//*[@class='fb-added-to-basket__title']")
    private WebElement confirmationTitle;


    public ConfirmationProductPopUp(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationTitle() {
        return confirmationTitle.getText();
    }
}
