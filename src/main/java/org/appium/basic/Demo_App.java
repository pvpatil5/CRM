package org.appium.basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Demo_App {
	
	@Test
	public void demoApp() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName", "Moto E4 Plus");
		cap.setCapability("automationName", "appium");
		cap.setCapability("platformName", "andriod");
		cap.setCapability("platformVersion", "7.1.1");
		//cap.setCapability("fullReset", true);
		cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\DARSHAN\\Desktop\\appium batch\\ApiDemos.apk");
		
		URL url= new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver= new AndroidDriver(url, cap);
        Thread.sleep(3000);
        
        //by using accssibilty id
        driver.findElementByAccessibilityId("Views").click();
        driver.findElementByAccessibilityId("Controls").click();
        driver.findElementByAccessibilityId("3. Holo Light Theme").click();
      
        //by usig xpath by index
        //driver.findElementByXPath("(//android.widget.TextView)[4]").click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]").click();
//        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Controls\"]").click();
//        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"3. Holo Light Theme\"]").click();
        driver.findElementById("io.appium.android.apis:id/edit").sendKeys("light");
        driver.findElementById("io.appium.android.apis:id/check2").click();
        Thread.sleep(2000);
        
	}
}
