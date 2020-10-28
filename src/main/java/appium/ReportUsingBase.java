package appium;

import org.testng.annotations.Test;

public class ReportUsingBase extends Base_Class
{
	@Test
	public void repo()
	{
		test = extent.createTest("repo");
        System.out.println("start");
		test.info("hotay bhau");
		System.out.println("hotay re");
	}

}
