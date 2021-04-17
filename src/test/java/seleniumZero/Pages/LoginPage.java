package seleniumZero.Pages;

import seleniumZero.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){        PageFactory.initElements(Driver.get(),this);}
    @FindBy(xpath ="//*[@id='signin_button']" )
    public WebElement SignInMain;

    @FindBy(id = "user_login")
    public WebElement loginBox;
    @FindBy(id = "user_password")
    public WebElement password;
    @FindBy(xpath = "//*[@value='Sign in']")
    public WebElement SigninButton;
    @FindBy(id = "primary-button")
    public WebElement backToSafety;
    public void login(String username,String passwor){

        loginBox.sendKeys(username);password.sendKeys(passwor);SigninButton.click();
    }

}
