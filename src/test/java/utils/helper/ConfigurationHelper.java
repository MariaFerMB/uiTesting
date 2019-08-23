package utils.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationHelper {


    public static String readConfiguration(){
        String respond =null;

        try {
            InputStream fileInput = new FileInputStream("src/test/resources/configuration/configuration1.properties"); //constante dinamico
            Properties prop = new Properties();
            prop.load(fileInput);
            respond = prop.getProperty("driven");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respond;

    }

}
