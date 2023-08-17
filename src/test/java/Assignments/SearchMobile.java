package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchMobile {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		List<WebElement> element = driver.findElements(By.xpath("//span[text()='Apple iPhone 14 (128 GB) - Blue']/ancestor::h2/preceding-sibling::div/parent::div/following-sibling::div[@class='sg-row']/descendant::span[@class='a-price-whole']"));
		for(int i=0; i<element.size(); i++) {
		System.err.println(element.get(i).getText());
		
		
	}
	}
}
