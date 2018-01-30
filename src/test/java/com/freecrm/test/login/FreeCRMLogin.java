package com.freecrm.test.login;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.freecrm.po.FCHomePage;
import com.freecrm.utils.ExcelUtil;
import com.freecrm.utils.reports.ExtentManager;



public class FreeCRMLogin extends BaseTest
{	
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeMethod(alwaysRun=true)
	void init() {
		extent = ExtentManager.GetExtent();
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
	public void FreeCRMLoginTestPositive(HashMap<String, String> testdata)
	{	
		try {
		test = extent.createTest("FreeCRMLoginTestPositive", "FreeCRMLogin");
		FCHomePage homepage = PageFactory.initElements(driver, FCHomePage.class);
		homepage.enterUserName(testdata.get("Username"));
		homepage.enterPassword(testdata.get("Password"));
		homepage.clickLoginButton();
		test.log(Status.PASS, "Enter username and Password and Click on login");
		homepage.switchToMainPanelFrame();
		Assert.assertEquals(homepage.verifyCRMPROLogoText(), false);
		
		test.log(test.getStatus(), "verifyCRMPROLogoText");
		
	}
	
		catch(Exception e)
		{
			test.log(Status.ERROR, e.getMessage());
		}
		
	}
	
	@AfterMethod
	void tearDown() 
	{
		System.out.println("Tearing Down..");
		//extent.removeTest(test);
		extent.flush();
//		extent.close();
	  //driver.get("file:///C:/Users/vinee/OneDrive/vtafselenium/test-output/extent.html");
	    driver.quit();
	}
	
}
