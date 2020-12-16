package seleniumZero.Tests;

import seleniumZero.Pages.MainPage;
import seleniumZero.Testbase;
import seleniumZero.Utils.ConfReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class MainTest extends Testbase {
    @Test
    public void main() throws InterruptedException {
//      Driver.get().get(ConfReader.get("url"));
        String url = ConfReader.get("url");
        driver.get(url);
//        Driver.get().manage().window().maximize();          // in testbase
//        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MainPage mainPage=new MainPage();
//        Thread.sleep(3000);
        mainPage.verifyWebelements();
        System.out.println("Transfer is Displayed = "+mainPage.transferFundsLink.isDisplayed());
        Assert.assertTrue(mainPage.transferFundsLink.isDisplayed());
        System.out.println("Online Banking menu = "+mainPage.onlineBankingMenu.isDisplayed());
        Assert.assertTrue(mainPage.onlineBankingMenu.isDisplayed());
        System.out.println("onlineBankMoreServices = "+mainPage.onlineBankMoreServices.isDisplayed());
        Assert.assertTrue(mainPage.onlineBankMoreServices.isDisplayed());
        System.out.println("money_map_link = "+mainPage.money_map_link.isDisplayed());
        Assert.assertTrue(mainPage.money_map_link.isDisplayed());
        System.out.println("accountActivityLink = "+mainPage.accountActivityLink.isDisplayed());
        Assert.assertTrue(mainPage.accountActivityLink.isDisplayed());
        System.out.println("SearchBox = "+mainPage.SearchBox.isDisplayed());
        Assert.assertTrue(mainPage.SearchBox.isDisplayed());
        mainPage.Signin.click();Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),"verify login page");
        driver.navigate().back();
        mainPage.onlineBankingMenu.click();Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("online-banking"));
        driver.navigate().back();
        mainPage.transferFundsLink.click();Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        driver.navigate().back();
        mainPage.SearchBox.click();Thread.sleep(1000);
        mainPage.SearchBox.sendKeys("online", Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("searchTerrm"));


//        Thread.sleep(2000);
//        Driver.get().quit();

    }


}
