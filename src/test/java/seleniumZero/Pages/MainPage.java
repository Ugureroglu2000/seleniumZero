package seleniumZero.Pages;

import seleniumZero.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class MainPage extends BasePage {
    public MainPage(){      PageFactory.initElements(Driver.get(),this);    }
    @FindBy(id = "signin_button")
    public WebElement Signin;
    @FindBy(id = "homeMenu")
    public WebElement home;
    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBankingMenu;
    @FindBy(id = "feedback")
    public WebElement feedback;
    @FindBy(id = "online-banking")
    public WebElement onlineBankMoreServices;
    @FindBy(xpath = "//span[@id='account_activity_link']")
    public WebElement accountActivityLink;
    @FindBy(id = "transfer_funds_link")
    public WebElement transferFundsLink;
    @FindBy(id = "money_map_link")
    public WebElement money_map_link;
    @FindBy(id = "searchTerm")
    public WebElement SearchBox;



    public void verifyWebelements(){
        Assert.assertTrue(Signin.isDisplayed());
        Assert.assertTrue(home.isDisplayed());
        Assert.assertTrue(onlineBankingMenu.isDisplayed());
        Assert.assertTrue(onlineBankMoreServices.isDisplayed());
        Assert.assertTrue(accountActivityLink.isDisplayed());
        Assert.assertTrue(feedback.isDisplayed());
        Assert.assertTrue(SearchBox.isDisplayed());
        Assert.assertTrue(money_map_link.isDisplayed());
        Assert.assertTrue(transferFundsLink.isDisplayed());
    }
}
