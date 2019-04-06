package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;


public class HomePage extends TestBase{
	
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateHomePageTitle() throws InterruptedException
	{
		Thread.sleep(8000);
		return driver.getTitle();
	}
	
	

}
