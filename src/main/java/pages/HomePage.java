package pages;

import components.SignInPopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class HomePage extends BasePage {


    @FindBy(id = "header-login-modal")
    private WebElement signInElement;

    @FindBy(id = "header-login-modal")
    private WebElement userName;

    @FindBy(xpath = "//*[@class='fb-masthead-login__name re-design-cl__name']")
    private WebElement signInMessage;

    @FindBy(xpath = "//*[@class='fb-filter-header__log-out']")
    private WebElement signOutButton;

    @FindBy(xpath = "//*[@class='fb-masthead-login__name re-design-cl__name login-redesing_logout-box']")
    private WebElement signOutMessage;

    @FindBy(xpath = "//*[@class='fb-masthead-search__box__input']")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id='search-bar']//*[@class='icon-search fb-masthead__util-bar__icon']")
    private WebElement searchIcon;

    private SignInPopUp signInPopUp;

    public HomePage(WebDriver driver) {
        super(driver);
        signInPopUp = new SignInPopUp(driver);
    }

    public void signIn(Map<String,String> singInData) {
        openSingInPopUp();
        signInPopUp.signIn(singInData);
    }

    private void openSingInPopUp() {
        signInElement.click();
    }

    public void openRegister() {
        openSingInPopUp();
        signInPopUp.openRegister();
    }


    public String getSignInMessage() {
        drivenFacade.waitVisible(signInMessage);
        return signInMessage.getText().replaceAll("\\n", "");
    }

    public String getSignOutMessage() {
        drivenFacade.waitVisible(signOutMessage);
        return signOutMessage.getText().replaceAll("\\n", "");
    }


    public String getSignInErrorMessage() {
        return signInPopUp.getErrorMessage();
    }

    public void signOut() {
        drivenFacade.waitVisible(signInMessage);
        signInMessage.click();
        signOutButton.click();
    }

    public void search(String search) {
        searchBar.sendKeys(search);
        searchIcon.click();
    }

}
