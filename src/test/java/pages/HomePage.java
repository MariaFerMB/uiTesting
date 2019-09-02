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
        openSingInPopUp();
        signInPopUp.signIn(filePath);
    }
    private void openSingInPopUp(){
        clickElement(signInElemente);
    }

    public void openRegister(){
        openSingInPopUp();
        signInPopUp.openRegister();
    }


    public String getSingInMessage() {
        drivenHelper.waitVisible(singInMessage);
        return  getText(singInMessage).replaceAll("\\n", "");
    }

    public String getSingOutMessage() {
        drivenHelper.waitVisible(singOutMessage);
        return  getText(singOutMessage).replaceAll("\\n", "");
    }


    public String  getSignInErrorMessage(){
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
