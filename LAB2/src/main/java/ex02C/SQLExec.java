package ex02C;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.*;

import jdk.internal.jline.internal.Log;

public class SQLExec {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static String query;
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	
	public static void main(String[] args) {
		
		try {
			SQLExec x = new SQLExec(); //Access variables
			x.getArgs(args); //Get given arguments
			x.openConnection(url,user,password); //Connect to the DB
			x.printResults(); //Show the results
			x.closeConnection(); //Disconnect from the DB
		}   
		catch(Exception e) {
				e.printStackTrace();
		} 
	}
	
	public void getArgs(String[] args) {
		try {
			System.out.println("GIVEN ARGUMENTS :");
			url = args[0];
			driver = args[1];
			user = args[2];
			password = args[3];
			query = args[4];
			//Print given arguments
			System.out.println("URL: " + url + "\nDriver: " + driver + "\nUser: " + user + "\nPassword: " + password + "\nQuery: " + query); 
		}
		catch(Exception e){
			System.out.println("Merci d'entrer une ligne de commande sous la forme suivante :");
			System.out.println("mvn exec:java -Dexec.mainClass=\"ex02C.SQLExec\" -Dexec.args=\" 'jdbc:mysql://localhost:8889/sakila' 'com.mysql.jdbc.Driver' 'root' 'root' 'UPDATE actor SET first_name = \\\"WHY\\\" WHERE actor_id = 1;' \"");
			System.out.println("OU");
			System.out.println("mvn exec:java -Dexec.mainClass=\"ex02C.SQLExec\" -Dexec.args=\" 'jdbc:mysql://localhost:8889/sakila' 'com.mysql.jdbc.Driver' 'root' 'root' 'SELECT first_name FROM actor' \"");
		}
	}
	
	
	public void openConnection(String url, String user, String password) throws Exception {
		Class.forName(driver); //Driver registration
		connection = DriverManager.getConnection(url,user,password); //Connect to the DB
		System.out.println("Connection is now opened");
	}
	
	
	public void printResults() throws Exception {
		//CASE SELECT
		if(query.startsWith("SELECT")) {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(query);
				
				int rows = resultSet.getMetaData().getColumnCount();
				ResultSetMetaData data = resultSet.getMetaData();
				
				String header = "";
				for (int i=1; i <= rows; i++) {
					header = header + data.getColumnLabel(i);
				}
				
				//Print the header of the result table
				System.out.println("\nID \t " + header + "\n");
				
				//Print the lines of the result table
				int row = 0;
				while(resultSet.next()) {
					String field = "";
					field += row + " \t ";
					for (int i=1; i <= rows; i++) {
						field = field + resultSet.getString(i);
					}
					row++;
					
					System.out.println(field);
				}
				
				resultSet.close();
				statement.close();
			}
			else { //OTHER CASES
				prepStatement= connection.prepareStatement(query);
				int rows = prepStatement.executeUpdate();
				System.out.println("Number of rows impacted: " + rows);
				prepStatement.close();
			}
	}
	
	public void closeConnection() throws Exception {
		connection.close();
		System.out.println("Connection is now closed");
	}
}
