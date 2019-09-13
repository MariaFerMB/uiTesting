package utils;

import helper.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected final DriverFacade drivenFacade;

    protected PageObject(WebDriver driver) {
        drivenFacade = new DriverFacade(driver);
        PageFactory.initElements(driver, this);
    }

    protected void sendKeys(WebElement webElement, String value) {
        webElement.clear();
        webElement.sendKeys(value);
    }

}
