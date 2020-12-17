package testcases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC__ClassFile2 
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
	public void TC_2_Searching_for_the_product()
	{
		driver.get(base_url);
		String ExpectedTitle ="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		Assert.assertEquals(ExpectedTitle, ActualTitle);

		WebDriverWait webdriverwait = new WebDriverWait(driver,20);
		WebElement SearchBox = driver.findElement(By.xpath("//input[@type='text']"));

		SearchBox.sendKeys("Laptop");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		//Wait for title
		WebDriverWait webdriverwait1 = new WebDriverWait(driver,20);
		String ActualPageTitle = driver.getTitle();

		webdriverwait1.until(ExpectedConditions.titleIs("Amazon.in : Laptop"));	

		//Assertion
		Assert.assertEquals("Amazon.in : Laptop", ActualPageTitle);
	}

	@After
	public void Clean_UP() throws InterruptedException
	{
		Thread.sleep(5000);	
		driver.quit();
	}


}
