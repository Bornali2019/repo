package Com.Sms.GeneralUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public DatabaseUtility dlib=new DatabaseUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun=true)
	public void config_BS() throws Throwable  {
		dlib.connectToDB();
		System.out.println("connect to DataBase");
	}
	
	@BeforeClass(alwaysRun=true)
	public void config_BC() throws Throwable {
		String BROWSER=flib.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Thread.sleep(7000);
			wlib.maximize(driver);
			wlib.waitForPageLoad(driver);
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		}
		sdriver=driver;
		System.out.println("Launch the browser");
		wlib.maximize(driver);
	}
	@BeforeMethod(alwaysRun=true)
	public void config_BM() throws Throwable {
	
		System.out.println("Login to Application");
	
	}
	@AfterMethod(alwaysRun=true)
	public void config_AM() {		
		System.out.println("Logout from Appl");
	}

	@AfterClass(alwaysRun=true)
	public void config_AC() {
		driver.quit();
		System.out.println("close the browser");
	}
	@AfterSuite(alwaysRun=true)
	public void config_AS() throws Throwable {
		dlib.closeDB();
		System.out.println("close DataBase");
	}
}
