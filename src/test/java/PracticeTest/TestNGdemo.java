package PracticeTest;

import org.testng.annotations.Test;

public class TestNGdemo {
@Test(priority=-1)
public void create() {
	System.out.println("created succesfully");
}

@Test(dependsOnMethods="create")
public void edit() {
	System.out.println("Edited data");
	}

@Test(priority=3)
public void delete() {
	System.out.println("data has been deleted");
}

}

