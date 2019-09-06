package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverHelper {

    private static final int WAIT_TIME =11;
    private WebDriver driver;

    public DriverHelper(WebDriver driver){
        this.driver=driver;
    }

    public void waitVisible(WebElement webElement){
        WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_TIME);
        webDriverWait.
                until(ExpectedConditions.visibilityOf(webElement));
    }

    public void openPage(String url){
        driver.get(url);
    }









}
