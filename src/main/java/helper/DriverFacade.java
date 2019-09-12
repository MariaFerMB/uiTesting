package helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFacade {

    private static final int WAIT_TIME = 11;
    private WebDriver driver;

    public DriverFacade(WebDriver driver) {
        this.driver = driver;
    }

    public void waitVisible(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_TIME);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement findBY(By by){
       return (WebElement) driver.findElements(by);
    }

    public void openPage(String url) {
        driver.get(url);
    }


}
