package helper;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Utility {

	// Using "By"
	public static WebElement waitForWebElement(WebDriver driver, By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		return driver.findElement(element);
	}
	
	//Using WebElement
	public static WebElement waitForWebElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		return element;
	}
	
	public static void validateMessage(WebElement element, String msg)
	{
		Assert.assertEquals(element.getText(), msg);
	}
	
	public static void validatePartialText(WebElement element, String msg)
	{
		Assert.assertTrue(element.getText().contains(msg));
	}
	
	public static void validateTitle(WebDriver driver, String title)
	{
		boolean status = new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains(title));
		Assert.assertTrue(status);
	}
	
	public static void validateContainsTitle(WebDriver driver, String title)
	{
		boolean status = new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains(title));
		Assert.assertTrue(status);
	}
	
	public static void verifyCurrentURL(WebDriver driver, String url)
	{
		boolean status = new WebDriverWait(driver, 30).until(ExpectedConditions.urlContains(url));
		Assert.assertTrue(status);
	}
	
	public static void dismissAlert(WebDriver driver)
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent()).dismiss();
	}
	
	public static void acceptAlert(WebDriver driver)
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent()).accept();
	}
	
	public static void verifyAlertMsg(WebDriver driver, String msg)
	{
		boolean status = new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent()).getText().equalsIgnoreCase(msg);
		Assert.assertTrue(status);
	}
	
	public static void handleFrame(WebDriver driver, int index)
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}

	public static String captureScreenshot(WebDriver driver) {
		
		String time = getTime();
		String destination=System.getProperty("user.dir")+"/screenshots/HRM"+time+".png";
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src, new File(destination));
		}catch(IOException e) 
		{
			System.out.println("Screenshot Failed: " + e.getMessage());
		}
		
		return destination;
	}

	public static String getTime() {
		
		DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		
		return dateFormat.format(new Date());
	}
	
	

}
