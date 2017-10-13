package ex01E;

import org.apache.log4j.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** * Unit test for simple App. */
public class ATest extends TestCase {
	
	//Définition des logs
	protected static Logger log = Logger.getLogger(C.class);
	
	/** * Create the test case * * @param testName name of the test case */
	public ATest(String testName) {
		super(testName);
	}

	/** * @return the suite of tests being tested */
	public static Test suite() {
		System.out.println("------A TEST------");
		return new TestSuite(ATest.class);
	}

	/** * Test de A */
	public void testApp() {
		//m() ne peut pas être appelée en dehors de C, on teste donc la méthode main()
		C.main(null);
	}
}