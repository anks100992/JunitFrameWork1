package base;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	protected WebDriver driver;
	protected String base_url = "https://amazon.in/";
	protected int implicit_wait_timeout_in_sec = 20;

	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
	}

	@After
	public void Clean_UP() throws InterruptedException
	{
		Thread.sleep(5000);	
		driver.quit();
	}

}
