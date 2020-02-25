package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import dataProviderFactory.DataProviderFactory;
import helper.BaseClass;
import pages.ContactUs;
import pages.Login;
import pages.SearchAdd;

public class CompleteAutomationTest extends BaseClass {

	Login login;
	SearchAdd sadd;
	ContactUs con;

	@Test(dataProvider="LoginData", priority=1)
	public void loginToAP(String uname,String pass) {

		login = PageFactory.initElements(driver, Login.class);

		logger = report.createTest("Login Test for AP");

		login.validateHomePage();

		logger.pass("Home Page Validated");
		
		login.clickSignInButton();

		login.enterUserName(uname);

		logger.info("Username entered");

		login.enterPassword(pass);

		logger.info("Password entered");

		login.clickLoginButton();

		logger.info("Clicked on Login button");

	}
	
	@DataProvider(name="LoginData")
	public Object[][] getDataFromSources()
	{
		
		System.out.println("LOG:INFO-Running Data Provider First to generate the data");
		
		int rows=DataProviderFactory.getExcel().getRows("LoginData");
		
		System.out.println("Total Rows in Excel "+rows );
		
		Object[][]arr = new Object[rows-1][2];
	
		for(int i=0;i<rows-1;i++)
		{
			arr[i][0]=DataProviderFactory.getExcel().getCellData("LoginData", i+1, 0);
			arr[i][1]=DataProviderFactory.getExcel().getCellData("LoginData", i+1, 1);
			
		}
		System.out.println("LOG:INFO-Data Provider is Ready for usage");

		return arr;
	}
	
	
	@Test(dataProvider="SearchItem", priority=2)
	public void SearchBuy(String sname,String payment) {

		sadd = PageFactory.initElements(driver, SearchAdd.class);
		logger = report.createTest("Search and Buy Test for AP");
		
		sadd.SearchQuery(sname);
		sadd.ClickSearch();
		sadd.AddDress();
		sadd.ProceedtoCheckout();
		sadd.Checkout();
		sadd.ProcessAddress();
		sadd.TermsAndAgg();
		sadd.ProcessCarrier();
		sadd.ProcessPayment(payment);
		sadd.Submit();
		
		logger.pass("Search and Buy Test Passed");

	}
	
	
	@DataProvider(name="SearchItem")
	public Object[][] getDataForSearchBuy()
	{
		
		System.out.println("LOG:INFO-Running Data Provider First to generate the data");
		
		int rows=DataProviderFactory.getExcel().getRows("SearchItem");
		
		System.out.println("Total Rows in Excel "+rows );
		
		Object[][]arr = new Object[rows-1][2];
	
		for(int i=0;i<rows-1;i++)
		{
			arr[i][0]=DataProviderFactory.getExcel().getCellData("SearchItem", i+1, 0);
			arr[i][1]=DataProviderFactory.getExcel().getCellData("SearchItem", i+1, 1);
			
		}
		System.out.println("LOG:INFO-Data Provider is Ready for usage");

		return arr;
	}
	
	@Test(dataProvider="Contact", priority=3)
	public void SearchBuy(String heading, String order, String product, String message) {

		con = PageFactory.initElements(driver, ContactUs.class);
		logger = report.createTest("Search and Buy Test for AP");
		
		con.ClickContact();
		con.SelectSubHeading(heading);
		con.SelectOrderRef(order);
		con.SelectProduct(product);
		con.AttachFile();
		con.AttachMessage(message);
		con.Submit();
		
		logger.pass("Contact Test Passed");
	}
	
	@DataProvider(name="Contact")
	public Object[][] getDataForContact()
	{
		
		System.out.println("LOG:INFO-Running Data Provider First to generate the data");
		
		int rows=DataProviderFactory.getExcel().getRows("Contact");
		
		System.out.println("Total Rows in Excel "+rows );
		
		Object[][]arr = new Object[rows-1][4];
	
		for(int i=0;i<rows-1;i++)
		{
			arr[i][0]=DataProviderFactory.getExcel().getCellData("Contact", i+1, 0);
			arr[i][1]=DataProviderFactory.getExcel().getCellData("Contact", i+1, 1);
			arr[i][2]=DataProviderFactory.getExcel().getCellData("Contact", i+1, 2);
			arr[i][3]=DataProviderFactory.getExcel().getCellData("Contact", i+1, 3);
			
		}
		System.out.println("LOG:INFO-Data Provider is Ready for usage");

		return arr;
	}
	
}
