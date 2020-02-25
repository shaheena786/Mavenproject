package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.Utility;

public class Login{
	
	WebDriver driver;
	
	public Login(WebDriver d)
	{
		this.driver = d;
	}
	
	@FindBy(xpath="//a[@class='login']") WebElement signIn;
	@FindBy(id="email") WebElement email;
	@FindBy(id="passwd") WebElement password;
	@FindBy(id="SubmitLogin") WebElement submit;
	
	public void validateHomePage()
	{
		Utility.validateContainsTitle(driver, "My Store");
	}
	
	public void clickSignInButton()
	{	
		Utility.waitForWebElement(driver, signIn).click();
		System.out.println("LOG:INFO Clicked on Sign in button");
	}
	
	public void enterUserName(String e)
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver, email).sendKeys(e);
	}
	
	public void enterPassword(String p)
	{
		System.out.println("LOG:INFO Password Entered");
		Utility.waitForWebElement(driver, password).sendKeys(p);
	}
	
	public void clickLoginButton()
	{	
		Utility.waitForWebElement(driver, submit).click();
		System.out.println("LOG:INFO Clicked on login button");
	}
	
	
}

