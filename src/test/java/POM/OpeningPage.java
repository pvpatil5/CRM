package POM;

import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import io.appium.java_client.android.AndroidDriver;

public class OpeningPage 
{
	public static WebElement element;
	static AndroidDriver<WebElement> driver;
	//public static WebElement 
	//public static  WebElement doneButton = 

	
	
	/*public OpeningPage(AndroidDriver<WebElement> driver) 
	{
		
		super();
		this.driver = driver;
	}*/

	
	public static WebElement rightArrow(AndroidDriver<WebElement> driver )
	{
		element  = driver.findElementById("com.google.android.calendar:id/right_arrow");
		return element;
		
	}
	
	public static WebElement doneButton(AndroidDriver<WebElement> driver )
	{
		element  = driver.findElementById("com.google.android.calendar:id/done_button");
		return element;
		
	}
	
	
}
