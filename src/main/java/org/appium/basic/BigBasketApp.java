package org.appium.basic;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class BigBasketApp {
	@Test
	public void bigbasket() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName", "Moto E4 Plus");
		cap.setCapability("automationName", "appium");
		cap.setCapability("platformName", "andriod");
		cap.setCapability("platformVersion", "7.1.1");
		cap.setCapability("noReset", true);
		//cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\DARSHAN\\Desktop\\appium batch\\bigbasket Online Grocery Shopping App_v5.1.4_apkpure.com.apk");
		cap.setCapability("appPackage", "com.bigbasket.mobileapp");
		cap.setCapability("appActivity", "activity.SplashActivity");
		
		//cap.setCapability("fullReset", true);  //we have to set one true and one reset cap is flase 
		
		URL url= new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver= new AndroidDriver(url, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.bigbasket.mobileapp:id/homePageSearchBox").click();
        Thread.sleep(1000);
        driver.findElementById("com.bigbasket.mobileapp:id/searchView").sendKeys("mongos");
        Thread.sleep(2000);
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
        Thread.sleep(3000);
        String items = driver.findElementById("com.bigbasket.mobileapp:id/txtProductCount").getText();
      
        System.out.println(items);
        System.out.println(items.substring(0, 4));
        
    		char[] ch=items.toCharArray();
    		int out=0;
    		for (int i = 0; i < ch.length; i++) {
    			if(ch[i]>=48&&ch[i]<=57) 
    			{
    				out=out*10+(ch[i]-48);
    			}
    			
    		}
    		System.out.println(out);
        
        Assert.assertTrue(out>140);
        
        
	}

}
