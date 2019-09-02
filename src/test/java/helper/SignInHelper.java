package helper;

import utils.Configuration;
import java.util.Properties;

public class SignInHelper {

    private String email;
    private String password;

    public SignInHelper(String dataFilePath) {
        Properties prop = Configuration.readConfiguration(dataFilePath);
        email = prop.getProperty("email");
        password = prop.getProperty("password");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
