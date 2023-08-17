package Parents;

import static org.testng.Assert.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Com.Sms.GeneralUtility.BaseClass;
import Com.Sms.ObjectRepository.LoginPage;
import Com.Sms.ObjectRepository.MyPaymentAndInvoicePage;

public class MyPaymentAndInvoiceTest extends BaseClass {
	@Test
	public void myPaymentandinvoice() throws Throwable {
		String username=flib.readDataFromPropertyFile("Email2");
		String PASSWORD=flib.readDataFromPropertyFile("Password");	
		String URL=flib.readDataFromPropertyFile("url");
		driver.get(URL);
		wlib.waitForPageLoad(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginPage(username, PASSWORD);
		MyPaymentAndInvoicePage mypage=new MyPaymentAndInvoicePage(driver);
		String actualtext="My Son's Payments";
        mypage.paymentInvoice(actualtext);
		wlib.getScreenShot(driver, "path");
		String invce="INVOICE - #1";
		mypage.invoiceconfirmation(invce);
		String fee="Monthly Fee for November";
		mypage.viewfee(fee);
		Thread.sleep(3000);
		

	}
	}

//	public static void main(String[] args) throws Throwable {
//		WebDriverUtility wlib=new WebDriverUtility();
//		FileUtility flib=new FileUtility();
//		String Browser=flib.readDataFromPropertyFile("browser");
//		String URL=flib.readDataFromPropertyFile("url");
//		String username=flib.readDataFromPropertyFile("Email3");
//		String PASSWORD=flib.readDataFromPropertyFile("Password");	
//
//		WebDriver driver=null;
//		if(Browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}else {
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();}
//
//		wlib.maximize(driver);
//		wlib.waitForPageLoad(driver);
//
//		driver.get(URL);
//		LoginPage lp=new LoginPage(driver);
//		lp.loginPage(username, PASSWORD);
		
		






