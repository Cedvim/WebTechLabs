package ex02D;

import org.apache.log4j.Logger;

import ex02B.DatabaseConnection;
import ex02B.DatabaseConnectionTest;
import ex02C.SQLExec;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DBMainTest extends TestCase {
		//Définition des logs
		protected static Logger log = Logger.getLogger(DatabaseConnection.class);
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
			String sqlInstruction = dbBase.toSQL();
			assertNotSame(sqlInstruction,"");
			
			//If here, DBMain works
			log.info("DBMAIN WORKS");
		}
}

