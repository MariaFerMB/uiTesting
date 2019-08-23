package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    @FindBy(className = "icon-logo fb-masthed__util-bar__icon")
    private WebElement logo;

    @FindBy(id = "header-login-modal")
    private WebElement signInElemente;

    @FindBy(id = "header-login-modal")
    private WebElement userNAme;

    @FindBy(xpath = "//*[@class='fb-masthead-login__name re-design-cl__name']")
    private WebElement singInMessage;

    @FindBy(xpath = "//*[@class='fb-filter-header__log-out']")
    private WebElement signOutbutton;

    @FindBy(xpath = "//*[@class='fb-masthead-login__name re-design-cl__name login-redesing_logout-box']")
    private WebElement singOutMessage;

    private SignInPopUp signInPopUp;

    public HomePage(WebDriver driver) {
        super(driver);
        signInPopUp =new SignInPopUp(driver);
    }

    public void signIn(String email, String password){
        clickElemente(signInElemente);
        signInPopUp.singIn(email,password);
    }


    public String verifySingIn() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
        webDriverWait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.xpath("//*[@class='fb-masthead-login__name re-design-cl__name']"),0));
        return  getText(singInMessage);
    }

    public String verifySingOut() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
        webDriverWait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.xpath("//*[@class='fb-masthead-login__name re-design-cl__name login-redesing_logout-box']"),0));
        return  getText(singOutMessage);
    }


    public boolean verifyNotSignIn(){
        return signInPopUp.seeErrorMessage();
    }

    public void signOut(){

        //Repetido
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
        webDriverWait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.xpath("//*[@class='fb-masthead-login__name re-design-cl__name']"),0));
        clickElemente(singInMessage);
        clickElemente(signOutbutton);
    }


}
