package ex02B;

import java.sql.*;
import org.apache.log4j.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/** * Unit test for simple App. */
public class DatabaseConnectionTest extends TestCase {
	
	//Définition des logs
	protected static Logger log = Logger.getLogger(DatabaseConnection.class);
	
	/** * Create the test case * * @param testName name of the test case */
	public DatabaseConnectionTest(String testName) {
		super(testName);
	}

	/** * @return the suite of tests being tested */
	public static Test suite() {
		System.out.println("\n------DATACONNECTION TEST (2.2)------\n");
		return new TestSuite(DatabaseConnectionTest.class);
	}

	/** * Test de App */
	public void testApp() throws Exception {
		DatabaseConnection dbConnect = new DatabaseConnection();
			//Test opening connection
			dbConnect.openConnection("jdbc:mysql://localhost:8889/sakila", "root", "root");
			log.info("OPENING CONNECTION WORKS");
			
			//Test query execution
			dbConnect.executeQuery();
			log.info("EXECUTING QUERY WORKS");
			
			//Test closing connection 
			dbConnect.closeConnection();
			log.info("CLOSING CONNECTION WORKS");
			
			//If here, everything worked
			log.info("DATABASECONNECTION WORKS");
	}
}
