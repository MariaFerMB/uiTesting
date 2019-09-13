package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory {

    private static final String DRIVER_PROPERTIES = "src/test/resources/data/driver.properties";

    private static WebDriver driver;

    private static Properties readConfiguration() {
        Properties prop = new Properties();
        try {
            InputStream fileInput = new FileInputStream(DRIVER_PROPERTIES);
            prop = new Properties();
            prop.load(fileInput);
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * Create and return a specific web driver.
     * If is necesary create  the web driver, the method read a property to define what type
     * @return A specific web driver
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            Properties prop = readConfiguration();
            String driverName = prop.getProperty("driver");

            if (driverName.equals("Chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
            }
        }

        return driver;
    }

    public static void deleteDriver() {
        driver.quit();
        driver = null;
    }
}
