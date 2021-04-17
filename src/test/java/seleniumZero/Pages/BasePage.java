package seleniumZero.Pages;

import seleniumZero.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {        PageFactory.initElements(Driver.get(),this);    }

    @FindBy(id = "account_summary_tab")
    public WebElement AccountSummary;
    @FindBy(id = "account_activity_tab")
    public  WebElement AccountActivity;
    @FindBy(id = "transfer_funds_tab")
    public WebElement TransferFunds;
    @FindBy(xpath = "//*[text()='Pay Bills']")
    public WebElement PayBills;
    @FindBy(id = "money_map_tab")
    public WebElement MoneyMap;
    @FindBy (xpath = "//*[text()='Online Statements")
    public WebElement OnlineStatements;

    @FindBy(xpath = "(//*[@class='dropdown-toggle'])[2]")
    public WebElement logoutUsername;
    @FindBy(id ="logout_link" )
    public WebElement logout;
    public void logout(){
        System.out.println("logout");
        logoutUsername.click();
        logout.click();
        System.out.println("logout ok");
    }


}
