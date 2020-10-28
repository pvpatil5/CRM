package appium;

import static org.testng.Assert.assertEquals;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Pawan
{

	public static ExtentTest test;
	public static ExtentReports extent;
	@Test
	public void  endToE() throws Throwable 
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		test = extent.createTest("pawan");
		test.info("start");
		System.out.println("start");
		System.out.println("open application");
		test.info("open application");
		

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		cap.setCapability("appPackage", "com.weekdone.android");
		cap.setCapability("appActivity", ".StartupActivity");

		URL url = new URL("http://localhost:4723/wd/hub");
		AppiumDriver<MobileElement>  driver = new AndroidDriver<MobileElement>(url, cap);

		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("application opened");
		test.info("application opened");



		Thread.sleep(3000);
		System.out.println("login page opened");
		test.pass("login page opened");

		driver.findElementById("com.weekdone.android:id/email" ).sendKeys("shriniwas.ambad@gmail.com");
		driver.findElementById("com.weekdone.android:id/password").sendKeys("jagannath");
		driver.findElementById("com.weekdone.android:id/sign_in_button").click();
		System.out.println("login succesful");
		test.pass("login succesful");

		//WebDriverWait wait = new WebDriverWait(driver,10);
        

       /*WebElement upButoon = driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Tags, Close navigation drawer\"]/android.widget.FrameLayout/android.widget.ImageView[1]");
       wait.until(ExpectedConditions.visibilityOf(upButoon));
       upButoon.click();
       driver.findElementByXPath("//[contains(text(),'okr')]").click();
       */
       
       
		//driver.findElementsById("onboardoverlay").get(2).click();
		//driver.findElementByXPath("//[contains(text(),'Try adding one item for others to see')]").click();
		//driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]").click();
		//Thread.sleep(3000);

		/*driver.findElementByXPath("//android.webkit.WebView[@index= '3']").click();
		 
		 
		 
		//hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View[3]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[3]

		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[2]/android.widget.ListView/android.view.View/android.view.View/android.widget.EditText").sendKeys("Framework");


		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.Button").click();
		System.out.println("obkective created");

		String objectiveName = driver.findElementByXPath("//[contains(text(),'frame')]").getText();

		assertEquals("frame", objectiveName);

		System.out.println("objective verified");*/


		Thread.sleep(6000);

		System.out.println("proceed to logout");
		test.info("proceed to logout");


		WebElement optionsButoon = driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"More options\"]");

      //  wait.until(ExpectedConditions.visibilityOf(optionsButoon));
        optionsButoon.click();
        
        Thread.sleep(3000);
        WebElement logOut = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[7]/android.widget.LinearLayout");
		//wait.until(ExpectedConditions.visibilityOf(logOut));
		logOut.click();
		
		
		System.out.println("log out successfull");
		test.info("log out successfull");


		driver.quit();
		System.out.println("application closed");
		test.info("application closed");

/*
		// calling flush writes everything to the log file
		extent.flush();
		System.out.println("end");*/
		test.info("end");




	}

}