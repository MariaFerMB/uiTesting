package helper;

import utils.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RegisterHelper {

    //private static String registerDataFile = "src/test/resources/data/registerData.properties";

    private String userName;
    private  String fatherLastName;
    private  String motherLastName;
    private  String registerEmail;
    private  String registerPassword;
    private  String verifyRegisterPassword;
    private  String country;
    private  String documentType;
    private  String documentNumber;
    private  String genre;
    private  String birthday;
    private  String birthDay ="";
    private  String birthMonth="";
    private  String birthYear="";
    private  String cellPhone;

    public String getBirthDay() {
        return birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    /*public static String getRegisterDataFile() {
        return registerDataFile;
    }*/

    public String getUserName() {
        return userName;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public String getRegisterEmail() {
        return registerEmail;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }

    public String getVerifyRegisterPassword() {
        return verifyRegisterPassword;
    }

    public String getCountry() {
        return country;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getGenre() {
        return genre;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public RegisterHelper(String dataFilePath){
            Properties prop = Configuration.readConfiguration(dataFilePath);
            userName = prop.getProperty("userName");
            fatherLastName = prop.getProperty("fatherLastName");
            motherLastName = prop.getProperty("motherLastName");
            registerEmail = prop.getProperty("registerEmail");
            registerPassword = prop.getProperty("registerPassword");
            verifyRegisterPassword = prop.getProperty("verifyRegisterPassword");
            country = prop.getProperty("country");
            documentType = prop.getProperty("documentType");
            documentNumber = prop.getProperty("documentNumber");
            genre = prop.getProperty("genre");
            birthday = prop.getProperty("birthday");
            separateDate(birthday);
            cellPhone = prop.getProperty("cellPhone");
    }

    private void separateDate(String date){
        if (date!=null && !date.equals("")){
            String[] dateCamp = date.split("-");
            birthDay=dateCamp[0];
            birthMonth =dateCamp[1];
            birthYear =dateCamp[2];
        }
    }
}
