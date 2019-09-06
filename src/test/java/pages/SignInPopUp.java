package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

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
    private WebElement errorMessage;


    SignInPopUp(WebDriver driver) {
        super(driver);

    }


    void signIn(Map<String,String> signInData) {
        emailCamp.sendKeys(signInData.get("Email"));
        passwordCamp.sendKeys(signInData.get("Password"));
        signInButton.click();
    }

    String getErrorMessage() {
        drivenHelper.waitVisible(errorMessage);
        return errorMessage.getText();
    }

    void openRegister() {
        registerLink.click();
    }

}