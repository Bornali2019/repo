package Com.Sms.GeneralUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		//Execution start from here
		String MethodName=result.getMethod().getMethodName();
		
		test=report.createTest(MethodName);
		Reporter.log(MethodName+".......>TestScript Execution Started");
	}
	

	@Override
	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-50");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Student_Management_system");
		
		 report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-url", "http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		report.setSystemInfo("reporter Name", "Bornali");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"....>Passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		//String MethodName=result.getMethod().getMethodName();
//		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
//		File src = edriver.getScreenshotAs(OutputType.FILE);
//		File dst = new File(".\\screenshot\\+FailedScript+.png");
		try {
		//FileUtils.copyFile(src, dst);
			String FailedScript=WebDriverUtility.getScreenShot(BaseClass.sdriver, result.getMethod().getMethodName());
			 test.addScreenCaptureFromPath(FailedScript);
	}
		catch(Throwable e){
			e.printStackTrace();
		}
		//test.log(Status.FAIL, MethodName+"....>Failed");
		test.log(Status.FAIL, result.getThrowable());
	//	Reporter.log(MethodName+"......>TestScript Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"....>Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"......>TestScript Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		//consolidate the report
		report.flush();
	}
}

	

	
	


