package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.StepDefinition.LoginPageSteps;
import com.qa.util.WebEventListener;



public class TestBase {

	public static Properties prop;
	public static Properties prop1;
	 
	 public static EventFiringWebDriver e_driver;
	 public static WebEventListener eventListner;	
	 public static WebDriver driver;
	 public static ExtentTest test;
	 public static ExtentReports extent;
		
	 public final static String USERNAME = "swadhinsangram1";
	 public static final String ACCESS_KEY = "eea9d66a-ad30-43fa-8d4b-cd81889961a2";
	 public static final String sauceURL1 = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
		
	 private static final Logger logger = Logger.getLogger(TestBase.class);
	 
	 public static String message=null; 
		public static String FinalURLOfBuild="https://app.saucelabs.com/tests/";
		public static String link=null;	
		
	 public TestBase()
	  {
		  try
		  {
		  prop=new Properties();
		  FileInputStream fis=new FileInputStream(".\\src\\main\\java\\com\\qa\\config\\config.properties");
		   prop.load(fis);
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
	  }
	 
	 
	 public static void loadCommonSetting() throws IOException
	    
	    {
	    String envm = prop.getProperty("test_environment");
	    System.out.println("env "+envm);
	    	if(envm.equals("dev"))
	    	{
	    		 prop1=new Properties();
	    		FileInputStream fis=new FileInputStream(".\\src\\main\\java\\com\\qa\\config\\dev.properties");
	    		prop1.load(fis);
			for (String propfile : prop1.stringPropertyNames()) {
				prop1.setProperty(propfile, prop1.getProperty(propfile)
						.replace("\"", ""));
			}
			System.out.println(prop.getProperty("test_environment") 
					+ ".properties file has been loaded successfully!");
	    	}
	    	else if(envm.equals("qa"))
	    	{
	    		prop1=new Properties();
	    		FileInputStream fis=new FileInputStream(".\\src\\main\\java\\com\\qa\\config\\qa.properties");
	    		prop1.load(fis);
			for (String propfile : prop1.stringPropertyNames()) {
				prop.setProperty(propfile, prop1.getProperty(propfile)
						.replace("\"", ""));
			}
			System.out.println(prop.getProperty("test_environment") 
					+ ".properties file has been loaded successfully!");
	    	}
	    		
	    }
	
	 
	  public static void initialization() 
	  {
		  String browserName = prop.getProperty("browserType");
		  if(browserName.equals("Firefox-Win7"))
		  {
			  System.setProperty("webdriver.gecko.driver",".\\Browser\\geckodriver19.exe");
		    driver=new FirefoxDriver();
		  }
		  else if(browserName.equals("Chrome-Win7"))
		  {
			  //ChromeOptions chromeOptions= new ChromeOptions();
				//chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			  System.setProperty("webdriver.chrome.driver",".\\Browser\\chromedriverlatest.exe");
			   driver=new ChromeDriver();
			 
		  }
		  e_driver = new EventFiringWebDriver(driver);
		 eventListner = new WebEventListener();
		  e_driver.register(eventListner);
		  driver = e_driver;
		  
		  
		  
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		  driver.get(prop1.getProperty("baseUrl"));
	  }
	  
	  public static void saucelablogin() throws MalformedURLException
	    {
	    	 DesiredCapabilities capabilities = new DesiredCapabilities();
	         capabilities.setCapability("username", USERNAME);
	         capabilities.setCapability("accessKey", ACCESS_KEY);
	         capabilities.setCapability("browserName", "Chrome");
	         capabilities.setCapability("platform", "Windows 8");
	         capabilities.setCapability("version", "73.0");
	         
	        
	         driver = new RemoteWebDriver(new URL(sauceURL1), capabilities);
	         printSessionId();
	         
			  driver.manage().window().maximize();
			  driver.manage().deleteAllCookies();
			  driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
			  driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			  driver.get("https://www.google.com/");
			  
	       
	    } 
	  
	  public static void printSessionId() {
		  
		    message=String.format((((RemoteWebDriver) driver).getSessionId()).toString());
			System.out.println(message);
			 link="<a href='"+FinalURLOfBuild.concat(message)+"'> Saucelab link </a>";		
			System.out.println(link);
			
		} 
	  
	  
	 
}
