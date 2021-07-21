package com_SkillRray_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage {
public WebDriver driver;
	@FindBy(id="add")
	private WebElement plusbtn;
	
	
	@FindBy(xpath="//button[text()=' Add to Cart']")
	private WebElement addtocartbtn;
	
	
	@FindBy(xpath="(//i[@class='fa fa-facebook'])[2]")
	private WebElement facebookicon;
	
	public AddtoCartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void addtocartBtn() {
		plusbtn.click();
		addtocartbtn.click();
	}
	public FacebookLikePage facebookiconbtn() {
		facebookicon.click();
		return new FacebookLikePage(driver);
	}

	public WebElement getPlusbtn() {
		return plusbtn;
	}

	public WebElement getAddtocartbtn() {
		return addtocartbtn;
	}

	public WebElement getFacebookicon() {
		return facebookicon;
	}
}
