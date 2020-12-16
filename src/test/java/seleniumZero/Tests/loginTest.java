package seleniumZero.Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import seleniumZero.Pages.LoginPage;
import seleniumZero.Pages.MainPage;
import seleniumZero.Testbase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class loginTest extends Testbase {


    @Test  // positive  with reports
    public void login() throws InterruptedException {
//    String path="C://Users/HP/IdeaProjects/zerobank SE/target";
//ExtentReports extentReports=new ExtentReports();
//ExtentSparkReporter reporter=new ExtentSparkReporter(path);
//    extentReports.attachReporter(reporter);               // in Testbase
//    extentReports.setSystemInfo("Environment","QQAA");
//ExtentTest logger=extentReports.createTest("REport 1");
        driver.get("http://zero.webappsecurity.com/login.html");
        LoginPage login=new LoginPage();
    logger.info("sending username and password");
        login.loginBox.sendKeys("username");
        login.password.sendKeys("password");
    logger.info("Push sign in button");
        boolean bool=true;int c=0;
        while (bool){
    try{login.SigninButton.click();bool=false;}catch (StaleElementReferenceException e){
        System.out.println(++c);}
        }
//        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        Thread.sleep(2000);
    logger.pass("Login is successfull");
        if(driver.getCurrentUrl().equals("https://zero.webappsecurity.com/auth/accept-certs.html?user_token=25af1f53-3c7d-4a7e-b71c-cfb1b38d2d6d")){
            login.backToSafety.click();

            Alert alert=driver.switchTo().alert();
            alert.accept();
        }
    logger.info("Logging out");
        new MainPage().logout();
//    logger.pass("Logged out successfully");
//    extentReports.flush();
    }

    @DataProvider
    public Object[][] dataLogin(){
    String [][] arr={{"username","password"},{"",""},{"","password"},{"password",""},{"user","password"},
            {"username","pass"},{"Username","password"},{"username","Password"}};
    return arr;
    }
//    @Test(dataProvider = "dataLogin")
//    public void testing(String a,String b){
//        System.out.println(a+" = "+b);
//    }

    @Test(dataProvider = "dataLogin")
    public void login1(String username,String password) throws InterruptedException {
        driver.get("http://zero.webappsecurity.com/login.html");
        LoginPage login=new LoginPage();//System.out.println("username");
        login.loginBox.sendKeys(username);
        login.password.sendKeys(password);
//        login.SigninButton.click();Thread.sleep(2000);
        boolean bool=true;int c=0;
        while (bool){
            try{login.SigninButton.click();bool=false;}catch (StaleElementReferenceException e){
                System.out.println(++c);}
        }
        if(driver.getCurrentUrl().equals("https://zero.webappsecurity.com/auth/accept-certs.html?user_token=25af1f53-3c7d-4a7e-b71c-cfb1b38d2d6d")){
            login.backToSafety.click();
            Alert alert=driver.switchTo().alert();
            alert.accept();
        }logger.info("verify login or not"+password);
//        System.out.println("a"+username);
        if(driver.getCurrentUrl().equals("http://zero.webappsecurity.com/login.html?login_error=true")){
            System.out.println(username+" "+password+" is Not correct");
        }else{System.out.println(username+" "+password+" is correct");
        MainPage mainPage=new MainPage();mainPage.logout();
        }
        logger.pass("It passed"+username);
//        System.out.println("b"+password);

    }

    @DataProvider
    public Object[][] DataExcell() throws IOException {
        String path="C:/Users/HP/Downloads/DataExcell.xlsx";
        FileInputStream Excell=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(Excell);
        Sheet worksheet=workbook.getSheet("Sheet1");
        int c=worksheet.getLastRowNum();String[][] arr=new String[c][2];
        for(int i=0;i<c;i++) {
            for (int j = 0; j < 2; j++) {
                Cell cell = worksheet.getRow(i).getCell(j);
                arr[i][j]=cell.toString();
//                System.out.println(arr[i][j]);
            }
        }
    return arr;

    }



    @Test(dataProvider="DataExcell")
    public void login2(String username,String password) throws InterruptedException {
        driver.get("http://zero.webappsecurity.com/login.html");
        LoginPage login=new LoginPage();//System.out.println("username");
        login.loginBox.sendKeys(username);
        login.password.sendKeys(password);
//        login.SigninButton.click();
        boolean bool=true;int c=0;
        while (bool){
            try{login.SigninButton.click();bool=false;}catch (StaleElementReferenceException e){
                System.out.println(++c);}
        }
//        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        Thread.sleep(2000);
        if(driver.getCurrentUrl().equals("https://zero.webappsecurity.com/auth/accept-certs.html?user_token=25af1f53-3c7d-4a7e-b71c-cfb1b38d2d6d")){
            login.backToSafety.click();
            Alert alert=driver.switchTo().alert();
            alert.accept();
        }
//        System.out.println("a"+username);
        if(driver.getCurrentUrl().equals("http://zero.webappsecurity.com/login.html?login_error=true")){
//            System.out.println(username+" "+password+" is Not correct");
        }else{System.out.println(username+" "+password+" is correct");
            MainPage mainPage=new MainPage();mainPage.logout();
        }
//        System.out.println("b"+password);

    }

}
