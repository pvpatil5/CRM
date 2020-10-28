package org.appium.basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Camera {
	
	@Test
	public void tc_camera01() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "motorola one macro");
		cap.setCapability("automationName", "appium");
		cap.setCapability("platformName", "andriod");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("noReset", true);
		// cap.setCapability("fullReset", true);
		//cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\DARSHAN\\Desktop\\appium batch\\Activity Launcher_v1.9.1_apkpure.com.apk");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.motorola.camera2");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.motorola.camera.Camera");
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
	    Thread.sleep(2000);
	   // driver.find
	    
	
	
	
	}
	

}
