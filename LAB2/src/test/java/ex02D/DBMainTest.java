package ex02D;

import org.apache.log4j.Logger;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DBMainTest extends TestCase {
		//Définition des logs
		protected static Logger log = Logger.getLogger(DBMainTest.class);
	    private static DBBase dbBase;
		
		/** * Create the test case * * @param testName name of the test case */
		public DBMainTest(String testName) {
			super(testName);
		}

		/** * @return the suite of tests being tested */
		public static Test suite() {
			System.out.println("\n------DBMAIN TEST (2.4)------\n");
			return new TestSuite(DBMainTest.class);
		}

		/** * Test de App 
		 * @throws Exception */
		public void testApp() throws Exception {
			
			dbBase = DBBaseFactory.DBBaseFactory("sakila");
			log.info("DB SAKILA RECREATED IN OBJECTS");
			
			log.info("CONVERTING TO SQL");
			String sqlInstruction = dbBase.toSQL();
			assertNotSame(sqlInstruction,"");
			log.info("SQL INSTRUCTIONS HAVE BEEN GENERATED");
			
			//If here, DBMain works
			log.info("DBMAIN WORKS");
		}
}

