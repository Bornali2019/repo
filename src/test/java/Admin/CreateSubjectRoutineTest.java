package Admin;
import org.testng.annotations.Test;
import Com.Sms.GeneralUtility.BaseClass;
import Com.Sms.ObjectRepository.Classpage;
import Com.Sms.ObjectRepository.Gradepage;
import Com.Sms.ObjectRepository.LoginPage;
import Com.Sms.ObjectRepository.Subjectpage;
import Com.Sms.ObjectRepository.Subjectroutingpage;
import Com.Sms.ObjectRepository.Teacherpage;
public class CreateSubjectRoutineTest extends BaseClass{
	@Test
	public void createsubjectroutineTest() throws Throwable {
	
		String URL = flib.readDataFromPropertyFile("url");
		String username = flib.readDataFromPropertyFile("Email1");
		String PASSWORD = flib.readDataFromPropertyFile("Password");
		wlib.waitForPageLoad(driver);
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginPage(username, PASSWORD);
		int random = jlib.getRandomNo();
		String format="@gmail.com";


		wlib.waitForPageLoad(driver);
		//create class
		String class_name = elib.readDataFromExcel("Sheet1",0,0)+random;

		String class_no = elib.readDataFromExcel("Sheet1",0,1);

		Classpage clss=new Classpage(driver);

		clss.classroomdetalis(driver,class_name, class_no);


		//create grade
		String Grade=elib.readDataFromExcel("gdata",0,0)+random;

		String Addmisson_fee=elib.readDataFromExcel("gdata",0,1);

		String hall_charge =elib.readDataFromExcel("gdata",0,2); 

		String range =elib.readDataFromExcel("gdata",0,3);

		Gradepage grade=new Gradepage(driver);

		grade.createGrade(Grade,Addmisson_fee,hall_charge);

		grade.addRange(driver,range, Grade);



		//create subject
		String subject =elib.readDataFromExcel("Subject",0,0)+random;

		Subjectpage sub=new Subjectpage(driver);

		sub.createSubject(driver,subject);


		//create teacher
		String index =elib.readDataFromExcel("Teacher",0,0)+random;

		String full_name =elib.readDataFromExcel("Teacher",1,0)+random;

		String intials =elib.readDataFromExcel("Teacher",2,0)+random;

		String address =elib.readDataFromExcel("Teacher",3,0);

		String phone = elib.readDataFromExcel("Teacher",4,0);

		String email =elib.readDataFromExcel("Teacher",5,0)+random+format;

		String genderDD = elib.readDataFromExcel("Teacher",6,0);

		String photo= elib.readDataFromExcel("Teacher",7,0);

		Teacherpage te=new Teacherpage(driver);

		te.createTeacher(driver,index,full_name,intials,address,genderDD,phone,email,photo);    



		//create subject routing
		String Teacher_fee =elib.readDataFromExcel("Teacher",8,0);

		Subjectroutingpage subr=new Subjectroutingpage(driver);

		subr.createSubjectrouting(driver,Grade,subject,full_name,Teacher_fee);
	}

}






