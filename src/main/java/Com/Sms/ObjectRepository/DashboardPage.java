package Com.Sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	@FindBy(xpath="//span[text()='My Student']")
	private WebElement Mystudent;
	@FindBy(xpath="//span[text()='Timetable']")
	private WebElement Timetable;
	@FindBy(xpath="//span[text()='Teacherr 1fdsfhdfgdh']")
	private WebElement clickonTeacherr_1fdsfhdfgdh;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement signout;
	
	@FindBy(xpath="//span[.='Dad 1']")
	private WebElement clickon_Dad1;
	
	@FindBy(xpath="//span[.='k']")
	private WebElement clickon_k;
	
	//initialization
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getMystudent() {
		return Mystudent;
	}
	public WebElement getTimetable() {
		return Timetable;
	}
	public WebElement getClickonTeacherr_1fdsfhdfgdh() {
		return clickonTeacherr_1fdsfhdfgdh;
	}
	public WebElement getclickon_Dad1() {
		return clickon_Dad1;
	}
	
	
	public WebElement getClickon_k() {
		return clickon_k;
	}
	public WebElement getSignout() {
		return signout;
	}
	
	

public void teachersignOut() {
	clickonTeacherr_1fdsfhdfgdh.click();
	signout.click();
}
public void parentsignout() {
	clickon_Dad1.click();
	signout.click();
}
public void Studentsignout() {
	clickon_k.click();
	signout.click();
}
}

