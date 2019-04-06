package com.qa.StepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.base.TestBase;
import com.qa.util.Utilities;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class HookSteps extends TestBase{

	
	
	@Before
    public void beforeScenario(Scenario scenario) throws IOException{
        System.out.println("This will run before the Scenario");
        Reporter.assignAuthor("LM - Swadhin Sahoo");
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Windows 7" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.5.2");
        Reporter.setSystemInfo("Java Version", "1.8.0_151");
        
        TestBase.loadCommonSetting();
        //TestBase.initialization();
        TestBase.saucelablogin();
       
       
    } 
	
	
	@After(order = 1)
	 public void afterScenario(Scenario scenario) {
	 if (scenario.isFailed()) {
	 String screenshotName = scenario.getName().replaceAll(" ", "_");
	 try {
		 String destinationPath = Utilities.getscreenshot(driver,screenshotName );  
	 
	 //This attach the specified screenshot to the test
	 Reporter.addScreenCaptureFromPath(destinationPath.toString());
	 } catch (IOException e) {
	 } 
	 }
	 }
	
 
 @After(order = 0)
    public void afterScenario() throws IOException{
	    
        System.out.println("This will run after the Scenario");
        Reporter.addStepLog(link);
        driver.quit();
       
       
    }
	
}
