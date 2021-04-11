package seleniumZero;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
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
    public static WebDriver driver;
    public static ExtentReports extentReports;
    public static ExtentSparkReporter reporter;
    public static ExtentTest logger;
    @BeforeTest
    public void before(){
//        String url = ConfReader.get("url");
//        Driver.get().get(url);              //cant call webpage here and continue other methods
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver=Driver.get();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String path="C://Users/HP/IdeaProjects/seleniumZero/target/report.html";
        extentReports=new ExtentReports();
        reporter=new ExtentSparkReporter(path);
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Environment","QQAA");
//        logger=extentReports.createTest("REport 1");

    }
//    static int a=0;
    @BeforeMethod
    public  void beforemethod(){
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger=extentReports.createTest("Report ");
    }
    @AfterMethod
    public void after(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE) {
            //record the name fo failed test case
            logger.fail(result.getName());

            //take the screenshot and return location of screenshot
            String screenShotPath = Screenshot.getScreenshot(result.getName());
            
            //add your screen shot to your report
            logger.addScreenCaptureFromPath(screenShotPath);

            //capture the exception and put inside the report
            logger.fail(result.getThrowable());
        }
        Driver.closeDriver();
    }

    public void afterMethod (ITestResult result) throws IOException, InterruptedException {
        if(result.getStatus()==ITestResult.FAILURE){   // if it fails
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String pathTarget=System.getProperty("user.dir") + "/test-output/Screenshots/" + result.getName() + date + ".png";
//        // C:\Users\HP\IdeaProjects\zerobank SE\test-output\Screenshots\testing20201204094250.png
            System.out.println(pathTarget+4);
            logger.fail(result.getName());
//            String pathTarget=Screenshot.getScreenshot(result.getName());
            TakesScreenshot ts=(TakesScreenshot)Driver.get();
            System.out.println(pathTarget+3);
            File file=ts.getScreenshotAs(OutputType.FILE);

            File finalDestination = new File(pathTarget);
//           try{
            System.out.println(pathTarget+2);
               FileUtils.copyFile(file,finalDestination);
            logger.addScreenCaptureFromPath(pathTarget);
            System.out.println(pathTarget+1);
//
//           }catch (IOException e){
//               System.out.println("Error"+e.getMessage());
////
//           }
            Screenshot.getScreenshot(result.getName());
            logger.fail(result.getThrowable());
            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(pathTarget).build());
            logger.addScreenCaptureFromPath("C:\\Users\\HP\\IdeaProjects\\seleniumZero\\test-output\\Screenshots\\",result.getName()+date+".png");
            logger.addScreenCaptureFromBase64String("C:/Users/HP/IdeaProjects/seleniumZero/test-output/Screenshots/"+result.getName()+date+".png",result.getName());
            logger.addScreenCaptureFromPath(result.getName()+date+".jpg");
        }

        Driver.closeDriver();
//        if(driver!=null){driver.quit();}
    }


    @AfterTest
    public void afterMethod()throws InterruptedException {
        Thread.sleep(2000);
        extentReports.flush();
//        if(driver!=null){driver.quit();}

    }

}
