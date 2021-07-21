package com_EducationalDomain_SkillRray_Testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com_SkillRray_PomPages.DemoLoginPage;
import com_SkillRray_PomPages.SkillraryDemoLoginPage;
import com_SkillRray_PomPages.SkillraryLoginPage;
import com_SkillRray_PomPages.UpdateDetailsPage;
import com_SkillRray_PomPages.UserPage;
import com_SkillRray_genericLib.BaseClass;
import com_SkillRray_genericLib.Demo;
import com_SkillRray_genericLib.WebDriverUtilies;

public class UpdateProfiledetails extends Demo{
	
	
	@Test(dataProvider = "readExcelData")
	public void tc3(String fn,String ln,String email,String pwd,String contacttb) throws FileNotFoundException, SQLException, IOException, InterruptedException {
		test=reports.createTest("tc3");
		SkillraryLoginPage s=new SkillraryLoginPage(driver);
	SkillraryDemoLoginPage d = s.skillrarydemoApplication();
	driverUtilies.switchTabs(driver);
	DemoLoginPage l = d.loginButton();
	UserPage sd = l.logindetails(fileutilies.queryExecution("select * from logindetails",1,fileutilies.getpropertyData("username")),fileutilies.queryExecution("select * from logindetails",2,fileutilies.getpropertyData("password")));
	UpdateDetailsPage ed = sd.editdata();
	ed.updateDetails(fn, ln, email, pwd, contacttb);
	 Runtime.getRuntime().exec("C:\\Users\\QSP\\Desktop\\Autoit\\SRupload.exe");

	ed.updatebutton();
	
	
	}

}
