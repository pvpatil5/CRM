package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ProfitcoEndtoEnd 
{
	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		cap.setCapability("appPackage", "com.profitco.android");
		cap.setCapability("appActivity", "com.profitco.android.activity.SplashActivity");
		
		
		
		
		System.out.println("app info set");

		URL url = new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, cap);
		
		System.out.println("opened Profit co...");
		
		Thread.sleep(3000);
		System.out.println("login page opened");
		//test.pass("login page opened");

		driver.findElementById("com.profitco.android:id/etEmailId").sendKeys("shriniwas.ambad@gmail.com");
		driver.findElementById("com.profitco.android:id/etPassword").sendKeys( "Shri4916");
		Thread.sleep(1000);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.TextView[2]").click();
		
		System.out.println("login succesful");
		//test.pass("login succesful");
		WebElement addButoon = driver.findElementById("com.profitco.android:id/fab_expand_menu_button");
		
		WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(addButoon));
        
        addButoon.click();
        
        driver.findElementById("com.profitco.android:id/fab_action_one").click();
        
        
        driver.findElementById("com.profitco.android:id/txt_objective_Name").sendKeys("one" + Keys.ADD);
        


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Thread.sleep(3000);
		driver.quit();
		
		System.out.println("driver closed");
		
	}

}
