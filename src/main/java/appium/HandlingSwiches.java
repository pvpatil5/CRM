package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class HandlingSwiches
{
	@Test
	public void swichHandling() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");

		cap.setCapability("appPackage", "com.projects.sharath.materialvision");
		cap.setCapability("appActivity", "com.projects.sharath.materialvision.Codex.MyEntryScreen");
		System.out.println("app info set");

		URL url = new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, cap);
		
		Thread.sleep(3000);
		
		System.out.println("opened codex...");
		
		driver.findElementById("com.projects.sharath.materialvision:id/updateContinue\r\n").click();
		driver.findElementByXPath("//[contains(text(),'Buttons')]").click();
		
		
		
		
		
		
		
		
		
		driver.quit();
		
		System.out.println("driver closed");
	}

}
