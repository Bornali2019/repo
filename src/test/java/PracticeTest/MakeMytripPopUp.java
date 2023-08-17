package PracticeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMytripPopUp {

	public static void main(String[] args) {
		String MonthAndYear="January 2024";
		int date=2;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		act.moveByOffset(40, 40).click().perform();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String actualDate="//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		String nextArrow="//span[@aria-label='Next Month']";
		for(; ;)
		
			try {
				driver.findElement(By.xpath(actualDate)).click();
				break;
			}
		
		catch(Exception e)
		{
			driver.findElement(By.xpath(nextArrow)).click();
		}
		
		
		}


	}


