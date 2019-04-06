package com.qa.StepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginPageSteps extends TestBase {

	private static final Logger logger = Logger.getLogger(LoginPageSteps.class);

	LoginPage loginpage;
	HomePage homepage;

	@Given("^user opens browser$")
	public void user_opens_browser() throws Throwable {
		System.out.println("open bowser and login page");

	}

	@Then("^users logs in to the app$")
	public void users_enters_username_and_password() throws Throwable {
		/*loginpage = new LoginPage();
		//driver.manage().window().setSize(new Dimension(1024, 768));
		logger.assertLog(loginpage.login(prop1.getProperty("username"), prop1.getProperty("password")), "got failed");*/
		

	}

}
