package PracticeTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider="data")
	public void getdata(String src, String des) {
		System.out.println(src+des);
	}
	
	
	@DataProvider
	public Object[][] data()
	{
	 Object[][] obj=new Object[2][2];
	obj[0][0]="Bangalore";
	obj[0][1]="pune";
	
	
	obj[1][0]="delhi";
	obj[1][1]="mumbai";
	return obj;
}}
	
	



