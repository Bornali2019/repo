package PracticeTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Sms.GeneralUtility.ExcelUtility;

public class DP_GenericTest {
	@Test(dataProvider="getData_generic")
	public void getData(String clients, String location) {
		System.out.println(clients+"......"+location);
	}
	
	@DataProvider
	public Object[][] getData_generic() throws Throwable{
		ExcelUtility elib=new ExcelUtility();
		Object[][] value=elib.DPMultipleSetOfData("dropdown1");
		return value;
	}
}
