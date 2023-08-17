package Com.Sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Sms.GeneralUtility.WebDriverUtility;

public class SonexamhistoryPage extends WebDriverUtility {

	@FindBy(xpath="//span[normalize-space()='Exam']")
	private WebElement exam;
	
	@FindBy(xpath="//ul[@class='treeview-menu menu-open']")
	private WebElement openMenu;
	
	@FindBy(xpath="//a[@href='my_sons_exam_marks_history.php']")
	private WebElement SonHistory;
	
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement selectYear;
	
	
	@FindBy(xpath="//select[@id='exam']")
	private WebElement selectExam;
	
	
	@FindBy(id="btnSubmit")
	private WebElement submitbtn;
	
	@FindBy(xpath="//h2[normalize-space()='2017 - Term 1 Exam']")
	private WebElement examMarks;

	public WebElement getExam() {
		return exam;
	}

	public WebElement getOpenMenu() {
		return openMenu;
	}

	public WebElement getSonHistory() {
		return SonHistory;
	}

	public WebElement getSelectYear() {
		return selectYear;
	}

	public WebElement getSelectExam() {
		return selectExam;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public WebElement getExamMarks() {
		return examMarks;
	}
	
	//initialization
	
	public SonexamhistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void sonexamhistory(String selectyear, String Selectexam) {
		exam.click();
		String Menu=openMenu.getText();
		System.out.println(Menu);
		SonHistory.click();
		selectByvisible(selectYear, selectyear);
		selectByvisible(selectExam, Selectexam);
		submitbtn.click();
		String Exammarks=examMarks.getText();
if(Exammarks.equalsIgnoreCase("2017 - Term 1 Exam")) {
			
			System.out.println("2017 - Term 1 Exam result should be displyed");
			
		}
		else
		{
			
			System.out.println("2017 - Term 1 Exam result should not be displyed");
		}
		
		
		
	}
}
