package com_SkillRray_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryDemoLoginPage {
public WebDriver driver;
	@FindBy(id="course")
	private WebElement coursebtn;
	
	@FindBy(xpath="//a[text()='Selenium Training']")
	private WebElement seleniumTraining;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contactus;
	
	@FindBy(xpath="//a[text()='LOGIN']")
	private WebElement loginbtn;
	
	public SkillraryDemoLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	public WebElement getContactus() {
		return contactus;
	}

	public WebElement getCoursebtn() {
		return coursebtn;
	}

	public WebElement getSeleniumTraining() {
		return seleniumTraining;
	}
	
	public AddtoCartPage seleniumtrainingbtn() {
		seleniumTraining.click();
		return new AddtoCartPage(driver);
	}
	
	public ContactusPage contactusbtn() {
		contactus.click();
		return new ContactusPage(driver);
	}
	
	public DemoLoginPage loginButton() {
		loginbtn.click();
		return new DemoLoginPage(driver);
	}
}
