package Com.Sms.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Sms.GeneralUtility.JavaUtility;
import Com.Sms.GeneralUtility.WebDriverUtility;

public class Studentpreviewpage extends WebDriverUtility{
		
		@FindBy(xpath = "//a[@href='#']//span[text()='Student']")
		private WebElement studentlink;
		
		@FindBy(xpath="//a[text()=' Add Student']")
		private WebElement addstudentlink;
		
		@FindBy(name="index_number")
		private WebElement studentidexnumber;
		
		@FindBy(name="full_name")
		private WebElement studentfullname;

		@FindBy(name="i_name")
		private WebElement studentinital;
		
		@FindBy(name="email")
		private WebElement studentemail;
		
		@FindBy(name="address")
		private WebElement studentaddress;
		
		@FindBy(xpath="//select[@name='gender']")
		private WebElement studentgender;
		
		@FindBy(name="phone")
		private WebElement studentphoneno;
		
		@FindBy(name="b_date")
		private WebElement studentbdate;
		
		@FindBy(xpath="//input[@name='fileToUpload']")
		private WebElement studentphoto;
		
		@FindBy(name="g_full_name")
		private WebElement guardianname;
		
		@FindBy(name="g_i_name")
		private WebElement gurdaianintial;
		
		@FindBy(name="g_address")
		private WebElement guardainaddress;
		
		@FindBy(xpath="//select[@name='g_gender']")
		private WebElement guardiangender;
		
		@FindBy(name="g_email")
		private WebElement gurdianemail;
		 
		@FindBy(name="g_phone")
		 private WebElement gurdainphoneno;
		
		@FindBy(name="g_b_date")
		private WebElement gurdainbdate;
		
		@FindBy(xpath="//input[@name='g_fileToUpload']")
		private WebElement guardianphoto;
		
		@FindBy(xpath="//button[text()='Next']")
		private WebElement nextbttn;
		
		@FindBy(xpath="//select[@name='grade']")
		private WebElement studentgrade;
		
		@FindBy(id="checkbox")
		private WebElement subjectcheckbox;
		
		@FindBy(xpath="//button[text()='Submit']")
		private WebElement submitbttn;
		
		@FindBy(xpath="//button[@id='btnSubmit1' and @class='btn btn-primary btn-md']")
		private WebElement paidbttn;
		
		@FindBy(xpath="//span[text()='Ingenious Developer1']")
		private WebElement developerbttn;
		
		@FindBy(xpath="//a[text()='Sign out']")
		private WebElement signoutbttn;

		//intialize
		public Studentpreviewpage(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		public WebElement getStudentlink() {
			return studentlink;
		}

		public WebElement getAddstudentlink() {
			return addstudentlink;
		}

		public WebElement getStudentidexnumber() {
			return studentidexnumber;
		}

		public WebElement getStudentfullname() {
			return studentfullname;
		}

		public WebElement getStudentinital() {
			return studentinital;
		}

		public WebElement getStudentemail() {
			return studentemail;
		}

		public WebElement getStudentaddress() {
			return studentaddress;
		}

		public WebElement getStudentgender() {
			return studentgender;
		}

		public WebElement getStudentphoneno() {
			return studentphoneno;
		}

		public WebElement getStudentbdate() {
			return studentbdate;
		}

		public WebElement getStudentphoto() {
			return studentphoto;
		}

		public WebElement getGuardianname() {
			return guardianname;
		}

		public WebElement getGurdaianintial() {
			return gurdaianintial;
		}

		public WebElement getGuardainaddress() {
			return guardainaddress;
		}

		public WebElement getGuardiangender() {
			return guardiangender;
		}

		public WebElement getGurdianemail() {
			return gurdianemail;
		}

		public WebElement getGurdainphoneno() {
			return gurdainphoneno;
		}

		public WebElement getGurdainbdate() {
			return gurdainbdate;
		}

		public WebElement getGuardianphoto() {
			return guardianphoto;
		}

		public WebElement getNextbttn() {
			return nextbttn;
		}

		public WebElement getStudentgrade() {
			return studentgrade;
		}

		public WebElement getSubjectcheckbox() {
			return subjectcheckbox;
		}

		public WebElement getSubmitbttn() {
			return submitbttn;
		}

		public WebElement getPaidbttn() {
			return paidbttn;
		}
		
		
		public WebElement getDeveloperbttn() {
			return developerbttn;
		}

		public WebElement getSignoutbttn() {
			return signoutbttn;
		}

		public void createStudent(WebDriver driver,HashMap<String, String> value,String S_email,String G_email,String S_photo,String genderDD,JavaUtility jib)
		{  
			studentlink.click();
			addstudentlink.click();
			for(Entry<String, String> set:value.entrySet()) {
		      
				if(set.getKey().contains("index")) {
					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jib.getRandomNo());
				}else {
		     driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		        }
			}
			studentemail.sendKeys(S_email);
			gurdianemail.sendKeys(G_email);
			selectByvisible(studentgender,genderDD);
			studentphoto.sendKeys(S_photo);
			selectByvisible(guardiangender, genderDD);
			guardianphoto.sendKeys(S_photo);
			nextbttn.click();
			
		}
		public void confirm(String Grade)
		{   
			try {
			studentgrade.sendKeys(Grade);
			Thread.sleep(5000);
			subjectcheckbox.click();
			submitbttn.click();
			paidbttn.click();
			
				pressTab();
				releaseTab();
				enterKeyPress();
				enterKeyRelease();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		
		public void logout() {
			developerbttn.click();
			signoutbttn.click();
		}
		
		
	}

