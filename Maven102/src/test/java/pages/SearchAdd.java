package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import helper.Utility;

public class SearchAdd {
	
	WebDriver driver;
	
	public SearchAdd(WebDriver d)
	{
		this.driver = d;
	}
	
	@FindBy(name="search_query") WebElement searchBox;
	@FindBy(name="submit_search") WebElement searchButton;
	@FindBy(xpath="//img[@title='Printed Summer Dress']") WebElement dress;
	@FindBy(xpath="//a[@class='button ajax_add_to_cart_button btn btn-default']") WebElement addToCart;
	@FindBy(xpath="//a[@title='Proceed to checkout']") WebElement proceed;
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']") WebElement checkout;
	@FindBy(name="processAddress") WebElement processAdd;
	@FindBy(id="uniform-cgv") WebElement tick;
	@FindBy(name="processCarrier") WebElement finalProcess;
	@FindBy(xpath="//a[@title='Pay by bank wire']") WebElement byBank;
	@FindBy(xpath="//a[@title='Pay by check.']") WebElement byCheck;
	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button") WebElement submit;
	

	public void SearchQuery(String s)
	{
		Utility.waitForWebElement(driver, searchBox).sendKeys(s);
	}
	
	public void ClickSearch()
	{
		Utility.waitForWebElement(driver, searchButton).click();
	}
	
	public void AddDress()
	{
		Actions action = new Actions(driver);
		action.moveToElement(dress).build().perform();
		
		Utility.waitForWebElement(driver, addToCart).click();
	}
	
	public void ProceedtoCheckout()
	{
		Utility.waitForWebElement(driver, proceed).click();
	}
	
	public void Checkout()
	{
		Utility.waitForWebElement(driver, checkout).click();
	}
	
	public void ProcessAddress()
	{
		Utility.waitForWebElement(driver, processAdd).click();
	}
	
	public void TermsAndAgg()
	{
		Utility.waitForWebElement(driver, tick).click();
	}
	
	public void ProcessCarrier()
	{
		Utility.waitForWebElement(driver, finalProcess).click();
	}
	
	public void ProcessPayment(String type)
	{
		if(type.equalsIgnoreCase("Bank"))
		{
			Utility.waitForWebElement(driver, byBank).click();
		}
		else if(type.equalsIgnoreCase("Check"))
		{
			Utility.waitForWebElement(driver, byCheck).click();
		}
	}
	
	public void Submit()
	{
		Utility.waitForWebElement(driver, submit).click();
	}
	
}
