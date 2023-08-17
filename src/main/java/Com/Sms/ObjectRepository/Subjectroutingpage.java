package Com.Sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Sms.GeneralUtility.WebDriverUtility;

public class Subjectroutingpage extends WebDriverUtility {
	@FindBy(xpath ="//span[text()='Subject Routing']")
	private WebElement subjectroutinglink;
	
	@FindBy(xpath="//a[text()='Add ']")
	private WebElement subjectrutingaddbttn;
	
	@FindBy(xpath="//select[@name='grade_id' and @id='grade']")
	private WebElement selectgradedropdown;
	
	@FindBy(xpath="//select[@name='subject_id' and @id='subject']")
	private WebElement selectsubjectdropdown;
	
	@FindBy(xpath="//select[@name='teacher_id' and @id='teacher']")
	private WebElement selectteacherdropdown;
	
	@FindBy(xpath="//input[@name='fee' and @id='fee']")
	private WebElement teacherfee;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitt;
	
	@FindBy(xpath="//span[text()='Ingenious Developer1']")
	private WebElement developerbttn;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement signoutbttn;
	//Initialization
	public Subjectroutingpage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
         
	//utilization
	public WebElement getSubjectroutinglink() {
		return subjectroutinglink;
	}
	public WebElement getSubjectrutingaddbttn() {
		return subjectrutingaddbttn;
	}

	public WebElement getSelectgradedropdown() {
		return selectgradedropdown;
	}

	public WebElement getSelectsubjectdropdown() {
		return selectsubjectdropdown;
	}

	public WebElement getSelectteacherdropdown() {
		return selectteacherdropdown;
	}

	public WebElement getTeacherfee() {
		return teacherfee;
	}

	public WebElement getSubmitt() {
		return submitt;
	}
	public WebElement getDeveloperbttn() {
		return developerbttn;
	}

	public WebElement getSignoutbttn() {
		return signoutbttn;
	}

	//business libraries
	public void createSubjectrouting(WebDriver driver,String dropDD,String drop1DD,String drop2DD,String T_fee)
	{
		subjectroutinglink.click();
		subjectrutingaddbttn.click();
		selectByvisible(selectgradedropdown,dropDD);
		selectByvisible(selectsubjectdropdown, drop1DD);
		selectByvisible(selectteacherdropdown, drop2DD);
		teacherfee.sendKeys(T_fee);
		submitt.click();
		 moveByOffSet(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	public void logout() {
		developerbttn.click();
		signoutbttn.click();
	}
	
}



