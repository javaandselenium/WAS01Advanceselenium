package com_SkillRray_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactusPage {
	public WebDriver driver;
	@FindBy(name="name")
	private WebElement nametb;
	
	@FindBy(name="sender")
	private WebElement emailtb;
	
	@FindBy(name="subject")
	private WebElement subjecttb;
	
	@FindBy(name="q")
	private WebElement serachtb;
	
	@FindBy(xpath="//input[@value='go']")
	private WebElement sumbitbtn;
	
	@FindBy(name="message")
	private WebElement messagetb;
	
	public WebElement getNametb() {
		return nametb;
	}

	public WebElement getEmailtb() {
		return emailtb;
	}

	public WebElement getSubjecttb() {
		return subjecttb;
	}

	public WebElement getMessagetb() {
		return messagetb;
	}

	public WebElement getSendusemail() {
		return sendusemail;
	}

	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendusemail;
	
	public  ContactusPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void contactinfo(String name,String email,String sub,String msg) {
		nametb.sendKeys(name);
		emailtb.sendKeys(email);
		subjecttb.sendKeys(sub);
		messagetb.sendKeys(msg);
		sendusemail.click();
	}
	
	public SeleniumPage serachforcourse(String name) {
		serachtb.sendKeys(name);
		sumbitbtn.click();
		
		return new SeleniumPage(driver);
	}

}
