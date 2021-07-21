package com_SkillRray_genericLib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Bharani
 *
 */
public class BaseClass {
	public WebDriver driver;
	public FileUtilies fileutilies=new FileUtilies();
	public WebDriverUtilies driverUtilies=new WebDriverUtilies();
	public static Connection con;
	public static  ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;
	/**
	 * Connection to database
	 * Report
	 * @throws SQLException
	 */
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("*******connected to Database***********");
		 con = FileUtilies.getDataDb();
		 
    htmlreport=new ExtentHtmlReporter(AutoConstant.reportsPath);
	htmlreport.config().setDocumentTitle("SkillRaryReport");
	htmlreport.config().setTheme(Theme.DARK);
    reports=new ExtentReports();
	reports.attachReporter(htmlreport);
	
	}
	/**
	 * Open the application
	 * Enter the url
	 * wait  for DOM elements 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	@BeforeMethod
	public void openApp() throws FileNotFoundException, IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fileutilies.getpropertyData("url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		}
	/**
	 * Verify the testscript results
	 * Takes the screenshot of failed testcases
	 * Close the application
	 * @param r
	 * @throws IOException
	 */
	
	@AfterMethod
	public void closeApp(ITestResult r) throws IOException {
		int result = r.getStatus();
		String name = r.getName();
		if(result==ITestResult.FAILURE) {
			test.log(Status.FAIL,r.getName()+"Test case Failed");
			test.log(Status.FAIL,r.getThrowable()+"Test case failed exception");
			test.addScreenCaptureFromPath(driverUtilies.screenshot(driver,name));
			
		}
		else if(result==ITestResult.SUCCESS) {
			test.log(Status.PASS,r.getName()+"Test case are passed");
		}
		else if(result==ITestResult.SKIP) {
			test.log(Status.SKIP,r.getName()+"Test case are skipped");
		}
		driver.quit();
	}
	/**
	 * close the databaseconnection
	 * flush the reports
	 * @throws SQLException
	 */
	
	@AfterSuite
	public void configAS() throws SQLException {
		htmlreport.flush();
		reports.flush();
		fileutilies.closedb();
		System.out.println("***********Database is closed*********");
	}

}
