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
import com.freecrm.utils.ConfigProvider;
import com.freecrm.utils.ExcelUtil;



public class FreeCRMLogin extends BaseTest
{	
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ExtentTest reporter;
	
	@BeforeMethod(alwaysRun=true)
	void init() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		htmlReporter.setAppendExisting(true);
		extent = new ExtentReports();	
		extent.attachReporter(htmlReporter);
		reporter = extent.createTest(this.getClass().getSimpleName(), "FreeCRMLogin Test");
		System.out.println("Driver Initialization Started...");
		super.initializeSetUp();
		launchApplication();
		Assert.assertEquals(driver.getTitle(), "#1 Free CRM for Any Business: Online Customer Relationship Software");
		extent.removeTest(reporter);
		extent.flush();
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
		reporter.log(Status.PASS,"Enter UN and PWD and Click on Login");
		homepage.switchToMainPanelFrame();
		reporter.log(Status.PASS,"Switch to Main Panel");
		Assert.assertEquals(homepage.verifyCRMPROLogoText(), true);
		reporter.log(Status.PASS,"Verify Logo Text");
		
	   // extent.close();
	}
	
	@AfterMethod
	void tearDown()
	{
		System.out.println("Tearing Down..");
		
	  //driver.get("file:///C:/Users/vinee/OneDrive/vtafselenium/test-output/extent.html");
	    driver.quit();
	}
	
}
