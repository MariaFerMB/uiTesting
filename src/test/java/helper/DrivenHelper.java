package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class DrivenHelper {

    private static int WAIT_TIME =11;
    private WebDriver driver;

    public DrivenHelper(WebDriver driver){
        this.driver=driver;
    }

    public void waitVisible(WebElement webElement){
        WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_TIME);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public List<WebElement> fineElementsByXpath(WebElement webElement, String xpath){
        return webElement.findElements(By.xpath(xpath));
    }

    public void openPage(String url){
        driver.get(url);
    }









}
