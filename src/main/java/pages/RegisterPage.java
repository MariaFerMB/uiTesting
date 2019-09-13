package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;
import java.util.Set;

public class RegisterPage extends BasePage {

    @FindBy(id = "user")
    private WebElement userCamp;

    @FindBy(id = "apellidopaterno")
    private WebElement fatherLastNameCamp;

    @FindBy(id = "apellidomaterno")
    private WebElement motherLastNameCamp;

    @FindBy(name = "mail")
    private WebElement emailCamp;

    @FindBy(id = "clave1")
    private WebElement passwordCamp;

    @FindBy(id = "clave2")
    private WebElement verifyPasswordCamp;

    @FindBy(id = "status")
    private WebElement countryCamp;

    @FindBy(id = "cedula")
    private WebElement documentTypeCamp;

    @FindBy(name = "/atg/userprofiling/ProfileFormHandler.value.documentNumber")
    private WebElement documentNumberCamp;

    @FindBy(xpath = "//*[@value='male']")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//*[@value='female']")
    private WebElement femaleRadioButton;

    @FindBy(id = "day")
    private WebElement birthDaySelector;

    @FindBy(id = "month")
    private WebElement birthMonthSelector;

    @FindBy(id = "year")
    private WebElement birthYearSelector;

    @FindBy(id = "celular")
    private WebElement cellphoneCamp;

    @FindBy(id = "boton_Ar")
    private WebElement saveButton;

    @FindBy(id = "mensajeCelVacio")
    private WebElement voidCellphoneMessage;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Write a specific information in a camp of the register format
     * @param campName name of the camp that will be fill
     * @param value information to fill the camp
     */
    private void fillFormCamp(String campName, String value) {
        switch (campName) {
            case "User name":
                sendKeys(userCamp, value);
                break;
            case "Father last name":
                sendKeys(fatherLastNameCamp, value);
                break;
            case "Mother last name":
                sendKeys(motherLastNameCamp, value);
                break;
            case "Email":
                sendKeys(emailCamp, value);
                break;
            case "Password":
                sendKeys(passwordCamp, value);
                break;
            case "Verify password":
                sendKeys(verifyPasswordCamp, value);
                break;
            case "Country":
                countryCamp.sendKeys(value);
                break;
            case "Document type":
                documentTypeCamp.sendKeys(value);
                break;
            case "Document number":
                sendKeys(documentNumberCamp, value);
                break;
            case "Gender":
                selectGender(value);
                break;
            case "Birth day":
                birthDaySelector.sendKeys(value);
                break;
            case "Birth month":
                birthMonthSelector.sendKeys(value);
                break;
            case "Birth year":
                birthYearSelector.sendKeys(value);
                break;

        }
    }


    /**
     * Fill all the camps tha are in the map
     * @param mapData camps and values of th register form
     */
    public void fillForm(Map<String, String> mapData) {

        Set<String> mapKeys = mapData.keySet();

        for (String key : mapKeys) {
            String value = mapData.get(key);
            if (value != null) {
                fillFormCamp(key, value);
            }

        }
    }

    public void saveData() {
        saveButton.click();
    }

    public String getVoidCellphoneMessage() {
        drivenFacade.waitVisible(voidCellphoneMessage);
        return voidCellphoneMessage.getText();
    }

    /**
     * Choose the gender in the register form
     * @param gender the gender that will be select
     */
    private void selectGender(String gender) {
        if (gender != null && !gender.equals("")) {
            if (gender.equals("Female")) {
                femaleRadioButton.click();
            } else if (gender.equals("Male")) {
                maleRadioButton.click();

            }
        }


    }


}
