package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallCodeX 
{
	@Test
	public void installCodex() throws MalformedURLException
	{
		//Base_Class base = new Base_Class();

	
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Desktop\\Excell\\com.android.systemui_10-29_minAPI29(nodpi)_apkmirror.com.apk");
		
		System.out.println("app info set");

		URL url = new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, cap);
		
		System.out.println("opened codex...");
		
		driver.quit();
		
		System.out.println("driver closed");
		
	}

}
