package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

//    @FindBy(className = "icon-logo fb-masthed__util-bar__icon")
//    private WebElement logo;

    @FindBy(id = "header-login-modal")
    private WebElement signInElemente;

    @FindBy(id = "header-login-modal")
    private WebElement userName;

    @FindBy(xpath = "//*[@class='fb-masthead-login__name re-design-cl__name']")
    private WebElement signInMessage;

    @FindBy(xpath = "//*[@class='fb-filter-header__log-out']")
    private WebElement signOutbutton;

    @FindBy(xpath = "//*[@class='fb-masthead-login__name re-design-cl__name login-redesing_logout-box']")
    private WebElement signOutMessage;

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
        openSingInPopUp();
        signInPopUp.signIn(filePath);
    }
    private void openSingInPopUp(){
        signInElemente.click();
    }

    public void openRegister(){
        openSingInPopUp();
        signInPopUp.openRegister();
    }


    public String getSignInMessage() {
        drivenHelper.waitVisible(signInMessage);
        return  signInMessage.getText().replaceAll("\\n", "");
    }

    public String getSignOutMessage() {
        drivenHelper.waitVisible(signOutMessage);
        return  signOutMessage.getText().replaceAll("\\n", "");
    }


    public String  getSignInErrorMessage(){
        return signInPopUp.getErrorMessage();
    }

    public void signOut(){
        drivenHelper.waitVisible(signInMessage);
        signInMessage.click();
        signOutbutton.click();
    }

    public  void  search(String search){
        searchBar.sendKeys(search);
        searchIcon.click();
    }

}
