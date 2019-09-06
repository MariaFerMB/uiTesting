package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {


    public static Properties readConfiguration(String filePath) {
        Properties prop = new Properties();
        try {
            InputStream fileInput = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static WebDriver getDriver(String filePath) {
        Properties prop = readConfiguration(filePath);
        String driverName = prop.getProperty("driven");
        WebDriver driver = null;
        if (driverName.equals("Chrome")) {//enum
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
        return driver;
    }


}
