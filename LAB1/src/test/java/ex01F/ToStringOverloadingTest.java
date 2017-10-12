package ex01F;

import org.apache.log4j.Logger;

import ex01D.C;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** * Unit test for simple App. */
public class ToStringOverloadingTest extends TestCase {
	
	//Définition des logs
	protected static Logger log = Logger.getLogger(C.class);
	
	/** * Create the test case * * @param testName name of the test case */
	public ToStringOverloadingTest(String testName) {
		super(testName);
	}

	/** * @return the suite of tests being tested */
	public static Test suite() {
		return new TestSuite(ToStringOverloadingTest.class);
	}

	/** * Test de ToStringOverloading */
	public void testApp() {
		//Coordonnées du premier cercle
		int x1 = 0;
		int y1 = 0;
		int radius1 = 5;
		
		//Création du premier cercle
		Circle c1 = new Circle(x1,y1,radius1);
		log.debug("Circle c1 is created");
		System.out.println(c1);
		
		//Vérification de la valeur du premier cercle
		assertEquals(c1.toString(),"Circle with center (0,0) and radius 5 (Perimter is 31,42)");
		log.debug("c1 is right");
		System.out.println("");
		
		//Coordonnées du premier cercle
		int x2 = 0;
		int y2 = 0;
		int radius2 = 3;
		
		//Création du second cercle
		Circle c2 = new Circle(x2,y2,radius2);
		log.debug("Circle c2 is created");
		System.out.println(c2);
		
		//Vérification de la valeur du second cercle
		assertEquals(c2.toString(),"Circle with center (0,0) and radius 3 (Perimter is 18,85)");
		log.debug("c2 is right");
	}
}