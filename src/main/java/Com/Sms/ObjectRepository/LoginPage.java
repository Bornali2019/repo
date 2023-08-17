package Com.Sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//declaration
	@FindBy(id="email")
	private WebElement Username;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(xpath="//button[@id='btnSubmit']")
	private WebElement submitbtn;
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getUsername() {
		return Username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	//business Libraries
	public void loginPage(String username, String PASSWORD) {
		Username.sendKeys(username);
		password.sendKeys(PASSWORD);
		submitbtn.click();
	}
	
}
