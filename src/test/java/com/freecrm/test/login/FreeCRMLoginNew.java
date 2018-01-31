package com.freecrm.test.login;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.freecrm.po.FCHomePage;
import com.freecrm.utils.ExcelUtil;

@Listeners(com.freecrm.utils.Listeners.ExtentReporterNG.class)
public class FreeCRMLoginNew extends BaseTest 
{	
	/*ExtentReports extent;
	ExtentTest reporter;*/
	
	@BeforeMethod(alwaysRun=true)
	void init() {
		/*extent = new ExtentReports("./extent.html");
		reporter = extent.startTest(this.getClass().getSimpleName());*/		
		System.out.println("Driver Initialization Started...");
		super.initializeSetUp();
		launchApplication();
		Assert.assertEquals(driver.getTitle(), "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@DataProvider(name="getTestData")
	public Object[][] getAllTestData()
	{
		
		return ExcelUtil.getAllTestData("testdata", "Sheet1");
	}
	
	@Test(description="Free CRM Login Test" , dataProvider="getTestData")
	public void FreeCRMLoginTestPositive(HashMap<String, String> testdata) throws Exception
	{	

		FCHomePage homepage = PageFactory.initElements(driver, FCHomePage.class);
		homepage.enterUserName(testdata.get("Username"));
		homepage.enterPassword(testdata.get("Password"));
		homepage.clickLoginButton();
		Reporter.log("Login Step : Enter UN and PWD and Click on Login");
		homepage.switchToMainPanelFrame();
		Reporter.log("Login Step : switchToMainPanelFrame");
		Assert.assertEquals(homepage.verifyCRMPROLogoText(), true);
		Reporter.log("Login Step : verifyCRMPROLogoText");
	}
	
	@AfterMethod
	void tearDown()
	{
		System.out.println("Tearing Down..");
		/*extent.endTest(reporter);
		extent.flush();
	    extent.close();*/
	    //driver.get("C:\\Users\\Vineet_Talashi\\eclipse-workspace\\VTAF-Beta\\vtafselenium\\extent.html");
		//driver.quit();
	}
	
}
