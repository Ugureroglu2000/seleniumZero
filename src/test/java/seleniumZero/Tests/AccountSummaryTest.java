package seleniumZero.Tests;

import seleniumZero.Pages.AccountSummaryPage;
import seleniumZero.Pages.LoginPage;
import seleniumZero.Testbase;
import seleniumZero.Utils.ConfReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AccountSummaryTest extends Testbase {

    @Test
    public void Acc() throws InterruptedException {
        String username= ConfReader.get("username");
        String password= ConfReader.get("password");
        driver.get("http://zero.webappsecurity.com/login.html");
        new LoginPage().login(username,password);
        //        new MainPage().accountActivityLink.click();
        //        new MainPage().AccountSummary.click();
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        accountSummaryPage.CashAccount_Saving1.click();
        String url=driver.getCurrentUrl();Thread.sleep(2000);
        Assert.assertEquals(url,"http://zero.webappsecurity.com/bank/account-activity.html?accountId=1");
        driver.navigate().back();
        accountSummaryPage.CreditAccountsChecking.click();
        url=driver.getCurrentUrl();Thread.sleep(2000);
        Assert.assertEquals(url,"http://zero.webappsecurity.com/bank/account-activity.html?accountId=2");
        driver.navigate().back();
        accountSummaryPage.CreditAccountsLoan.click();
        url=driver.getCurrentUrl();Thread.sleep(2000);
        Assert.assertEquals(url,"http://zero.webappsecurity.com/bank/account-activity.html?accountId=4");
        driver.navigate().back();
        accountSummaryPage.InvestmentAccountsBrokerage.click();
        url=driver.getCurrentUrl();Thread.sleep(2000);
        Assert.assertEquals(url,"http://zero.webappsecurity.com/bank/account-activity.html?accountId=6");
        driver.navigate().back();
        accountSummaryPage.logout();
    }
}
