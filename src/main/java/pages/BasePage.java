package pages;

import org.openqa.selenium.WebDriver;
import utils.PageObject;

abstract class BasePage extends PageObject {


    BasePage(WebDriver driver) {
        super(driver);

    }

}
