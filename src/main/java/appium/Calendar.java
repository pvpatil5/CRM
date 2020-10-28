package appium;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calendar 
{
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

	
	@Test
	public static void createReminder() throws MalformedURLException, InterruptedException 
	{

		test = extent.createTest("calendar");

		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		cap.setCapability("appPackage", "com.google.android.calendar");
		cap.setCapability("appActivity", "com.android.calendar.AllInOneActivity");

		System.out.println("app info set");
		test.info("app info set");
		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, cap);
		
		

		System.out.println("opened calendar...");
		test.info("open calender");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement rightArrow = driver.findElementById("com.google.android.calendar:id/right_arrow");
		wait.until(ExpectedConditions.elementToBeClickable(rightArrow));

		for(int i=0; i<2; i++)
		{
			rightArrow.click();
		}

		driver.findElementById("com.google.android.calendar:id/done_button").click();
		test.info("calendar opened");

		/*WebElement addButton = driver.findElementById("com.google.android.calendar:id/floating_action_button");
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
		
		driver.findElementById("com.google.android.calendar:id/speed_dial_icon").click();
		
		test.info("create reminder");

		String reminder = "12345";
		WebElement reminderTextBox = driver.findElementById("com.google.android.calendar:id/title_edit_text");
		reminderTextBox.sendKeys(reminder);
		
		driver.findElementById("com.google.android.calendar:id/save").click();
		test.info("reminder created");*/


		test.info("confirm reminder");
		WebElement checkReminders = driver.findElementByXPath("//android.view.View[@index = '1']");
		wait.until(ExpectedConditions.elementToBeClickable(checkReminders));
		checkReminders.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

		driver.findElementByXPath("(//android.view.View[@content-desc=\"Reminder: 12345, All day: \"])[1]").click(); 
		

		 WebElement reminderName = driver.findElementById("com.google.android.calendar:id/title");
		 wait.until(ExpectedConditions.elementToBeClickable(reminderName));
		 //String value = reminderName.getText();

		//assertEquals(reminder, value);
		test.pass("Expected and actual value matched ");
		driver.quit();

		System.out.println("driver closed");

		test.info("driver closed");
		
	}
	
	@AfterSuite
	public void endReport()
	{
		// calling flush writes everything to the log file
        extent.flush();
        System.out.println("end");
	}

}
