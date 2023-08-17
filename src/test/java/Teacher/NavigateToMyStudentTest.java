package Teacher;

import java.io.IOException;
import org.testng.annotations.Test;

import Com.Sms.GeneralUtility.BaseClass;
import Com.Sms.ObjectRepository.LoginPage;
import Com.Sms.ObjectRepository.UpdateMystudentPage;
//@Listeners(Com.Sms.GeneralUtility.ListenerImpClass.class)
public class NavigateToMyStudentTest extends BaseClass {
	@Test(groups="smoke")
	public void navigatetostudent() throws Throwable, IOException {
		String username=flib.readDataFromPropertyFile("Email");
		String PASSWORD=flib.readDataFromPropertyFile("Password");	
		String URL=flib.readDataFromPropertyFile("url");
		driver.get(URL);
		wlib.waitForPageLoad(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginPage(username, PASSWORD);
		UpdateMystudentPage my=new UpdateMystudentPage(driver);
		String grade=elib.readDataFromExcel("dropdown", 0, 0);
		my.navigatetoMyStudent(grade);
		
	}}


	

//	public static void main(String[] args) throws Throwable {
//		WebDriverUtility wlib=new WebDriverUtility();
//		FileUtility flib=new FileUtility();
//		ExcelUtility elib=new ExcelUtility();
//		String BROWSER=flib.readDataFromPropertyFile("browser");
//		String URL=flib.readDataFromPropertyFile("url");
//		String username=flib.readDataFromPropertyFile("Email");
//		String PASSWORD=flib.readDataFromPropertyFile("Password");
//		WebDriver driver;
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//			wlib.maximize(driver);
//			wlib.waitForPageLoad(driver);
//		}
//		else
//		{WebDriverManager.chromedriver().setup();
//		driver=new EdgeDriver();
//		}
//		driver.get(URL);
//		LoginPage lp=new LoginPage(driver);
//		lp.loginPage(username, PASSWORD);
		
