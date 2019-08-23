package utils.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DrivenHelper {

    public static WebDriver getDriver(){
       String driverName=ConfigurationHelper.readConfiguration();
        WebDriver driver =null;
        if (driverName.equals("Chrome")) {//enum
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
