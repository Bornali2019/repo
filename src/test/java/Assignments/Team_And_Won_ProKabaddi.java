package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Team_And_Won_ProKabaddi {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> teams=driver.findElements(By.xpath("//div[@class='table-data team']"));
		List<WebElement> played=driver.findElements(By.xpath("//div[@class='table-data matches-play']"));
		List<WebElement> won=driver.findElements(By.xpath("//div[@class='table-data matches-won']"));
		for(int i=1; i<=teams.size()-1; i++)
		{
			System.out.println(teams.get(i).getText()+" "+played.get(i).getText()+" "+won.get(i).getText());
	}
}
}