package PracticeTest;

import org.testng.annotations.Test;

public class FetchDP {
	@Test(dataProviderClass=DataProviderTest.class, dataProvider="data")
	public void getdata(String src, String des) {
		System.out.println(src+des);
	}

}
