package com.freecrm.test.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.freecrm.utils.ConfigProvider;

public class BaseTest {
	
	protected WebDriver driver;

	
	public void initializeSetUp()
	{
		
		driver = DriverManger.getDriver(ConfigProvider.get("browser"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public void launchApplication() {
		
		driver.get(ConfigProvider.get("url"));

	}

	

}
