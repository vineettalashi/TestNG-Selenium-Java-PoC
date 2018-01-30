package com.freecrm.helper.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectUtils {
	

	
	public static List<WebElement> getDesiredListOfElements(WebDriver driver, By locator)
	{	
		List<WebElement> listOfWebElements = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(locator);
         for (WebElement webElement : elements) {
			try
			{
				if(webElement.isDisplayed()){
					
				highlightElement(driver,webElement);
				listOfWebElements.add(webElement);
								
			}
			}
         
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
         }
         
         return listOfWebElements;
         }
	
	
	public static WebElement getDesiredElement(WebDriver driver, By locator)
	{
		List<WebElement> elements = driver.findElements(locator);
         for (WebElement webElement : elements) {
			try
			{
				if(webElement.isDisplayed()){
					
				highlightElement(driver,webElement);
				return webElement;
								
			}
			}
         
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
         }
         
         return null;
         }

	
	public static void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor=\"yellow\";", element);
	}

}
