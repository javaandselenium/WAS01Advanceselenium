package com_SkillRray_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoLoginPage {
	public WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogintn() {
		return logintn;
	}

	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="last")
	private WebElement logintn;
	
	public DemoLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public UserPage logindetails(String emailaddress,String pwd) {
		email.sendKeys(emailaddress);
		password.sendKeys(pwd);
		logintn.click();
		return new UserPage(driver);
	}
	
	
	

}
