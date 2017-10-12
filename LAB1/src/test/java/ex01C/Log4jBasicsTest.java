package ex01C;
import org.apache.log4j.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** * Unit test for simple App. */
public class Log4jBasicsTest extends TestCase {
	
	//Définition des logs
	protected static Logger log = Logger.getLogger(Log4jBasicsTest.class);
	
	/** * Create the test case * * @param testName name of the test case */
	public Log4jBasicsTest(String testName) {
		super(testName);
	}

	/** * @return the suite of tests being tested */
	public static Test suite() {
		return new TestSuite(Log4jBasicsTest.class);
	}

	/** * Test de Log4jBasics */
	public void testApp() {
		System.out.println("main() returns (you should see DEBUG and INFO):"); 
		Log4jBasics.main(null);
	}
}