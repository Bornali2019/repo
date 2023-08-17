package Admin;
import java.util.HashMap;
import org.testng.annotations.Test;

import Com.Sms.GeneralUtility.BaseClass;
import Com.Sms.ObjectRepository.Gradepage;
import Com.Sms.ObjectRepository.LoginPage;
import Com.Sms.ObjectRepository.Studentpreviewpage;
import Com.Sms.ObjectRepository.Subjectpage;
import Com.Sms.ObjectRepository.Subjectroutingpage;
public class CreateStudentDetailTest extends BaseClass {
	@Test
	public void createstudentdetail() throws Throwable {
		String Grade;
		String e_format = "@gmail.com";
		String username = flib.readDataFromPropertyFile("Email1");
		String PASSWORD = flib.readDataFromPropertyFile("Password");
		String URL=flib.readDataFromPropertyFile("url");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginPage(username, PASSWORD);
		int random = jlib.getRandomNo();
		//create Grade
		Grade =elib.readDataFromExcel("Grade",0,1)+random;
		String Addmisson_fee =elib.readDataFromExcel("Grade",1,1);
		String hall_charge=elib.readDataFromExcel("Grade",2,1);
		String range =elib.readDataFromExcel("Grade",3,1);
		Gradepage gr=new Gradepage(driver);
		gr.createGrade(Grade, Addmisson_fee, hall_charge);
		gr.addRange(driver,range, Grade);
		// create subject
		String subject =elib.readDataFromExcel("Subject",0,0)+random;

		Subjectpage sub=new Subjectpage(driver);

		sub.createSubject(driver,subject);

		// create subject routing

		String Teacher_fee =elib.readDataFromExcel("Teacher",8,0);
		String Teacher_name =elib.readDataFromExcel("Teacher",1,0);

		Subjectroutingpage sr=new Subjectroutingpage(driver);
		sr.createSubjectrouting(driver,Grade, subject, Teacher_name, Teacher_fee);

		//create student

		HashMap<String, String> value = elib.getMultipleDataFromExcel("Student2",0,1);

		String S_email =elib.readDataFromExcel("Student",0,1)+random+e_format;

		String G_email =elib.readDataFromExcel("Student",1,1)+random+e_format;
		String S_photo=elib.readDataFromExcel("Student",4,1);

		String genderDD=elib.readDataFromExcel("Student",3,1);

		Studentpreviewpage st=new Studentpreviewpage(driver);

		st.createStudent(driver,value, S_email, G_email,S_photo,genderDD,jlib);

		st.confirm(Grade);
		st.logout();
	}
}

