package com.freecrm.utils.Listeners;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.freecrm.utils.GetScreenShot;

public class ExtentTestNGReportBuilder {

	protected static ExtentReports extent;
	protected static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    protected static ThreadLocal<ExtentTest> Reporter = new ThreadLocal<ExtentTest>();

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManagerNew.getInstance("./extent.html");
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
					Reporter.get().addScreenCaptureFromPath(GetScreenShot.capture(driver, "Failed Screenshot"));
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

 class ExtentManagerNew {
    
    private static ExtentReports extent;
    
    public static ExtentReports getInstance(String fileName) {
    	if (extent == null)
    		createInstance(fileName);
    	
        return extent;
    }
    
    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        return extent;
    }
}

