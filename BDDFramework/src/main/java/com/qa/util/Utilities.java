package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;







public class Utilities extends TestBase {
	
	static int timetowait=30;
	
	static Workbook book;
	static Sheet sheet;
	public static String TESTDATA_SHEET_PATH = ".//src//test//resources//testdata.xlsx";
	//static WebElement ele;
	
    
    
    
    
    public static WebElement waitforElementDisplayed(WebDriver driver,By locator,int time)
	 {
		   
    	    WebElement  ele = null;
			WebDriverWait wait = new WebDriverWait(driver,time);
			ele = driver.findElement(locator);
			wait.until(ExpectedConditions.visibilityOf(ele));
				//Actions act = new Actions(driver);
				//act.moveToElement(ele).build().perform();
			return ele;
			
	  }
	 
	
	 public static void clickdynamicelement(By locator){ 
			try {
				 if(Utilities.waitforElementDisplayed(driver,locator,timetowait).isDisplayed())
				 {
					 
					 Utilities.waitforElementDisplayed(driver,locator,timetowait).click();
				 }
				
			} catch (Exception e) {
				// TODO: handle exception
			}  
			 
		 }
	 

	  //Get test data from excel
	  public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException
	  {
		  FileInputStream file = null;
		  try{
			  file = new FileInputStream(TESTDATA_SHEET_PATH);
			 }
		  
		  catch (FileNotFoundException e)
		  {
			  e.printStackTrace();
		  }
		  
		  try
		  {
			  book = WorkbookFactory.create(file);
			  
		  }
		  catch(InvalidFormatException e)
		  {
			  e.printStackTrace();
		  }
		  catch(IOException e)
		  {
			  e.printStackTrace();
		  }
		  
		  sheet = book.getSheet(sheetName);
		  Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		  
		  for(int i=0;i<sheet.getLastRowNum();i++)
		  {
			  for(int k =0;k<sheet.getRow(0).getLastCellNum();k++)
			  {
				  data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			  }
		  }
		  
		  return data;
		  
	  }
	 
	  
	  public static void flash(By locator,WebDriver driver)
	  { 
		  
		  WebElement ele = null;
		  ele = driver.findElement(locator);
		 
		  JavascriptExecutor js = ((JavascriptExecutor)driver);
		  
		  String bgcolor = ele.getCssValue("backgroundColor");
		  for(int i=0;i<10;i++)
		  {
			  changeColor("rgb(0,0,0)", locator, driver);
			  changeColor(bgcolor, locator, driver);
		  }
	  }
	  
	  public static void changeColor(String color,By locator,WebDriver driver)
	  {
		  WebElement ele = null;
		  ele = driver.findElement(locator);
		  JavascriptExecutor js = ((JavascriptExecutor)driver);
		  js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", ele);
		  try
		  {
			  Thread.sleep(20);
		  }
		  catch(Exception e)
		  {
			  
		  }
	  }
	  
	  
		public static String getscreenshot(WebDriver driver,String sceenshotName) throws IOException
		{
			//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts= (TakesScreenshot)driver;
	       	File source = ts.getScreenshotAs(OutputType.FILE);
		 	
		 	String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + sceenshotName +".png";
		 	File finalDestination = new File(destination);
		 	FileUtils.copyFile(source, finalDestination);
			
		 	
		 	return destination;
		 	
		}
		
		public static void takeScreenshotAtEndOfTest() throws IOException
		{
			File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(srcfile, new File(currentDir + "/Exceptionscreenshots/"+System.currentTimeMillis()+".png"));
			
		}
		
		
		

	  
	  
	  

}
