package com_EducationalDomain_SkillRray_Testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com_SkillRray_PomPages.AddtoCartPage;
import com_SkillRray_PomPages.FacebookLikePage;
import com_SkillRray_PomPages.SkillraryDemoLoginPage;
import com_SkillRray_PomPages.SkillraryLoginPage;
import com_SkillRray_genericLib.BaseClass;

public class FacebookLike extends BaseClass{
	
	@Test
	public void tc1() throws FileNotFoundException, IOException {
		test=reports.createTest("tc1");
		
		SkillraryLoginPage s=new SkillraryLoginPage(driver);
		SkillraryDemoLoginPage d = s.skillrarydemoApplication();
		
		driverUtilies.switchTabs(driver);
		driverUtilies.mouseHover(driver,d.getCoursebtn());
		AddtoCartPage a = d.seleniumtrainingbtn();
		driverUtilies.doubleClick(driver,a.getPlusbtn());
		a.addtocartBtn();
		driverUtilies.alertPopup(driver);
		 Point loc = a.getFacebookicon().getLocation();
		int x=loc.getX();
		int y=loc.getY();
		driverUtilies.scrollBar(driver, x, y);
		FacebookLikePage fb = a.facebookiconbtn();
		
		//driverUtilies.elementClick(driver,fb.getLoginbtn());
		driverUtilies.verify(driver.getTitle(),fileutilies.getpropertyData("facebooktitle"));
		
		
	}

}
