package Com.Sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Sms.GeneralUtility.WebDriverUtility;

public class Teacherpage extends WebDriverUtility{
	
		@FindBy(xpath = "//span[text()='Teacher']")
		private WebElement teacherlink;
		
		@FindBy(xpath="//a[text()=' Add Teacher']")
		private WebElement addteacherlink;
		
		@FindBy(xpath="//input[@name='index_number']")
		private WebElement teacherindexnumber;
		
		@FindBy(xpath="//input[@name='full_name']")
		private WebElement teacherfullname;
		
		@FindBy(xpath="//input[@name='i_name']")
		private WebElement teacherintial;
		
		@FindBy(xpath="//input[@name='address']")
	     private WebElement teacheraddress;
		
		@FindBy(xpath="//select[@name='gender']")
		private WebElement genderdropdown;
		
		@FindBy(xpath="//input[@name='phone']")
		private WebElement teacherphonenumber;
		
		@FindBy(xpath="//input[@name='email']")
		private WebElement teacheremail;
		
		@FindBy(xpath="//input[@name='fileToUpload']")
		private WebElement teacherphoto;
		
		@FindBy(xpath="//button[text()='Submit']")
		private WebElement submitt;
		
		//intialization
		public Teacherpage(WebDriver driver){
			PageFactory.initElements(driver,this);
		}
		//utilization
		
		public WebElement getTeacherlink() {
			return teacherlink;
		}

		public WebElement getAddteacherlink() {
			return addteacherlink;
		}
		public WebElement getTeacherindexnumber() {
			return teacherindexnumber;
		}

		public WebElement getTeacherfullname() {
			return teacherfullname;
		}

		public WebElement getTeacherintial() {
			return teacherintial;
		}

		public WebElement getTeacheraddress() {
			return teacheraddress;
		}

		public WebElement getGenderdropdown() {
			return genderdropdown;
		}

		public WebElement getTeacherphonenumber() {
			return teacherphonenumber;
		}

		public WebElement getTeacheremail() {
			return teacheremail;
		}

		public WebElement getTeacherphoto() {
			return teacherphoto;
		}

		public WebElement getSubmitt() {
			return submitt;
		}
		//business libraries
		
		public void createTeacher(WebDriver driver,String index,String full_name,String initial,String adress,String dropDD,String phone,String email,String photo)
		{
			teacherlink.click();
			addteacherlink.click();
			teacherindexnumber.sendKeys(index);
			teacherfullname.sendKeys(full_name);
			teacherintial.sendKeys(initial);
			teacheraddress.sendKeys(adress);
			selectByvisible(genderdropdown,dropDD);
			teacherphonenumber.sendKeys(phone);
			teacheremail.sendKeys(email);
			teacherphoto.sendKeys(photo);
			submitt.click();
			moveByOffSet(driver);
			
		}
	}


