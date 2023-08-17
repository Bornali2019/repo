package Practice_TestNG;

import org.testng.annotations.Test;

import Com.Sms.GeneralUtility.BaseClass;

public class ContactasCreate_TestNGTest extends BaseClass {
	@Test()
	public void create() {
		System.out.println("create contacts(1).....smoke nd reg");
	}
	@Test()
	public void modify() {
		System.out.println("modify contacts(3).......Regression");
	}
	@Test
	public void deleteContacts() {
		System.out.println("delete contacts(5)");
	}

	

}
//BatchExecution....select all scripts and then right click on selected script then go
//go to testNG then select *covert to TestNG* then select class and give Thread count 1