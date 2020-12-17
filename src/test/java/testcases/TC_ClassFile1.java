package testcases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_ClassFile1 
{

	WebDriver driver;
	String base_url = "https://amazon.in/";
	int implicit_wait_timeout_in_sec = 20;

	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
	}

	@Test
	public void TC_1_Checking_Website_working()
	{
		driver.get(base_url);
		String ExpectedTitle ="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

	@After
	public void Clean_UP() throws InterruptedException
	{
		Thread.sleep(5000);	
		driver.quit();
	}

}
