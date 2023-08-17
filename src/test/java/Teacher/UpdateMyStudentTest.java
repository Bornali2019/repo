package Teacher;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import Com.Sms.GeneralUtility.BaseClass;
import Com.Sms.ObjectRepository.LoginPage;
import Com.Sms.ObjectRepository.UpdateMystudentPage;
//@Listeners(Com.Sms.GeneralUtility.ListenerImpClass.class)//for ITestListener
public class UpdateMyStudentTest extends BaseClass {
	@Test
	public void updateStudentData() throws Throwable {
		String username=flib.readDataFromPropertyFile("Email");
		String PASSWORD=flib.readDataFromPropertyFile("Password");	
		String URL=flib.readDataFromPropertyFile("url");
		driver.get(URL);
		wlib.waitForPageLoad(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginPage(username, PASSWORD);
		String email_format = "@gmail.com";
		int random = jlib.getRandomNo();
		fail();
		UpdateMystudentPage my=new UpdateMystudentPage(driver);
		String grade=elib.readDataFromExcel("dropdown", 0, 0);

		String student_mail=elib.readDataFromExcel("entermail", 0, 0)+random+email_format;
		String Parent_name=elib.readDataFromExcel("entermail", 1, 0);
		my.UpdateMystudent(grade, student_mail, Parent_name);
		Thread.sleep(5000);

	}

}




