package com.qa.StepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageSteps extends TestBase {

	private static final Logger logger = Logger.getLogger(LoginPageSteps.class);
	
	
	LoginPage loginpage;
	HomePage  homepage;
	
	
	@Given("^user opens browser by hit the url$")
	public void user_opens_browser() throws Throwable {
		
		 System.out.println("open browser and login and navigate to home page");
	  
	  
	}

	@Then("^users logs in to the app and land in to home$")
	public void users_enters_username_and_password() throws Throwable {
		/*loginpage = new LoginPage();
		logger.assertLog(loginpage.login(prop1.getProperty("username"), prop1.getProperty("password")), "got failed");
		//driver.quit();
*/	  
	}

}
