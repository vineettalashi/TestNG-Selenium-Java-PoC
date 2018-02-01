package com.freecrm.test.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.freecrm.utils.ConfigProvider;
import com.freecrm.utils.Listeners.ExtentTestNGReportBuilder;

public class BaseTest extends ExtentTestNGReportBuilder{
	
	protected WebDriver driver;
	//protected ExtentTestNGReportBuilder report;

	
	public void initializeSetUp()
	{
		
		driver = DriverManger.getDriver(ConfigProvider.get("browser"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public void launchApplication() {
		
		driver.get(ConfigProvider.get("url"));

	}
	
	//testing branch pull request
	

}
