package Com.Sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Sms.GeneralUtility.WebDriverUtility;

public class Subjectpage extends WebDriverUtility {
		@FindBy(linkText = "Subject")
		private WebElement subjectlink;
		
		@FindBy(xpath="//input[@id='name']")
		private WebElement subjectname;
		
		@FindBy(xpath="//button[text()='Submit']")
		private WebElement submitt;
		
		//intialization
		public Subjectpage(WebDriver driver){
			PageFactory.initElements(driver, this);
			
		}
		//utilization
		
		public WebElement getSubjectlink() {
			return subjectlink;
		}
		
		public WebElement getSubjectname() {
			return subjectname;
		}

		public WebElement getSubmitt() {
			return submitt;
		}
		//business libraries
		public void createSubject(WebDriver driver,String subject)
		{
			subjectlink.click();
			subjectname.sendKeys(subject);
			submitt.click();
			moveByOffSet(driver);
		}}

	