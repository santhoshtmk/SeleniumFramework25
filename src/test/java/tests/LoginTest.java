package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest{
	
	
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException
	{
		String filepath=System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filepath, "sheet1");
		int rowCount=ExcelUtils.getRowCount();
		Object[][] data=new Object[rowCount-1][2];
		
		for(int i=1;i<rowCount;i++)
		{
			data[i-1][0]=ExcelUtils.getCellData(i,0);
			data[i-1][1]=ExcelUtils.getCellData(i,1);
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
	@Test(dataProvider="LoginData")
	public void testLoginWithValidCredentials(String email,String password)
	{
		Log.info("Starting login test....");
		test=ExtentReportManager.createTest("Login Test with valid credentials");
		
		test.info("Navigated to URL..");
		LoginPage loginpage=new LoginPage(driver);
		
		
		Log.info("Adding credentials");
		test.info("Adding credentials");
		loginpage.enterEmail(email);
		loginpage.enterPassword(password);
		test.info("Clicking on Login button");
		
		loginpage.clickLogin();
		
		System.out.println("Title of page is : "+driver.getTitle());
		test.info("Verifing page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		Log.info("Verified page title..");
		test.pass("Login successfull");
		
	}
	
	public void testLoginWithInvalidCredentials()
	{
		Log.info("Starting login test....");
		test=ExtentReportManager.createTest("Login Test with invalid credentials");
		
		test.info("Navigated to URL..");
		LoginPage loginpage=new LoginPage(driver);
		
		
		Log.info("Adding credentials");
		test.info("Adding credentials");
		loginpage.enterEmail("admin@yourstore.com");
		loginpage.enterPassword("admin");
		test.info("Clicking on Login button");
		loginpage.clickLogin();
		
		System.out.println("Title of page is : "+driver.getTitle());
		test.info("Verifing page title");
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store.. Login");
		Log.info("Verified page title..");
		test.pass("Login successfull");
		
	}
	
	

}
