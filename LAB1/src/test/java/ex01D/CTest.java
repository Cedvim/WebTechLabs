package ex01D;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** * Unit test for simple App. */
public class CTest extends TestCase {
	/** * Create the test case * * @param testName name of the test case */
	public CTest(String testName) {
		super(testName);
	}

	/** * @return the suite of tests being tested */
	public static Test suite() {
		System.out.println("Testing C");
		return new TestSuite(CTest.class);
	}

	/** * Rigourous Test :-) */
	public void testApp() {
		StringBuffer s = new StringBuffer("abc");
		int i=0;
		C.method1(i, s);
		assertEquals(i, 0);
		System.out.println(i + " = i right value");
		assertEquals(s.toString(), "abcd");	
	}
}