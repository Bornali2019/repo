package Practice_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertValidation {
@Test
public void facebook() {
String exp_result="Facebook – log in or sign up";
System.out.println("open facebook");
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.facebook.com/");
//String title=driver.getTitle();
//System.out.println(title);
String act_result=driver.getTitle();
Assert.assertEquals(act_result, exp_result);
System.out.println("Get the title");

}
}
