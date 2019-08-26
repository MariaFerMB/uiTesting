package pages;

import helper.RegisterHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    private RegisterHelper registerHelper;

    @FindBy(id = "user")
    private WebElement userCamp;

    @FindBy(id = "apellidopaterno")
    private WebElement apellidopaternoCamp;

    @FindBy(id = "apellidomaterno")
    private WebElement apellidomaternoCamp;

    @FindBy(name = "mail")
    private WebElement mailCamp;

    @FindBy(id = "clave1")
    private WebElement clave1Camp;

    @FindBy(id = "clave2")
    private WebElement clave2Camp;

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
    private WebElement brithDaySelector;

    @FindBy(id = "month")
    private WebElement brithMonthSelector;

    @FindBy(id = "year")
    private WebElement brithYearSelector;

    @FindBy(id = "celular")
    private WebElement cellphoneCamp;

    @FindBy(id = "agreelegaleId")
    private WebElement agreeLegaleCheckbox;

    @FindBy(id = "boton_Ar")
    private WebElement saveButton;

    @FindBy(id = "mensajeCelVacio")
    private WebElement voidCellphoneMenssage;


    public RegisterPage(WebDriver driver, String dataFilePath) {
        super(driver);
        registerHelper =new RegisterHelper(dataFilePath); //puedo pasar la ruta
    }


    public void fillForm(){
        userCamp.sendKeys(registerHelper.getUserName());
        apellidopaternoCamp.sendKeys(registerHelper.getFatherLastName());
        apellidomaternoCamp.sendKeys(registerHelper.getMotherLastName());
        mailCamp.sendKeys(registerHelper.getRegisterEmail());
        clave1Camp.sendKeys(registerHelper.getRegisterPassword());
        clave2Camp.sendKeys(registerHelper.getVerifyRegisterPassword());
        countryCamp.sendKeys(registerHelper.getCountry());
        documentTypeCamp.sendKeys(registerHelper.getDocumentType());
        documentNumberCamp.sendKeys(registerHelper.getDocumentNumber());
        selectGener(registerHelper.getGenre());
        brithDaySelector.sendKeys(registerHelper.getBirthDay());
        brithMonthSelector.sendKeys(registerHelper.getBirthMonth());
        brithYearSelector.sendKeys(registerHelper.getBirthYear());
        cellphoneCamp.sendKeys(registerHelper.getCellPhone());

    }
    public void saveData(){
         saveButton.click();
    }
    public  String getCelVacioMenssage(){
       drivenHelper.waitVisible(voidCellphoneMenssage);
       return voidCellphoneMenssage.getText();
    }

    private void selectGener(String gener){
        if(gener!=null && !gener.equals("")){
            if (gener.equals("Female")){
                femaleRadioButton.click();
            }
            else if (gener.equals("Male")){
                maleRadioButton.click();

            }
        }


    }


}
