package com_SkillRray_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateDetailsPage {
	@FindBy(id="firstname")
	private WebElement firstnametb;
	
	@FindBy(id="lastname")
	private WebElement lastnametb;
	
	public WebElement getFirstnametb() {
		return firstnametb;
	}

	public WebElement getLastnametb() {
		return lastnametb;
	}

	public WebElement getEmailtb() {
		return emailtb;
	}

	public WebElement getPasswordtb() {
		return passwordtb;
	}

	public WebElement getContact() {
		return contact;
	}

	public WebElement getPhotodd() {
		return photodd;
	}

	public WebElement getUpdatebtn() {
		return updatebtn;
	}

	@FindBy(id="email")
	private WebElement emailtb;
	
	@FindBy(id="password")
	private WebElement passwordtb;
	
	@FindBy(id="contact")
	private WebElement contact;
	
	@FindBy(xpath="//input[@id='photo']")
	private WebElement photodd;
	
	@FindBy(name="edit")
	private WebElement updatebtn;
	
	public UpdateDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	public void updateDetails(String fn,String ln,String email,String  pwd,String contacttb) {
		firstnametb.sendKeys(fn);
		lastnametb.sendKeys(ln);
		emailtb.sendKeys(email);
		passwordtb.sendKeys(pwd);
		contact.sendKeys(contacttb);
		photodd.click();
	}
	
	public void updatebutton() {
		updatebtn.click();
	}

}
