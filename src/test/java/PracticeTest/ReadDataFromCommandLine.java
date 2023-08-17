package PracticeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromCommandLine {
	@Test
	public void readDataFromcmdLine() throws InterruptedException {
		//https://demo.actitime.com/login.do//username=admin//password=manager
		//String Browser=System.getProperty("browser");
	  String URL=System.getProperty("url");
	  String UN=System.getProperty("Username");
	  String PW=System.getProperty("Password");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys(UN);
		Thread.sleep(2000);
		driver.findElement(By.name("pwd")).sendKeys(PW);
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click();
		driver.close();
		
	}

}
