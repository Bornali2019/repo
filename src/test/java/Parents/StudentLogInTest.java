package Parents;
import org.testng.annotations.Test;

import Com.Sms.GeneralUtility.BaseClass;
import Com.Sms.ObjectRepository.LoginPage;

public class StudentLogInTest extends BaseClass{
	@Test
	public void studentlogin() throws Throwable {
		String URL=flib.readDataFromPropertyFile("url");
		String username=flib.readDataFromPropertyFile("Email2");
		String PASSWORD=flib.readDataFromPropertyFile("Password");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginPage(username, PASSWORD);
		Thread.sleep(2000);

 		String ele = driver.getTitle();
  		if(ele.equalsIgnoreCase("Student Management System")) {
 			System.out.println("login succesfully");
 			
 		}else {
 			System.out.println("email or password is incorrect");
 		}
		
	}


	}



//	public static void main(String[] args) throws Throwable {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver= new ChromeDriver();
//		WebDriverUtility wlib=new WebDriverUtility();
//		FileUtility flib=new FileUtility();
		

//		if(Browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//
//		}else {
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//			
//		}
//		wlib.maximize(driver);
//		wlib.waitForPageLoad(driver);
//		
