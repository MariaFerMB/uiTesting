package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    //By ajiaco=By.xpath()
    public HomePage(WebDriver driver) {
        super(driver);
        signInPopUp =new SignInPopUp(driver);
    }

    public void signIn(String email, String password){
        openSingInPopUp();
        signInPopUp.singIn(email,password);
    }
    private void openSingInPopUp(){
        clickElement(signInElemente);
    }

    public void openRegister(){
        openSingInPopUp();
        signInPopUp.openRegister();
    }


    public String verifySingIn() {
        drivenHelper.waitVisible(singInMessage);
        return  getText(singInMessage);
    }

    public String verifySingOut() {
        drivenHelper.waitVisible(singOutMessage);
        return  getText(singOutMessage);
    }


    public String  verifyNotSignIn(){
        return signInPopUp.getErrorMessage();
    }

    public void signOut(){
        drivenHelper.waitVisible(singInMessage);
        clickElement(singInMessage);
        clickElement(signOutbutton);
    }


}
