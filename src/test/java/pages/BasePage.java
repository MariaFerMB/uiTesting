package pages;

import helper.DrivenHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected DrivenHelper drivenHelper;

    public BasePage(WebDriver driver){
        drivenHelper = new DrivenHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public String getText(WebElement element){
        return element.getText();
    }


}
