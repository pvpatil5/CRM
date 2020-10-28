package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SystemTesting 
{
	AndroidDriver<WebElement> driver;
	
	@BeforeClass
	public void EndToEnd() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		cap.setCapability("appPackage", "com.weekdone.android");
		cap.setCapability("appActivity", "com.weekdone.android.StartupActivity");
		System.out.println("app info set");

		URL url = new URL("http://localhost:4723/wd/hub");
		
		 driver = new AndroidDriver<WebElement>(url, cap);
		
		System.out.println("opened WeekDone...");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	
	@Test
	public void mainTest()
	{
		
		driver.findElementById("com.weekdone.android:id/email").sendKeys("shriniwas.ambad@gmail.com");
		driver.findElement(By.id("com.weekdone.android:id/password")).sendKeys("jagannath");
		driver.findElement(By.id("com.weekdone.android:id/sign_in_button")).click();
		//driver.findElementById("")
	}
	
	@AfterClass
	public void discardConnection()
	{
		driver.quit();
		
		System.out.println("driver closed");
	}

}
