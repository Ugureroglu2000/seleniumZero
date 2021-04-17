package seleniumZero;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.relevantcodes.extentreports.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumZero.Utils.ConfReader;
import seleniumZero.Utils.Driver;
import seleniumZero.Utils.Screenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


//Ugur branc ugur github ediited master editted git master again

//Ugur branc ugur editted github ugur


public class Testbase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected static ExtentReports report;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;

    @BeforeTest
    public void before(){
        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath +"/test-output/Screenshots/AAAreport.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfReader.get("browser"));

    }
//    static int a=0;
    @BeforeMethod
    public  void beforemethod(){

        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);

//        driver.get(url);
    }
    @AfterMethod
    public void after(ITestResult result) throws IOException, InterruptedException {
        //if test failed
        if (result.getStatus()==ITestResult.FAILURE){
            //record the name fo failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return location of screenshot
            String screenShotPath = Screenshot.getScreenshot(result.getName());
            
            //add your screen shot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);
//            extentLogger.addScreenCaptureFromBase64String(screenShotPath);

            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }
        //close driver
//        Thread.sleep(2000);
        Driver.closeDriver();
    }


    @AfterTest
    public void afterMethod()throws InterruptedException {
<<<<<<< HEAD
//        Thread.sleep(2000);
        report.flush();
=======
//         Thread.sleep(2000); //no need to wait
        extentReports.flush();
//        if(driver!=null){driver.quit();}

>>>>>>> 4ba89a9917ad0353eb27763149e7fef485fd1142
    }

}
