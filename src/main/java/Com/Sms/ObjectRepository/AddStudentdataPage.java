package Com.Sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Sms.GeneralUtility.WebDriverUtility;

public class AddStudentdataPage extends WebDriverUtility {
	@FindBy(xpath="//a[@href='#']//span[.='Timetable']")
	private WebElement Timetable;

	@FindBy(xpath="//a[text()=' My Timetable']")
	private WebElement Mytimetable;

	@FindBy(xpath="//a[.='Add '] ")
	private WebElement AddData;

	@FindBy(xpath="//select[@id='day']")
	private WebElement selectday;

	@FindBy(xpath="//select[@name='grade_id']")
	private WebElement selectGrade;

	@FindBy(xpath="//select[@id='subject']")
	private WebElement selectSubject;

	@FindBy(xpath="//select[@id='classroom']")
	private WebElement selectClass;

	@FindBy(name="start_time")
	private WebElement statingTime;

	@FindBy(name="end_time")
	private WebElement endingTime;

	@FindBy(xpath="//button[@id='btnSubmit']")
	private WebElement Submit;
	public AddStudentdataPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getTimetble() {
		return Timetable;
	}

	public WebElement getMytimetable() {
		return Mytimetable;
	}

	public WebElement getAddData() {
		return AddData;
	}

	public WebElement getSelectday() {
		return selectday;
	}

	public WebElement getSelectGrade() {
		return selectGrade;
	}

	public WebElement getSelectSubject() {
		return selectSubject;
	}

	public WebElement getSelectClass() {
		return selectClass;
	}

	public WebElement getStatingTime() {
		return statingTime;
	}

	public WebElement getEndingTime() {
		return endingTime;
	}

	public WebElement getSubmit() {
		return Submit;
	}

	public void addStudentData(String day, String grade, String subject, String classroom, String startingTime, String EndingTime) {
		Timetable.click();
		Mytimetable.click();
		AddData.click();
		selectByvisible( selectday, day);
		selectByvisible(selectGrade, grade);
		selectByvisible(selectSubject, subject);
		selectByvisible( selectClass, classroom);
		statingTime.sendKeys(startingTime);
		endingTime.sendKeys(EndingTime);
		Submit.click();


	}


}
