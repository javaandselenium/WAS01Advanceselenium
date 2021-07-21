package com_SkillRray_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLikePage {
	@FindBy(xpath="//button[@class='likeButton _4jy0 _4jy4 _517h _51sy _42ft']")
	private WebElement like;
	
	@FindBy(xpath="(//button[@id='loginbutton'])[2]")
	private WebElement loginbtn;
	
	
	public FacebookLikePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void likeBtn() {
		like.click();
		
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getLike() {
		return like;
	}
	

}
