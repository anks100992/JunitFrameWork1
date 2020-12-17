package base;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	protected WebDriver driver;
	protected String base_url = "https://amazon.in/";
	
	 private String getBrowserName(){
	        String browserDefault = "chrome"; //Set by default
	        String browserSentFromCmd = System.getProperty("browser");
	        //mvn clean install -Dbrowser=safari
	        //browserSentFromCmd = safari
	        if (browserSentFromCmd==null){
	            return browserDefault;
	        }else{
	            return browserSentFromCmd;
	        }
	    }
	
	@Before
	public void setup()
	{
		String browser = getBrowserName();
			
		try{
            //Use WebDriver Factory to get the Driver object instead of driver = new ChromeDriver()
            driver = WebDriverFactory.getWebDriverForBrowser("chrome");
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail("Incorrect Browser Sent. Check the Stack Trace");
        }
	}

	@After
	public void Clean_UP() throws InterruptedException 
	{
		Thread.sleep(5000);	
		driver.quit();
	}

}
