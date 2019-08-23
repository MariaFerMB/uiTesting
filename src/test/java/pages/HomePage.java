package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(className = "icon-logo fb-masthed__util-bar__icon")
    private WebElement logo;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLogo(){
        return logo.getText();
    }

}
