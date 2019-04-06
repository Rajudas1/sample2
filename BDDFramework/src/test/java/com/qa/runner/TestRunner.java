package com.qa.runner;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(
		features = ".\\src\\main\\java\\com\\qa\\features",
		glue={"com\\qa\\StepDefinition"},
		plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:cucumber-reports/report.html","json:target/cucumber.json"},
		monochrome = true,
		strict = true,
		
		dryRun = false
	
		)
public class TestRunner{
	

}

