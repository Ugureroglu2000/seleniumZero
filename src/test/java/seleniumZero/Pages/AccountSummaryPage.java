package seleniumZero.Pages;

import seleniumZero.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage extends BasePage{

    public AccountSummaryPage(){    PageFactory.initElements(Driver.get(),this);    }

    @FindBy(xpath = "(//table[@class='table'])[1]/tbody/tr[1]/td[1]/a")
    public WebElement CashAccount_Saving1;
    @FindBy(xpath = "(//table[@class='table'])[1]/tbody/tr[1]/td[3]")
    public WebElement CashAccount_Saving1Balance;
    @FindBy(xpath = "(//table[@class='table'])[1]/tbody/tr[2]/td[1]/a")
    public WebElement CashAccount_Saving2;
    @FindBy(xpath = "(//table[@class='table'])[1]/tbody/tr[2]/td[3]")
    public WebElement CashAccount_Saving2Balance;

    @FindBy(xpath = "(//table[@class='table'])[2]/tbody/tr[1]/td[1]/a")
    public WebElement InvestmentAccountsBrokerage;
    @FindBy(xpath = "(//table[@class='table'])[2]/tbody/tr[1]/td[3]")
    public WebElement InvestmentAccountsBrokerage_Balance;

    @FindBy(xpath = "(//table[@class='table'])[3]/tbody/tr[1]/td[1]/a")
    public WebElement CreditAccountsChecking;
    @FindBy(xpath = "(//table[@class='table'])[3]/tbody/tr[1]/td[3]")
    public WebElement CreditAccountsChecking_Balance;
    @FindBy(xpath = "(//table[@class='table'])[3]/tbody/tr[2]/td[1]/a")
    public WebElement CreditAccountsCreditCard;
    @FindBy(xpath = "(//table[@class='table'])[3]/tbody/tr[2]/td[3]")
    public WebElement CreditAccountsCreditCard_Balance;

    @FindBy(xpath = "(//table[@class='table'])[4]/tbody/tr[1]/td[1]/a")
    public WebElement CreditAccountsLoan;
    @FindBy(xpath = "(//table[@class='table'])[4]/tbody/tr[1]/td[3]")
    public WebElement CreditAccountsLoan_Balance;





}
