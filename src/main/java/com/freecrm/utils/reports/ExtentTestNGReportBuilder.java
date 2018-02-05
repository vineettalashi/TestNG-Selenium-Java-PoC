package com.freecrm.utils.reports;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.freecrm.utils.GetScreenShot;

public class ExtentTestNGReportBuilder {

	protected static ExtentReports extent;
	protected static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    protected static ThreadLocal<ExtentTest> Reporter = new ThreadLocal<ExtentTest>();

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentReportManager.getInstance("./extent.html");
	}
	
    public static ExtentTest Reporter() {
		return Reporter.get();
	}

	@BeforeClass
    public synchronized void beforeClass() {
        ExtentTest parent = extent.createTest(getClass().getSimpleName());
        parentTest.set(parent);
    }

   
    public synchronized void beforeMethod(Method method) {
        ExtentTest child = parentTest.get().createNode(method.getName());
        Reporter.set(child);
    }

    
    public synchronized void generateReport(ITestResult result, WebDriver driver) {
    	 if (result.getStatus() == ITestResult.FAILURE)
	        {     	
	        	try {
	        		Reporter.get().fail(result.getThrowable());
					Reporter.get().addScreenCaptureFromPath(GetScreenShot.capture(driver, result.getName()));
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        else if (result.getStatus() == ITestResult.SKIP)
	        	Reporter.get().skip(result.getThrowable());
	        else
	        	Reporter.get().pass("Test passed");
        extent.flush();
    }
}