package ex02D;

import org.apache.log4j.Logger;

import ex02B.DatabaseConnection;
import ex02B.DatabaseConnectionTest;
import ex02C.SQLExec;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RecreationDBTest extends TestCase {
		//Définition des logs
		protected static Logger log = Logger.getLogger(DatabaseConnection.class);
		
		/** * Create the test case * * @param testName name of the test case */
		public RecreationDBTest(String testName) {
			super(testName);
		}

		/** * @return the suite of tests being tested */
		public static Test suite() {
			System.out.println("\n------RECREATIONDB TEST (2.4)------\n");
			return new TestSuite(RecreationDBTest.class);
		}

		/** * Test de App */
		public void testApp() {
			RecreationDB recreationDB = new RecreationDB();
			
			//Test opening connection
			recreationDB.accessDB();
			log.info("OPENING CONNECTION WORKS");
			
			//Test opening connection
			recreationDB.recreateTablesFromDB();  
			System.out.println("");
			
			//If here, everything worked
			log.info("CLOSING CONNECTION WORKS"); //called in the main
			log.info("RECREATIONDB WORKS");
		}
}

