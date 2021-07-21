package com_SkillRray_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	public WebDriver driver;
@FindBy(xpath="//img[@class='user-image']")
private WebElement userbtn;

@FindBy(xpath="//a[text()='Profile']")
private WebElement profilebtn;

@FindBy(xpath="//a[text()=' Edit']")
private WebElement editbtn;

public UserPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	this.driver=driver;
}

public UpdateDetailsPage editdata() {
	userbtn.click();
	profilebtn.click();
	editbtn.click();
return new UpdateDetailsPage(driver);
}
}
