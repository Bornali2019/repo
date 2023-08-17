package Parents;
import org.testng.annotations.Test;
import Com.Sms.GeneralUtility.BaseClass;
import Com.Sms.GeneralUtility.ExcelUtility;
import Com.Sms.ObjectRepository.LoginPage;
import Com.Sms.ObjectRepository.SonexamhistoryPage;
public class SonExamHistoryTest extends BaseClass {
	@Test
	public void sonExamhistory() throws Throwable {
		String URL=flib.readDataFromPropertyFile("url");
		String username=flib.readDataFromPropertyFile("Email2");
		String PASSWORD=flib.readDataFromPropertyFile("Password");
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginPage(username, PASSWORD);
		String ele = driver.getTitle();
		System.out.println(ele);
  		if(ele.equalsIgnoreCase("Student Management System")) {
 			System.out.println("login succesfully");
 			
 		}else {
 			System.out.println("email or password is incorrect");
 		}
  		SonexamhistoryPage page=new SonexamhistoryPage(driver);
  		ExcelUtility elib=new ExcelUtility();
  		String selectyear=elib.readDataFromExcel("parent", 0, 0);
  		String selectexam=elib.readDataFromExcel("parent", 1, 0);
  		page.sonexamhistory(selectyear, selectexam);
 		
		driver.close();
		
	
}}