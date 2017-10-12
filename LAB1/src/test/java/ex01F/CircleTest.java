package ex01F;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** * Unit test for simple App. */
public class CircleTest extends TestCase {
	/** * Create the test case * * @param testName name of the test case */
	public CircleTest(String testName) {
		super(testName);
	}

	/** * @return the suite of tests being tested */
	public static Test suite() {
		System.out.println("COUCOU");
		return new TestSuite(CircleTest.class);
	}

	/** * Rigourous Test :-) */
	public void testApp() {
		assertTrue(true);
	}
}