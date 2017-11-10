package ex02C;

import org.apache.log4j.Logger;

import ex02B.DatabaseConnection;
import ex02B.DatabaseConnectionTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SQLExecTest extends TestCase {
		//Définition des logs
		protected static Logger log = Logger.getLogger(DatabaseConnection.class);
		
		/** * Create the test case * * @param testName name of the test case */
		public SQLExecTest(String testName) {
			super(testName);
		}

		/** * @return the suite of tests being tested */
		public static Test suite() {
			System.out.println("\n------SQLEXEC TEST (2.3)------\n");
			return new TestSuite(SQLExecTest.class);
		}

		/** * Test de App 
		 * @throws Exception */
		public void testApp() throws Exception {
			SQLExec sqlExec = new SQLExec();
			String[] args = new String [5];
			args[0] = "jdbc:mysql://localhost:8889/sakila";
			args[1] = "com.mysql.jdbc.Driver";
			args[2] = "root";
			args[3] = "root";
			args[4] = "SELECT last_name FROM actor";
			
			//Test getting given arguments
			sqlExec.getArgs(args);
			log.info("ARGS WELL RETURNED");
			
			//Test opening connection
			sqlExec.openConnection(args[0], args[2], args[3]);
			log.info("OPENING CONNECTION WORKS");
			
			//Test closing connection
			sqlExec.closeConnection();
			log.info("CLOSING CONNECTION WORKS");
			
			//If here, everything worked
			log.info("SQLEXEC WORKS");
		}
}
