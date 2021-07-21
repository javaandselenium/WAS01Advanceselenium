package com_EducationalDomain_SkillRray_Testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import com_SkillRray_PomPages.ContactusPage;
import com_SkillRray_PomPages.SeleniumPage;
import com_SkillRray_PomPages.SkillraryDemoLoginPage;
import com_SkillRray_PomPages.SkillraryLoginPage;
import com_SkillRray_PomPages.TakethiscoursePage;
import com_SkillRray_genericLib.BaseClass;

public class TakeThisCourse extends BaseClass{
	@Test
	public void tc2() throws FileNotFoundException, IOException, InterruptedException {
		test=reports.createTest("tc2");
		SkillraryLoginPage s=new SkillraryLoginPage(driver);
	SkillraryDemoLoginPage d = s.skillrarydemoApplication();
	driverUtilies.switchTabs(driver);
	Point loc = d.getContactus().getLocation();
	int x=loc.getX();
	int y=loc.getY();
	driverUtilies.scrollBar(driver, x, y);
	ContactusPage c = d.contactusbtn();
	c.contactinfo(fileutilies.getpropertyData("name"), fileutilies.getpropertyData("email"),fileutilies.getpropertyData("subject"),fileutilies.getpropertyData("message"));
	SeleniumPage sel = c.serachforcourse(fileutilies.getpropertyData("serach"));
	TakethiscoursePage cj = sel.corejavaforselenium();
	driverUtilies.switchFrame(driver);
	cj.playvideo();
	driverUtilies.switchBackfromBack(driver);
	driverUtilies.verify(driver.getCurrentUrl(),fileutilies.getpropertyData("takecourseurl"));
	}

}
