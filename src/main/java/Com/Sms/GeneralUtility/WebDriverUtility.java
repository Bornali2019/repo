package Com.Sms.GeneralUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void waitUntillElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void selectByIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void selectByvisible(  WebElement element, String Text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(Text);
	}


	public void mousehover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}


	public void dragAnddrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();;
	}


	public void doubleClickAction(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.doubleClick().perform();
	}


	public void rightClick(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.contextClick().perform();
	}  



	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}



	public void enterKeyPressAction(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
public void moveByOffSet(WebDriver driver) {
	 Actions act=new Actions(driver);
     act.moveByOffset(50, 50).click().perform();
}
public void enterKeyPress() throws AWTException {
	Robot rb= new Robot();
	rb.keyPress(KeyEvent.VK_ENTER);
}
	
	public void enterKeyRelease() throws Throwable
	{
		Robot rb= new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

public void pressTab() throws AWTException {
	Robot rb= new Robot();
	rb.keyPress(KeyEvent.VK_TAB);	
}

public void releaseTab() throws Throwable {
	Robot rb= new Robot();
	rb.keyRelease(KeyEvent.VK_TAB);
}
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}



	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}


	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}

	public void switchBackToFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}


	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}


	public void switchToWindow(WebDriver driver, String partialTitle)
	{	//step1: use getWindowHandes to capture all window id's
		Set<String> windows = driver.getWindowHandles();

		//step2: iterate through the windows
		Iterator<String> it = windows.iterator();

		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId = it.next();
			//step5: switch to current window and capture title 
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			//step6: check whether current window is expected
			if(currentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
	}



	public static  String getScreenShot(WebDriver driver, String screenshot) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenshot+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return path;

	}
	
	
	}
