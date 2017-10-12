package ex01C;
import org.apache.log4j.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** * Unit test for simple App. */
public class Log4jBasicsTest extends TestCase {
	/** * Create the test case * * @param testName name of the test case */
	public Log4jBasicsTest(String testName) {
		super(testName);
	}

	/** * @return the suite of tests being tested */
	public static Test suite() {
		System.out.println("COUCOU");
		return new TestSuite(Log4jBasicsTest.class);
	}

	/** * Rigourous Test :-) */
	public void testApp() {
		assertTrue(true);
	}
}