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

    private static Properties readConfiguration(String filePath) {
        Properties prop = new Properties();
        try {
            InputStream fileInput = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fileInput);
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            Properties prop = readConfiguration(DRIVER_PROPERTIES);
            String driverName = prop.getProperty("driver");

            if (driverName.equals("Chrome")) {//enum
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
            }
        }

        return driver;
    }

    public static void deleteDriver(){
        driver.quit();
        driver = null;
    }
}
