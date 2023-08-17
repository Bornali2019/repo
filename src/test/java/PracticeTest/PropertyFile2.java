package PracticeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyFile2 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\propertyfile2.properties");
		Properties ppt=new Properties();
		ppt.load(fis);
		String URL=ppt.getProperty("url");
		String BROWSER=ppt.getProperty("browser");
		String EMAIL=ppt.getProperty("Email");
		String PASSWORD=ppt.getProperty("Password");
		WebDriver driver;
		//launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else {
			driver=new ChromeDriver();	
		}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys(EMAIL);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("btnSubmit")).click();
		
	}

}
