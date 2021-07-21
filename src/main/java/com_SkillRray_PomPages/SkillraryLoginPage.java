package com_SkillRray_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryLoginPage {
	public WebDriver driver;
	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearsBtn;
	
	@FindBy(xpath="(//a[text()=' SkillRary Demo APP'])[2]")
	private WebElement skillraryDemoApp;
	
	public SkillraryLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public SkillraryDemoLoginPage skillrarydemoApplication() {
		gearsBtn.click();
		skillraryDemoApp.click();
		return new SkillraryDemoLoginPage(driver);
		
		
	}

	public WebElement getGearsBtn() {
		return gearsBtn;
	}

	public WebElement getSkillraryDemoApp() {
		return skillraryDemoApp;
	}
	
	

}
