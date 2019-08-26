package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Configuration;

import java.util.Properties;

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

    @FindBy(xpath = "//*[@class='fb-masthead-search__box__input']")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id='search-bar']//*[@class='icon-search fb-masthead__util-bar__icon']")
    private WebElement searchIcon;

    private SignInPopUp signInPopUp;

    public HomePage(WebDriver driver) {
        super(driver);
        signInPopUp =new SignInPopUp(driver);
    }

    public void signIn(String filePath){
       // Properties prop = Configuration.readConfiguration(filePath);
        openSingInPopUp();
        signInPopUp.signIn(filePath);
       // signInPopUp.signIn(prop.getProperty("email"),prop.getProperty("password"));
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

    public  void  search(String search){
        searchBar.sendKeys(search);
        clickElement(searchIcon);
    }

}
