package com.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.qa.base.TestBase;
import com.qa.util.BrowserActions;
import com.qa.util.Utilities;
import com.qa.util.WaitUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class LoginPage extends TestBase {
	
	private static final Logger logger = Logger.getLogger(LoginPage.class);
    int timeout=30;
 
    //public static ExtentReports extent;
	
	
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
	
     
    @FindBy(id ="userName")
    public static WebElement userNamefield;
	
	public boolean login(String un,String pwd) throws InterruptedException
	{
		
		WaitUtil.waitForElement(driver, userNamefield, 2);
		boolean login = false;
		if(userNamefield.isDisplayed())
		{
		BrowserActions.type(un, userNamefield);
		Thread.sleep(2000);
		login = true;
		
		}
		else
		{
			login = false;
		}
		
		
		//return new HomePage();
		return login;
	}
	
	
	
	


}
