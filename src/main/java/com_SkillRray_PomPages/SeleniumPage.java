package com_SkillRray_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPage {
	public WebDriver driver;
	public WebElement getCorejava() {
		return corejava;
	}

	@FindBy(xpath="//a[text()=' Core Java For Selenium Trainin']")
    private WebElement corejava;
	
	public SeleniumPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public TakethiscoursePage corejavaforselenium() {
		corejava.click();
		return new TakethiscoursePage(driver);
	}
	
	
}
