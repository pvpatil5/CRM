package org.appium.basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class NotificationReminder {
	@Test
	public void notification() throws MalformedURLException {
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName", "Moto E4 Plus");
		cap.setCapability("automationName", "appium");
		cap.setCapability("platformName", "andriod");
		cap.setCapability("platformVersion", "7.1.1");
		//cap.setCapability("fullReset", true);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.bhanu.notificationreminders");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "MainDrawerActivity");
		
		URL url= new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver= new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.bhanu.notificationreminders:id/txtNewNoteTitle").sendKeys("testdata");
		WebElement notify = driver.findElementById("com.bhanu.notificationreminders:id/btnNotify");
		driver.tap(1,notify,500 );
		
		driver.openNotifications();
		WebElement read = driver.findElementByAccessibilityId("Read");
		read.click();
		//driver.tap(1, read,50 );
		driver.tap(1, 157, 1029, 500);
	
	
	
	}

}
