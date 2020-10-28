package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base_Class
{
	public AndroidDriver<WebElement> driver;
	public DesiredCapabilities cap;
	public static  ExtentTest test;
	public static ExtentReports extent;

	@BeforeSuite
	public void startReport()
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
        

	}

	@BeforeClass
	public void connectToVirtualDevice() throws MalformedURLException
	{
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		System.out.println("capabilities set");
		cap.setCapability("appPackage", "com.weekdone.android");
		cap.setCapability("appActivity", "com.weekdone.android.StartupActivity");
		System.out.println("app info set");
		URL url = new URL("http://localhost:4723/wd/hub");
		System.out.println("url entered");
		driver= new AndroidDriver<WebElement>(url, cap);

	}

	

	@AfterClass
	public void disConnectVirtualDevice()
	{
		driver.quit();

		System.out.println("driver closed");
	}
	
	@AfterSuite
	public void endReport()
	{
		// calling flush writes everything to the log file
        extent.flush();
        System.out.println("end");
	}

}
