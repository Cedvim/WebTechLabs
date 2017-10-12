package ex01E;

import org.apache.log4j.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** * Unit test for simple App. */
public class ATest extends TestCase {
	/** * Create the test case * * @param testName name of the test case */
	public ATest(String testName) {
		super(testName);
	}

	/** * @return the suite of tests being tested */
	public static Test suite() {
		System.out.println("COUCOU");
		return new TestSuite(ATest.class);
	}

	/** * Rigourous Test :-) */
	public void testApp() {
		assertTrue(true);
	}
}