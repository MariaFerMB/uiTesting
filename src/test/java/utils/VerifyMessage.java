package utils;

import java.util.Properties;

public class VerifyMessage {


    public static String getVerifyMessage(String dataFilePath) {
        Properties prop = Configuration.readConfiguration(dataFilePath);
        return  prop.getProperty("message");
    }
}
