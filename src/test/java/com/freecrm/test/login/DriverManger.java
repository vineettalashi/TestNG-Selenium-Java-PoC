package com.freecrm.test.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.DriverManagerType;
import com.freecrm.utils.ConfigProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManger {

	DriverManger driverManager;
	
	private DriverManger() {
		
	}
	
	public static WebDriver getDriver(String Browser)
	{
		WebDriver driver= null;
		try{
		if(null!=Browser && Browser.length()!=0) {
		switch (Browser) {
		case "chrome": WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
					   ChromeOptions options = new ChromeOptions();
					   options.addArguments("--disable-infobars");
					   driver = new ChromeDriver(options);
					   break;
					   
		case "firefox": WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
					    driver = new FirefoxDriver();
					    break;
					    
		case "edge": WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
	    			 driver = new EdgeDriver();
	    			 break;			    
		default:  System.out.println("Driver not found");
			       break;
		}
		
		}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return driver;
	}
}
