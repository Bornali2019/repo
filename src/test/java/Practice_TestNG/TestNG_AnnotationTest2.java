package Practice_TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_AnnotationTest2 {
	@BeforeSuite
	public void config_BS() {
		System.out.println("connect to database");
	}
	@BeforeClass
	public void config_BC()
	{
		System.out.println("Launch the browser");
	}
	@BeforeMethod
	public void config_BM() {
		System.out.println("Login to application");
	}
	@Test
	public void create_org() {
		System.out.println("create organization");
	}
	@AfterMethod
	public void config_AM() {
		System.out.println("logout from appli");
	}
	
	@AfterClass
	public void config_AC() {
		System.out.println("close the browser");
	}
	@AfterSuite
	public void config_AS() {
		System.out.println("close the database");
	}

}
