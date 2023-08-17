package Com.Sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Sms.GeneralUtility.WebDriverUtility;

public class Gradepage extends WebDriverUtility {
	@FindBy(linkText = "Grade")
	private WebElement Gradelink;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement gradename;
	
	@FindBy(xpath="//input[@name='admission_fee' and @placeholder='Enter admission fee']")
	private WebElement admissionfee;
	
	@FindBy(xpath="//input[@name='hall_charge' and @id='hall_charge']")
	private WebElement hallcharge;
	
	@FindBy(xpath="//button[text()='Next']")
	private WebElement nextbttn;
	
	@FindBy(xpath="//input[@id='mark_range_text_1']")
	private WebElement addrange;
	
	@FindBy(xpath="//input[@id='mark_grade_text_1']")
	private WebElement addgrade;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitt;
	
	//initialization
	public Gradepage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getGradelink() {
		return Gradelink;
	}
	
	public WebElement getGradename() {
		return gradename;
	}
	
	public WebElement getAdmissionfee() {
		return admissionfee;
	}
	public WebElement getHallcharge() {
		return hallcharge;
	}
	public WebElement getNextbttn() {
		return nextbttn;
	}
	public WebElement getAddrange() {
		return addrange;
	}
	public WebElement getAddgrade() {
		return addgrade;
	}
	public WebElement getSubmitt() {
		return submitt;
	}
	//business libraries
	public void createGrade(String Grade,String Addmisson_fee,String hall_charge)
	{   
		Gradelink.click();
		gradename.sendKeys(Grade);
		admissionfee.sendKeys(Addmisson_fee);
		hallcharge.sendKeys(hall_charge);
		nextbttn.click();
	}
	public void addRange(WebDriver driver, String range,String Grade)
	{
		addrange.sendKeys(range);
		addgrade.sendKeys(Grade);
		submitt.click();
		moveByOffSet(driver);
	}
	
	

}



