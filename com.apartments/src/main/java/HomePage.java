import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {



    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //WebElement
    @FindBy(id = "quickSearchLookup")
    public WebElement searchField;



    @FindBy(xpath = "//a[@title='Search apartments for rent']")
    public WebElement searchButton;

    @FindBy(id = "headerMenuLink")
    public WebElement headerMenu;

    @FindBy (xpath = "//ul[@id='menuNavigation']/li/a")
    public List<WebElement> Menu;



    @FindBy(xpath = "//a[@title='Sign In']")
    public WebElement SignInLink;

    @FindBy(xpath = "//div[@class='modalBody']//iframe")
    public WebElement signInIframe;

    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "loginButton")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@class='validation-error invalid-credentials']")
    public WebElement errorMessage;




    //method region

    public void inputSearchField(String searchTerm) {
        clearSendKeysToElement(searchField, searchTerm);
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }
//    public SearchResultPage doSearch(String searchTerm) {
//        inputSearchField(searchTerm);
//        clickOnSearchButton();
//        return new SearchResultPage();
//    }
    public void clickOnMenu(){
        safeClickOnElement(headerMenu);
    }
    public void clickOnSubMenu(String subMenu){
        for(WebElement element : Menu){
            if(getTrimmedElementText(element).equals(subMenu)){
                safeClickOnElement(element);break;
            }
        }
    }
//    public void clickOnSubSubMenu(String subSubMenu){
//        for(WebElement element : SubMenu){
//            if(getTrimmedElementText(element).equals(subSubMenu)){
//                safeClickOnElement(element);break;
//            }
//        }
//    }
//    public RentalCalculatorPage clickOnRentalCalculator(){
//        clickOnMenu();
//        clickOnSubMenu("Renter Tools");
//        clickOnSubSubMenu("Rental Calculator");
//        return new RentalCalculatorPage();

//    public FavoritesPage clickOnFavorites(){
//        clickOnMenu();
//        clickOnSubMenu("Renter Tools");
//        clickOnSubSubMenu("Favorites");
//        return new FavoritesPage();


    public void clickOnSignInLink(){
        safeClickOnElement(SignInLink);
    }
    public void switchToSignInFrame(){
        switchToFrameByElement(signInIframe);
    }
    public void enterUsername(String userName){
        clearSendKeysToElement(usernameField,userName);
    }
    public void enterPassword(String password){
        clearSendKeysToElement(passwordField,password);
    }
    public void clickOnSignInButton(){
        safeClickOnElement(signInButton);
    }
    public void doSignIn(String userName , String password){
        clickOnSignInLink();
        switchToSignInFrame();
        enterUsername(userName);
        enterPassword(password);
        clickOnSignInButton();
    }
    public String getErrorLoginMessage(){
        return getTrimmedElementText(errorMessage);
    }
}
