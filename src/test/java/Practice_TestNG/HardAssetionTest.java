package Practice_TestNG;

import static org.testng.Assert.*;
//import org.testng.Assert; //we use static and .* so we can call method directly
import org.testng.annotations.Test;

public class HardAssetionTest {
@Test
public void hardAssertTest() {
	System.out.println("name");
	System.out.println("DOB");
	assertEquals("A", "B");		//1
	System.out.println("Address");
	System.out.println("ID proof");
		
	}

@Test
public void sampleMethod() {
	System.out.println("E");
	int a=20;
	assertNull(a);		//2
	System.out.println("F");
	
}

}


