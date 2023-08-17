package Com.Sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Com.Sms.GeneralUtility.WebDriverUtility;

public class MyPaymentAndInvoicePage extends WebDriverUtility {
	
	@FindBy(xpath="//a[@href='my_sons_payments.php']")
	private WebElement mypayment;
	
	@FindBy(xpath="//h3[normalize-space()='My Payment History']")
	private WebElement paymentHistory;
	
	@FindBy(xpath="//tr[@class='odd']//a[@class='btn btn-success btn-xs'][normalize-space()='View Invoice']")
	private WebElement viewinvoice;
	
	@FindBy(xpath="//h3[normalize-space()='INVOICE - #1']")
	private WebElement invoice;
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-remove']")
	private WebElement cancelbtnn;
	
	@FindBy(xpath="//tr[@class='odd']//a[@class='btn btn-info btn-xs'][normalize-space()='View Details']")
	private WebElement viewDetails;
	
	@FindBy(xpath="//h3[text()='Monthly Fee for November']")
	private WebElement monthlyFee;
	
	@FindBy(xpath="//div[@class='panel-heading bg-aqua-active']//span[@class='glyphicon glyphicon-remove']")
	private WebElement cancelbtn;

	public MyPaymentAndInvoicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getMypayment() {
		return mypayment;
	}

	public WebElement getPaymentHistory() {
		return paymentHistory;
	}

	public WebElement getViewinvoice() {
		return viewinvoice;
	}

	public WebElement getInvoice() {
		return invoice;
	}

	public WebElement getCancelbtnn() {
		return cancelbtnn;
	}

	public WebElement getViewDetails() {
		return viewDetails;
	}
	

	public WebElement getMonthlyFee() {
		return monthlyFee;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}

	
	
	public void paymentInvoice(String exp) {
		mypayment.click();
		System.out.println(paymentHistory.getText()); 
		String actualtext=mypayment.getText();
		Assert.assertEquals(actualtext, exp);
		System.out.println("my payment preview page should be displayed");
	}
		

		public void invoiceconfirmation(String invce) {
		
		viewinvoice.click();
		String invoiceno=invoice.getText();
		System.out.println(invoiceno);
		Assert.assertEquals(invoiceno, invce);
		System.out.println("invoice page should be displayed");
		cancelbtnn.click();
		}
		
		public void viewfee(String fee) throws Throwable {
		viewDetails.click();
		Thread.sleep(3000);
		String monthlyfees=monthlyFee.getText();
		System.out.println(monthlyfees);
		Assert.assertEquals(monthlyfees, fee);
		System.out.println("Monthly Fee for November page should be displayed");
		cancelbtn.click();
		}
	}
	

