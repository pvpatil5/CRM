package org.appium.basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ApiDemo_orientation {
	@Test
	public void tc_orientationTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName", "Moto E4 Plus");
		cap.setCapability("automationName", "appium");
		cap.setCapability("platformName", "andriod");
		cap.setCapability("platformVersion", "7.1.1");
		//cap.setCapability("fullReset", true);
		cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\DARSHAN\\Desktop\\appium batch\\ApiDemos.apk");
		
		URL url= new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver= new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("the inital screen orientation is"+driver.getOrientation());
		Thread.sleep(3000);
		driver.rotate(ScreenOrientation.LANDSCAPE);
		Thread.sleep(3000);
		System.out.println("the orientation of screen after roation is"+driver.getOrientation());
		Thread.sleep(3000);
		driver.rotate(ScreenOrientation.PORTRAIT);
		Thread.sleep(3000);
		System.out.println("the orientation of screen after roation is"+driver.getOrientation());
		
		
	}

}
