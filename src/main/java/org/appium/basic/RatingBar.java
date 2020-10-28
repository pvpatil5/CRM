package org.appium.basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class RatingBar {
	@Test
	public void tc_ratingBar() throws MalformedURLException {
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability("deviceName", "AOSP on IA Emulator");
	cap.setCapability("automationName", "appium");
	cap.setCapability("platformName", "andriod");
	cap.setCapability("platformVersion", "9");
	// cap.setCapability("fullReset", true);
	cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\DARSHAN\\Desktop\\appium batch\\ApiDemos.apk");

	URL url = new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver = new AndroidDriver(url, cap);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))").click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Rating Bar\"))").click();
	WebElement bar = driver.findElementById("io.appium.android.apis:id/ratingbar2");
	int startx = bar.getLocation().getX();
	int starty = bar.getLocation().getY();
	int endx = (int) (bar.getSize().getWidth()*0.7);
	driver.tap(1, endx, starty, 1000);
	String rating = driver.findElementByXPath("//android.widget.TextView[@text='Rating: 3.5/5']").getText();
	System.out.println(rating);
	}
}
