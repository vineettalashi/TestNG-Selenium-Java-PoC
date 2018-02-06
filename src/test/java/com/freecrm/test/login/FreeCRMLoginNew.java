package com.freecrm.test.login;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.helper.base.BaseTest;
import com.freecrm.po.FCHomePage;
import com.freecrm.utils.ExcelUtil;



public class FreeCRMLoginNew extends BaseTest 
{	
	@BeforeMethod
	void initialize(Method method) {
		beforeMethod(method);
		System.out.println("Driver Initialization Started...");		
	}
	
	@DataProvider(name="getTestData")
	public Object[][] getAllTestData()
	{
		return ExcelUtil.getAllTestData("testdata", "Sheet1");
	}
	
	@Test(description="Free CRM Login Test" ,dataProvider="getTestData", groups= {"Author:Vineet"})
	public void FreeCRMLoginTestNew(HashMap<String, String> testdata)
	{	
	
		super.initializeSetUp();
		launchApplication();
		Assert.assertEquals(driver.getTitle(), "#1 Free CRM for Any Business: Online Customer Relationship Software");
		
		FCHomePage homepage = PageFactory.initElements(driver, FCHomePage.class);
		
		homepage.enterUserName(testdata.get("Username"));
		Reporter().log(Reporter().getStatus(), "Step 1 :: Enter Username:: "+testdata.get("Username"));
		
		homepage.enterPassword(testdata.get("Password"));
		Reporter().log(Reporter.get().getStatus(), "Step 2 ::  Enter Password:: ********");
		
		homepage.clickLoginButton();
		Reporter().log(Reporter.get().getStatus(), "Step 3 ::  Click on Submit buton");
		
		homepage.switchToMainPanelFrame();
		Reporter().log(Reporter.get().getStatus(), "Step 4 :: Switch to Main panel");
		
		Assert.assertEquals(homepage.verifyCRMPROLogoText(), false);
		Reporter().log(Reporter.get().getStatus(), "Step 5 :: verify CRMPRO Logo Text");
		
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
	    
		generateReport(result,driver);
		System.out.println("Tearing Down..");
		driver.quit();
	}
	
}
