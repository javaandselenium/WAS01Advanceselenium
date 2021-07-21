package com_SkillRray_genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
/**
 * Contains WebDriver specific resuable utility
 * @author QSP
 *
 */
public class WebDriverUtilies {
	/**
	 * Select the value from the dropdown based on visibletext
	 * @param ele
	 * @param text
	 */
	public void dropDown(WebElement ele,String text) {
		Select s=new Select(ele);
		s.selectByVisibleText(text);
		
	}
	/**
	 * Used to take mouse cursor on expected element on the browser
	 * @param driver
	 * @param ele
	 */
	public void mouseHover(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	/**
	 * Used to darg and drop from source to target element
	 * @param driver
	 * @param source
	 * @param target
	 */
	
	public void dragandDrop(WebDriver driver,WebElement source,WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	/**
	 * Used to perform doubleclick on the element
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	/**
	 * Used to switch to frame
	 * @param driver
	 */
	public void switchFrame(WebDriver driver) {
		driver.switchTo().frame(0);
	}
	/**
	 * Used to switch the control back from the frame
	 * @param driver
	 */
	public void switchBackfromBack(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * Used to scroll to required element
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollBar(WebDriver driver,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	/**
	 * Used to take the screenshot of failed testcases
	 * @param driver
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public String screenshot(WebDriver driver,String name) throws IOException {
		Date d=new Date();
		String date = d.toString().replaceAll(":","-");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(AutoConstant.photoPath+date+name+".png");
		FileUtils.copyFile(src, dest);
		return date;
		
		
	}
	/**
	 * Used to switch to alert popup and click on OK button
	 * @param driver
	 */
	
	public void alertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * Used to switch to another browser window
	 * @param driver
	 */
	
	public void switchTabs(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
	
		for(String b:child) {
			driver.switchTo().window(b);
		}
	}
	/**
	 * To verify the excepted page results
	 * @param actual
	 * @param expected
	 */
	
	public void verify(String actual,String expected) {
		Assert.assertEquals(actual, expected);
	}
	/**
	 * Used to wait for expected element visibility in GUI
	 * @param driver
	 * @param element
	 */
	public void explicitywait(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * It is used to click on element using javascriptexecutor
	 * @param driver
	 * @param element
	 */
	public void elementClick(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click(),",element);
	}
	
	
	
	
	

}
