package ex02B;

import java.sql.*;
import java.lang.*;

public class DatabaseConnection {
	 
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	//Constructor : connection variables
	public DatabaseConnection() {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:8889/sakila";
		user = "root";
		password = "root";
	}
	
	public static void main(String[] args) {
		try {
			DatabaseConnection x = new DatabaseConnection(); //Call to the constructor to access the connection variables
			x.openConnection(url,user,password); //Connection to DB
			x.executeQuery(); //Query execution
			x.printResult();	//show the result
			
			//Close everything
			x.closeResultSet();
			x.closeStatement();
			x.closeConnection();
		}
			
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
			
	//Database connection 
	public void openConnection(String url, String user, String password) throws Exception {
		Class.forName(driver);//Registration JDBC Driver
		connection = DriverManager.getConnection(url,user,password); //Connect to the database
		statement = connection.createStatement();
		System.out.println("Connection is now opened");
	}
	
	

	public void executeQuery() throws Exception {
		resultSet = statement.executeQuery("SELECT last_name FROM actor");
	}

	
	public void printResult() throws Exception {
		
		int i = 0;
		//Print the header of the result table
		System.out.println("ID \t LASTNAME");
		System.out.println("-- \t --------");
		
		//Print the the result lines with an incremented index
		while(resultSet.next()) {
			String lastName = resultSet.getString("last_name");
			System.out.println(i + " \t " + lastName);
			i++;
		}
	}
	
	public void closeConnection() throws Exception {
		connection.close();
		System.out.println("Connection is now closed");
	}
	
	public void closeStatement() throws Exception {
		statement.close();
	}
	
	public void closeResultSet() throws Exception {
		resultSet.close();
	}
	
	
	
}
