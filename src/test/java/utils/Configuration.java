package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static String configurationPath = "src/test/resources/data/configuration1.properties";
    public static String error;
    public  static String empty;
    public static String signInMessage;

    public static String readConfiguration(){
        String respond =null;
        try {
            InputStream fileInput = new FileInputStream(configurationPath); //dinamico
            Properties prop = new Properties();
            prop.load(fileInput);
            error = prop.getProperty("error");
            empty =prop.getProperty("empty");
            signInMessage=prop.getProperty("singIn");
            respond = prop.getProperty("driven");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respond;
    }

    public static WebDriver getDriver(){
            String driverName= readConfiguration();
            WebDriver driver =null;

            if (driverName.equals("Chrome")) {//enum
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
            }
        return driver;
    }





}
