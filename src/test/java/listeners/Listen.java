package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import seleniumZero.Utils.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listen implements ITestListener {

//@Test
    public void onTestStart(ITestResult result){
        Reporter.log("starting the Test");
//        System.out.println(result.getName()+" starting");
}

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName()+" Passsed");
    }
    public void onTestFailure(ITestResult result) {
        if(result.getStatus()==ITestResult.FAILURE) {   // if it fails
            String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            String pathTarget = System.getProperty("user.dir") + "/test-output/Screenshots/" + result.getName() + date + ".png";
//        // C:\Users\HP\IdeaProjects\zerobank SE\test-output\Screenshots\testing20201204094250.png
//            System.out.println(pathTarget+4);
//            logger.fail(result.getName());
//            String pathTarget=Screenshot.getScreenshot(result.getName());
            TakesScreenshot ts = (TakesScreenshot) Driver.get();
//            System.out.println(pathTarget+3);
            File file = ts.getScreenshotAs(OutputType.FILE);

            File finalDestination = new File(pathTarget);
//           try{
//            System.out.println(pathTarget+2);
            try {
                FileUtils.copyFile(file, finalDestination);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Reporter.log("<a href="+finalDestination +"target='blank'>Screenshot Link</a>");
            Reporter.log("<br>");
            Reporter.log("<a href="+finalDestination +"target='blank'>" +
                    "<img height=40 width=50 src='"+finalDestination+"</a>");
//            logger.addScreenCaptureFromPath(pathTarget);
//            System.out.println(pathTarget+1);
//        System.out.println(result.getName()+" Failed");

        }
    }
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName()+" is skipped");
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(result.getName()+"FailedButWithinSuccessPercentage");
    }
    public void onTestFailedWithTimeout(ITestResult result) {

            System.out.println(result.getName()+" is skipped");}
    /**
     * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
     * and calling all their Configuration methods.
     */
    public void onStart(ITestContext context) {
        System.out.println(context.getName()+" is starting context");
        // not implemented
    }

    /**
     * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
     * and all their Configuration methods have been called.
     */
    public void onFinish(ITestContext context) {
        System.out.println(context.getName()+" is finished");

        // not implemented
    }

}
