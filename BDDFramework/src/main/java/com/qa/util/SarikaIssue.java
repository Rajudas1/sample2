package com.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SarikaIssue {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver",".\\Browser\\chromedriverlatest.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		// Open URL
		driver.get("http://text-help-poc-content.smdemo.info/content/reading/#/scoviewer");
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		
		
		/** The Slength. */
		By Slength = By.cssSelector("input[ng-model='enrollment_option.session_length']");

		/** The idel time. */
		By idelTime = By.cssSelector("input[ng-model='enrollment_option.idle_time']");

		/** The template. */
		By template = By.cssSelector("[ng-model='selectedTemplateType']");

		/** Grade */
		By dropDown = By.id("sm-grad");

		/** The first sco in sco list. */
		By firstScoInScoList = By.cssSelector("#scolist li:first-child");
		/** The launch button. */
		By launchButton = By.cssSelector("#buttonLaunch");

		/** The search field. */
		By searchField = By.xpath("//*[@ng-model='searchTerm']");

		/** The play button. */
		By playbutton = By.cssSelector("#enableIpad");

		/** The Constant TRANSLATE_BUTTON_OFF. */
		By TRANSLATE_BUTTON_OFF = By.cssSelector("button#textHelp");

		By QUESTION_TEXT = By.cssSelector("#treasurehunt_animation > div > span.treasure_label.text-help-translate.th-active");

		// Select Grade
		Select GradedropDown = new Select(driver.findElement(dropDown));
		GradedropDown.selectByVisibleText("3");

		// Template selection
		Select templatedropDown = new Select(driver.findElement(template));
		templatedropDown.selectByVisibleText("Treasure Hunt");

		// Session Length
		driver.findElement(Slength).clear();
		driver.findElement(Slength).sendKeys("45");

		// Idle Time
		driver.findElement(idelTime).clear();
		driver.findElement(idelTime).sendKeys("45");

		// Search LO
		driver.findElement(searchField).clear();
		driver.findElement(searchField).sendKeys("smre_ip_00183_s1");

		// Click first LO
		Thread.sleep(3000);
		driver.findElement(firstScoInScoList).click();

		// Launch
		driver.findElement(launchButton).click();

		// Switching to Frame
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("playerIFrame")));

		wait.until(ExpectedConditions.elementToBeClickable(playbutton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(playbutton));

		// Nap to wait till intro video completes
		Thread.sleep(5000);

		// Click on Translator button
		wait.until(ExpectedConditions.elementToBeClickable(TRANSLATE_BUTTON_OFF));
		js.executeScript("arguments[0].click();", driver.findElement(TRANSLATE_BUTTON_OFF));
		Thread.sleep(5000);
		boolean flag=driver.findElement(By.xpath(".//span[contains(text(),'Choose a treasure.')]")).isDisplayed();
		System.out.println("Choose option display or not " +flag);
		
		if(flag==true)
		{
			WebElement ele=driver.findElement(By.xpath(".//div[@ng-if='showIntroAnimation']"));
			String javaScript =  "document.getElementsByClassName('th-active')[0].dispatchEvent(new MouseEvent('mousedown', {" +
					   "bubbles: true," +
					   "cancelable: false," +
					   "view: window," +
					   "button: 2," +
					   "buttons: 0}))" ;
					js.executeScript(javaScript, ele);
			 
			 
		
		}else{
			System.out.println("Unable to locate choose option");
		}
		
			}
}
