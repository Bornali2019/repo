package Teacher;
import org.testng.annotations.Test;

import Com.Sms.GeneralUtility.BaseClass;

import Com.Sms.ObjectRepository.AddStudentdataPage;
import Com.Sms.ObjectRepository.LoginPage;

public class AddStudentDataTest  extends BaseClass  {
	//@Test(retryAnalyzer =Com.Sms.GeneralUtility.RetryImpClass.class)//RetryAnalyser
@Test(groups="smoke")
	public void addStudentdataTest() throws Throwable {
			String username=flib.readDataFromPropertyFile("Email");
			String PASSWORD=flib.readDataFromPropertyFile("Password");	
			String URL=flib.readDataFromPropertyFile("url");
			driver.get(URL);
			wlib.waitForPageLoad(driver);
			LoginPage lp=new LoginPage(driver);
			lp.loginPage(username, PASSWORD);
			//fail();
			AddStudentdataPage timetable=new AddStudentdataPage(driver);
			String day=elib.readDataFromExcel("dropdown1",0,0);
			String grade=elib.readDataFromExcel("dropdown1",1,0);
			String subject=elib.readDataFromExcel("dropdown1",2,0);
			String classroom=elib.readDataFromExcel("dropdown1",3,0);
			String startingTime=elib.readDataFromExcel("dropdown1",4,0);
			String EndingTime=elib.readDataFromExcel("dropdown1",5,0);
			timetable.addStudentData(day, grade, subject, classroom, startingTime, EndingTime);	
			
	}}	
		

//		WebDriver driver = null;
//		WebDriverUtility wlib=new WebDriverUtility();
//		FileUtility flib=new FileUtility();
//		ExcelUtility elib=new ExcelUtility();
//		String BROWSER=flib.readDataFromPropertyFile("browser");
//		String URL=flib.readDataFromPropertyFile("url");
//		String username=flib.readDataFromPropertyFile("Email");
//		String PASSWORD=flib.readDataFromPropertyFile("Password");		
//		
//		 
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//			Thread.sleep(7000);
//			wlib.maximize(driver);
//			wlib.waitForPageLoad(driver);
//		}
//		else
//		{WebDriverManager.edgedriver().setup();
//		driver=new EdgeDriver();
//		}
//		Thread.sleep(7000);
//		driver.get(URL);
//		LoginPage lp=new LoginPage(driver);
//		lp.loginPage(username, PASSWORD);
//         
		
	 
