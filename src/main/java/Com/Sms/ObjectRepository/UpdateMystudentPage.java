package Com.Sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Sms.GeneralUtility.WebDriverUtility;

public class UpdateMystudentPage extends WebDriverUtility{
	@FindBy(xpath="//span[text()='My Student']")
	private WebElement Mystdnt;
	
	@FindBy(xpath="//select[@id='grade']")
	private WebElement Grade;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement Submitbutton;
	
	@FindBy(linkText="Edit")
	private WebElement Edit;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement Enteremail;
	
	
	@FindBy(name="g_full_name")
	private WebElement ParentName;
	
	@FindBy(xpath="//button[@id='btnSubmit']")
	private WebElement Submitbtn;
	
	//initialization
	public UpdateMystudentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getMystdnt() {
		return Mystdnt;
	}

	public WebElement getGrade() {
		return Grade;
	}

	public WebElement getSubmitbutton() {
		return Submitbutton;
	}

	public WebElement getEdit() {
		return Edit;
	}

	public WebElement getEnteremail() {
		return Enteremail;
	}
	


	public WebElement getParentName() {
		return ParentName;
	}
	public WebElement getSubmitbtn() {
		return Submitbtn;
	}
	public void navigatetoMyStudent(String grade) {
		Mystdnt.click();
		selectByvisible(Grade, grade);
		Submitbutton.click();
	}
	public void UpdateMystudent(String grade, String student_mail, String Parent_name) throws Throwable {
		Mystdnt.click();
		selectByvisible(Grade, grade);
		Submitbutton.click();
		Edit.click();
		Enteremail.clear();
		Enteremail.sendKeys(student_mail);
		ParentName.clear();
		ParentName.sendKeys(Parent_name);
		Thread.sleep(3000);
		Submitbtn.click();
		
	}

}
	


