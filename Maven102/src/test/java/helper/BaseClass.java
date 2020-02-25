package helper;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dataProviderFactory.DataProviderFactory;

public class BaseClass {
	
	//Creating objects to refer back instead of calling the .jar files every time.
	
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupReport()
	{
		System.out.println("LOG INFO: Before suite running...setting up report");
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/AP" + Utility.getTime()+ ".html" ));
		report = new ExtentReports();
		report.attachReporter(reporter);
		
		System.out.println("LOG INFO: After suite running...reports are ready to use");
	}
	
	@BeforeClass
	public void setupBrowser()
	{
		System.out.println("LOG INFO: Creating browser session");
		driver = browserFactory.StartBrowser(DataProviderFactory.getConfig().getBrowser(),
											DataProviderFactory.getConfig().getStagingURL());
		
		System.out.println("LOG INFO: Browser session created");
	}
	
	@AfterMethod
	public void appendReport(ITestResult result)
	{
		System.out.println("Test Name " + result.getName());
		System.out.println("LOG INFO: After method running...Generating Test Report");
		
		int status = result.getStatus();
		
		if(status==ITestResult.SUCCESS)
		{
			try {
				logger.pass("Test Scenario Passed ", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			}catch(IOException e)
			{
				System.out.println("Not able to attach screenshot");
			}
		}
		else if(status==ITestResult.FAILURE)
		{
			try {
				logger.fail("Test Failed " + result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			}catch(IOException e)
			{
				System.out.println("Not able to attach screenshot");
			}
		}
		else if(status==ITestResult.SKIP)
		{
			logger.skip("Test Scenario Skipper");
		}
		
		report.flush();
		
		System.out.println("LOG INFO: After method executed...Test Result appended to report ");
		
	}
	
	@AfterClass
	public void closeSession()
	{
		System.out.println("LOG INFO: Closing browser session");
		driver.quit();
		System.out.println("LOG INFO: Browser session closed");
	}
	
	
	
}
