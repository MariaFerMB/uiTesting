package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static String configurationPath = "src/test/resources/configuration/configuration1.properties";
    private  WebDriver driver;

    public static String readConfiguration(){
        String respond =null;
        try {
            InputStream fileInput = new FileInputStream(configurationPath); //dinamico
            Properties prop = new Properties();
            prop.load(fileInput);
            respond = prop.getProperty("driven");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respond;
    }

    public static WebDriver getDriver(){
        //if (driver==null){
            String driverName= readConfiguration();
            WebDriver driver =null;

            if (driverName.equals("Chrome")) {//enum
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
            }
        //}
        return driver;
    }





}
