package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPopUp extends BasePage {

    @FindBy(id = "emailAddress")
    private WebElement emailCamp;

    @FindBy(name = "password")
    private WebElement passwordCamp;

    @FindBy(xpath = "//*[@href='/falabella-co/myaccount/register.jsp']")
    private WebElement registerLink;

    @FindBy(xpath = "//*[@class='Button__main__1NDc9 Button__green__1fhy5']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@class='Login__errorText__13IML']")
    private  WebElement errorMessage;


    public SignInPopUp(WebDriver driver) {
        super(driver);
    }


    public void singIn(String email,String password){
        emailCamp.sendKeys(email);
        passwordCamp.sendKeys(password);
        clickElement(signInButton);//bilder
    }

    public String getErrorMessage(){
        drivenHelper.waitVisible(errorMessage );
        return errorMessage.getText();
    }
    public void openRegister(){
        clickElement(registerLink);
    }
}