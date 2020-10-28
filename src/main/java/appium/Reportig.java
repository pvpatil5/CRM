package appium;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentEmailReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reportig
{
	 public static void main(String[] args) throws IOException {
	        // start reporters
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	        ExtentEmailReporter email= new ExtentEmailReporter("mail.html");
	    
	        // create ExtentReports and attach reporter(s)
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter, email);

	        // creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

	        // log(Status, details)
	        test.log(Status.INFO, "This step shows usage of log(status, details)");

	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        //test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	        
	        // test with snapshot
	        test.addScreenCaptureFromPath("screenshot.png");
	        
	        // calling flush writes everything to the log file
	        extent.flush();
	    }

}
