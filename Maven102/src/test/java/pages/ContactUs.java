package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import helper.Utility;

public class ContactUs {
	
	WebDriver driver;
	
	public ContactUs(WebDriver d)
	{
		this.driver = d;
	}
	
	@FindBy(xpath="//a[@title='Contact Us']") WebElement contactButton;
	@FindBy(id="id_contact") WebElement subHeading;
	@FindBy(name="id_order") WebElement orderRef;
	@FindBy(name="id_product") WebElement product;
	@FindBy(id="fileUpload") WebElement attachFile;
	@FindBy(id="message") WebElement message;
	@FindBy(id="submitMessage") WebElement submit;
	
	public void ClickContact()
	{
		Utility.waitForWebElement(driver, contactButton).click();
	}
	
	public void SelectSubHeading(String heading)
	{
		Select dropdown = new Select(subHeading);
		dropdown.selectByVisibleText(heading);
	}
	
	public void SelectOrderRef(String order)
	{
		Select dropdown = new Select(orderRef);
		dropdown.selectByVisibleText(order);
	}
	
	public void SelectProduct(String pro)
	{
		Select dropdown = new Select(product);
		dropdown.selectByVisibleText(pro);
	}
	
	public void AttachFile()
	{
		attachFile.sendKeys("/Users/shaheenarahman/Desktop/IMG_9464.jpg");
	}
	
	public void AttachMessage(String m)
	{
		Utility.waitForWebElement(driver, message).sendKeys(m);
	}
	
	public void Submit()
	{
		Utility.waitForWebElement(driver, submit).click();
	}

}
