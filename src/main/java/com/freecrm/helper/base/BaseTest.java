package com.freecrm.helper.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import org.openqa.selenium.firefox.FirefoxDriver;*/
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.freecrm.utils.ConfigProvider;


public class BaseTest {
	
	public WebDriver driver;
	
	
	public void initialize()
	{	
		
		driver = getWebDriver(ConfigProvider.get("browser"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public WebDriver getWebDriver(String browser)
	{
		if(browser.equalsIgnoreCase("IE")){
			
					System.setProperty("webdriver.ie.driver", ConfigProvider.get("IEDriverPath"));
				   driver = new InternetExplorerDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", ConfigProvider.get("chromeDriverPath"));
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-infobars");
			driver = new ChromeDriver(chromeOptions);
		}
		else if(browser.equalsIgnoreCase("firefox")){
						System.setProperty("webdriver.gecko.driver", ConfigProvider.get("FirefoxDriverPath"));
					   driver = new FirefoxDriver();
		}
		else
			{
			System.out.println("Invalid Browser Selection. Please choose from IE|chrome|firefox");
		 			
		}
		
		return driver;
				
	}
	
	public void launchApp(String URL)
	{
		driver.get(URL);
	}

}
