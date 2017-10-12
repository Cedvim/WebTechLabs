package ex01F;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** * Unit test for simple App. */
public class ToStringOverloadingTest extends TestCase {
	/** * Create the test case * * @param testName name of the test case */
	public ToStringOverloadingTest(String testName) {
		super(testName);
	}

	/** * @return the suite of tests being tested */
	public static Test suite() {
		System.out.println("COUCOU");
		return new TestSuite(ToStringOverloadingTest.class);
	}

	/** * Rigourous Test :-) */
	public void testApp() {
		assertTrue(true);
	}
}