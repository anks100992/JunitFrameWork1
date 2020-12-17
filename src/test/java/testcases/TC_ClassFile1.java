package testcases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import base.TestBase;

public class TC_ClassFile1 extends TestBase
{
	@Test
	public void TC_1_Checking_Website_working()
	{
		driver.get(base_url);
		String ExpectedTitle ="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}
}
