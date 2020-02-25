package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class browserFactory {
	
	static WebDriver driver; //We made it static because it will stay consistent
	
	public static WebDriver StartBrowser(String browserName, String url)
	{
		if(browserName.equalsIgnoreCase("Safari"))
		{
			driver = new SafariDriver();
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			driver = new ChromeDriver();
		}
		
		driver.get(url);
		
		return driver;
	}

}
