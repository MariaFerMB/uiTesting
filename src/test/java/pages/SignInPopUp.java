package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPopUp extends BasePage {

    @FindBy(id = "emailAddress")
    private WebElement emailCamp;

    @FindBy(name = "password")
    private WebElement passwordCamp;

    @FindBy(xpath = "//*[@class='Button__main__1NDc9 Button__green__1fhy5']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@class='Login__errorBlock__3q25u']")
    private  WebElement errorMessage;


    public SignInPopUp(WebDriver driver) {
        super(driver);
    }


    public void singIn(String email,String password){
        emailCamp.sendKeys(email);
        passwordCamp.sendKeys(password);
        clickElement(signInButton);//bilder
    }


    public boolean seeErrorMessage(){
        drivenHelper.waitVisible(errorMessage );
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
//        webDriverWait.until(ExpectedConditions.visibilityOf(errorMessage)); //verificar el string
//              //  .numberOfElementsToBeMoreThan(By.xpath("//*[@class='Login__errorBlock__3q25u']"),0));
        if(errorMessage !=null){
            return true;
        }
        else {
            return false;
        }

    }





}
