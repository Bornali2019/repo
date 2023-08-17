package Practice_TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftassertionTest {
@Test
public void softAssertTest() {
	System.out.println("a");
	System.out.println("b");
	SoftAssert sa=new SoftAssert();
	sa.assertEquals("A", "B");
	System.out.println("c");
	System.out.println("d");
	sa.assertAll();
}

@Test
public void sampleMethod() {
	System.out.println("E");
	SoftAssert sa=new SoftAssert();
	int a=20;
	sa.assertNull(a);
	System.out.println("F");
	sa.assertAll();
}

}
