package pages;

import helper.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

 class BasePage {

    protected DriverHelper drivenHelper;

    BasePage(WebDriver driver){
        drivenHelper = new DriverHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public String getText(WebElement element){
        return element.getText();
    }


}
