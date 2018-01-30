package com.freecrm.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.freecrm.helper.base.BasePageObject;

public class FCHomePage extends BasePageObject
{
	
	public FCHomePage(WebDriver driver) {		
		super(driver);
	}
	
	public enum ELEMENT 
	{
		username_textfield(By.xpath("//input[@name='username']")),
		password_textfield(By.xpath("//input[@name='password']")),
		login_button(By.cssSelector(".btn-small")),
		crmpro_text(By.xpath("//td[contains(text(),'CRMPRO')]")),
		mainpanel_frame(By.xpath("//frame[contains(@name,'mainpanel')]")),
		;
		
		
		private By findBy;
		
		public By getLocator()
		{
			return findBy;
			
		}
		private ELEMENT(By locator) {
			this.findBy=locator;
		}
	}
	
	
	public void enterUserName(String user)
	{
		enterDataInTextField(ELEMENT.username_textfield.getLocator(),user);
	}
	
	public void enterPassword(String pwd)
	{
		enterDataInTextField(ELEMENT.password_textfield.getLocator(),pwd);
	}
	
	public void clickLoginButton()
	{	
	
		clickElementUsingJS(ELEMENT.login_button.getLocator());
	}
	
	public boolean verifyCRMPROLogoText()
	{
		return verifyElementPresent(ELEMENT.crmpro_text.getLocator());
		
	}
	
	public void switchToMainPanelFrame()
	{
		switchToFrame(ELEMENT.mainpanel_frame.getLocator());
	}

	
}
