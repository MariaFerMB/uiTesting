package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

import java.util.Map;

public class SignInPopUp extends PageObject {

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


    public SignInPopUp(WebDriver driver) {
        super(driver);
    }


    /**
     * Do sign in with credentials
     * @param signInData A map with the email and password
     */
    public void signIn(Map<String, String> signInData) {
        sendKeys(emailCamp, signInData.get("Email"));
        sendKeys(passwordCamp, signInData.get("Password"));
        signInButton.click();
    }

    public String getErrorMessage() {
        drivenFacade.waitVisible(errorMessage);
        return errorMessage.getText();
    }

    /**
     * Click in register button to open the form
     */
    public void openRegister() {
        registerLink.click();
    }

}