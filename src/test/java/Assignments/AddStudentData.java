package Assignments;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Sms.GeneralUtility.ExcelUtility;
import Com.Sms.GeneralUtility.FileUtility;
import Com.Sms.GeneralUtility.WebDriverUtility;
import Com.Sms.ObjectRepository.AddStudentdataPage;
import Com.Sms.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class AddStudentData {
	WebDriver driver;

	public void AddStudentData() throws Throwable { 



		WebDriverUtility wlib=new WebDriverUtility();
		FileUtility flib=new FileUtility();
		String BROWSER=flib.readDataFromPropertyFile("browser");
		String URL=flib.readDataFromPropertyFile("url");
		String username=flib.readDataFromPropertyFile("Email");
		String PASSWORD=flib.readDataFromPropertyFile("Password");

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			wlib.maximize(driver);
			wlib.waitForPageLoad(driver);
		}
		else
		{WebDriverManager.chromedriver().setup();
		driver=new EdgeDriver();
		}
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginPage(username, PASSWORD);	
	}


	@Test(dataProvider="getData_generic")
	public void getData(String day, String grade, String subject, String classroom, String startingTime, String EndingTime) {
		AddStudentdataPage timetable=new AddStudentdataPage(driver);
		timetable.addStudentData(day,grade, subject,classroom, startingTime, EndingTime);	
	}

	@DataProvider
	public Object[][] getData_generic() throws Throwable{
		ExcelUtility elib=new ExcelUtility();
		Object[][] value=elib.DPMultipleSetOfData("dropdown1");
		return value;
	}}



//	WebDriverUtility wlib=new WebDriverUtility();
//	FileUtility flib=new FileUtility();
//	ExcelUtility elib=new ExcelUtility();
//	String BROWSER=flib.readDataFromPropertyFile("browser");
//	String URL=flib.readDataFromPropertyFile("url");
//	String username=flib.readDataFromPropertyFile("Email");
//	String PASSWORD=flib.readDataFromPropertyFile("Password");		
//	WebDriver driver;
//	
//	if(BROWSER.equalsIgnoreCase("chrome"))
//	{
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		Thread.sleep(7000);
//		wlib.maximize(driver);
//		wlib.waitForPageLoad(driver);
//	}
//	else
//	{WebDriverManager.edgedriver().setup();
//	driver=new EdgeDriver();
//	}
//	Thread.sleep(7000);
//	driver.get(URL);
//	LoginPage lp=new LoginPage(driver);
//	lp.loginPage(username, PASSWORD);
//
//
//	AddStudentdataPage timetable=new AddStudentdataPage(driver);
//
//	String day=elib.readDataFromExcel("dropdown1",0,0);
//	String grade=elib.readDataFromExcel("dropdown1",1,0);
//	String subject=elib.readDataFromExcel("dropdown1",2,0);
//	String classroom=elib.readDataFromExcel("dropdown1",3,0);
//	String startingTime=elib.readDataFromExcel("dropdown1",4,0);
//	String EndingTime=elib.readDataFromExcel("dropdown1",5,0);
//	timetable.addStudentData(day, grade, subject, classroom, startingTime, EndingTime);	}
//
//
//
//
//}}
