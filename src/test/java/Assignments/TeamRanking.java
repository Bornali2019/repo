package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TeamRanking {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> link1 = driver.findElements(By.xpath("//span[.='Matches']/ancestor::table//tbody/tr/td[1]"));
		List<WebElement> link2 = driver.findElements(By.xpath("//span[.='Matches']/ancestor::table//tbody/tr/td[2]"));
		List<WebElement> link3 = driver.findElements(By.xpath("//span[.='Matches']/ancestor::table//tbody/tr/td[3]"));
		List<WebElement> link4 = driver.findElements(By.xpath("//span[.='Matches']/ancestor::table//tbody/tr/td[4]"));
		List<WebElement> link5 = driver.findElements(By.xpath("//span[.='Matches']/ancestor::table//tbody/tr/td[5]"));
		System.out.println("pos           Team          Matches          Points            Ratings");
		int count=link1.size();
		for(int i=0; i<count; i++) {
			String name=link1.get(i).getText();
			String num=link2.get(i).getText();
			String match=link3.get(i).getText();
			String point=link4.get(i).getText();
			String rating=link5.get(i).getText();
			
			System.out.println(name+"....."+num+"....."+match+"...."+"match"+"..."+point+"..."+rating);
		
	}
	}
}
