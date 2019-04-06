package com.qa.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.base.TestBase;

public class Orderredlist {
	
	
	
	public static void main(String[] args) {
		
		 System.setProperty("webdriver.chrome.driver",".\\Browser\\chromedriver2.exe");
		WebDriver driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		  
		  driver.get("https://fdslive.oup.com/www.oup.com/elt/italy/prototype/resources.html");
		  List<WebElement> ele = driver.findElements(By.cssSelector("#filters ul[id='categories'] li"));
		  String[] arr = {"Everything","Assessment","Tests","Class resources","Teacher's Book",
					"Extra resources","Other components","Multimedia resources","Audio","Video","Oxford Papers","Programmazione"};
						
			 int count=0;
				   System.out.println(ele.size());
				   System.out.println(arr.length);
				   if(ele.size()==arr.length)
				   {
					   for(int i=0;i<=ele.size()-1;i++)
					   {
						   if(ele.get(i).getText().equals(arr[i]))
						   {
							   count++;
						   }
					   }
					   if(count==ele.size())
					   {
						   System.out.println("expected & actual elements are same");
					   }
				   }
				   else{
				System.out.println("actual elements & expected elements are not equal in size");

				   }
			  driver.quit();
		    
		   
		    
		    
		    
		    
		
		
		
	}

}
