package PracticeTest;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rmg_ventre {

	public static void main(String[] args) throws SQLException    {
		Connection con=null;
		ResultSet result=null;
		String expdata="STUDENT MANAGEMENT SYSTEM_2";
		try {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("STUDENT MANAGEMENT SYSTEM_2");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Vijayalaxmi");
		WebElement element=	driver.findElement(By.xpath("//select[@name='status']"));
		Select sel=new Select(element);
		sel.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		con= DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333//projects", "root@%", "root");
		Statement state=con.createStatement();
		String query="select project_name from project;";
		result=state.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String actual=result.getString(1);
			if(actual.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("project created succesfully");
		}
		else
		{
			System.out.println("project not created");
		}}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
		}

	
	

}
}


