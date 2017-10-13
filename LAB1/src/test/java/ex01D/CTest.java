package ex01D;

import org.apache.log4j.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** * Unit test for simple App. */
public class CTest extends TestCase {
	
	//Définition des logs
	protected static Logger log = Logger.getLogger(C.class);
	
	/** * Create the test case * * @param testName name of the test case */
	public CTest(String testName) {
		super(testName);
	}

	/** * @return the suite of tests being tested */
	public static Test suite() {
		System.out.println("------C TEST------");
		return new TestSuite(CTest.class);
	}

	/** * Test de C */
	public void testApp() {
		
		//Initialisation des variables
		StringBuffer s = new StringBuffer("abc");
		int i=0;

		//Log des valeurs de i et s
		log.debug("i = " + i);
		log.debug("s = " + s);
		
		//Appel de method1() dans C
		C.method1(i, s); 
		log.info("method1(i,s) is called");
		
		//Vérification de (i = 0)
		log.debug("i = " + i);
		assertEquals(i, 0); //return false si i≠0, sinon continue
		log.debug("i has the right value");
		
		//Vérification de (s = "abcd")
		log.debug("s = " + s);
		assertEquals(s.toString(), "abcd");	//return false si s≠"abcd", sinon continue
		log.debug("s has the right value");
	}
}