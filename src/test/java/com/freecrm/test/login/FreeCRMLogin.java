package com.freecrm.test.login;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.po.FCHomePage;
import com.freecrm.utils.ConfigProvider;
import com.freecrm.utils.ExcelUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class FreeCRMLogin extends BaseTest
{	
	ExtentReports extent;
	ExtentTest reporter;
	
	@BeforeMethod(alwaysRun=true)
	void init() {
		extent = new ExtentReports(ConfigProvider.get("extentReport"));
		reporter = extent.startTest(this.getClass().getSimpleName());		
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
		reporter.log(LogStatus.PASS, "Login Step", "Enter UN and PWD and Click on Login");
		homepage.switchToMainPanelFrame();
		reporter.log(LogStatus.PASS, "Login Step", "Switch to Main Panel");
		Assert.assertEquals(homepage.verifyCRMPROLogoText(), true);
		reporter.log(LogStatus.PASS, "Login Step", "Verify Logo Text");
	}
	
	@AfterMethod
	void tearDown()
	{
		System.out.println("Tearing Down..");
		extent.endTest(reporter);
		extent.flush();
	    extent.close();
	  //driver.get("file:///C:/Users/vinee/OneDrive/vtafselenium/test-output/extent.html");
	    driver.quit();
	}
	
}
