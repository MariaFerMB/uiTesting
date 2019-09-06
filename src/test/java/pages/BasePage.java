package pages;

import helper.DriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

class BasePage {

    protected final DriverFacade drivenHelper;

    BasePage(WebDriver driver) {
        drivenHelper = new DriverFacade(driver);
        PageFactory.initElements(driver, this);
    }

}
