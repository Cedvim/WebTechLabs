package ex02D;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.lang.String.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RecreationDB {
 
	static Connection connection = null;
	
 
	public static void main(String[] argv) throws Exception {
		try {
			accessDB(); //Access to the Database
			System.out.println("Database connected \n");
			recreateTablesFromDB(); //Create a file to regenerate it    
			connection.close(); 
		} 
		catch (Exception e) {
 
			e.printStackTrace();
		}
	}
	
	public static void accessDB() {
	 
			try {
				Class.forName("com.mysql.jdbc.Driver"); //JDBC Driver Register
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/sakila", "root", "root");
					if (connection != null) {
					System.out.println("Connection Successful");
					} else {
						System.out.println("Failed to make connection!");
					}
			    } 
			    catch (SQLException e) {
			    		System.out.println("MySQL Connection Failed!");
					e.printStackTrace();
					return;
				}
			} 
			catch (ClassNotFoundException e) {
				System.out.println("No JDBC driver found, please add it to your pom.xml \n");
				e.printStackTrace();
				return;
			}
	 
		}
		
		
		public static void recreateTablesFromDB() {
			 
			try {
				
				//MetaData connection
				DatabaseMetaData databaseMetaData = connection.getMetaData();
				String   catalog = null;
				String   schemaPattern = null;
				String   tableNamePattern = null;
				String   schema = null;
				String columnNamePattern = null;
				String[] types = {"TABLE"};
				
				deleteFile(); //Deleting the old file to create a new one
				
				//Access to the tables
				ResultSet result = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);
				String tableName ="";
				
				//Extraction of the informations
				while(result.next()) {
						
					String sqlInstructions = "CREATE TABLE ";
					
					//CREATE TABLE "exemple" (
					tableName = result.getString(3);
					sqlInstructions += tableName + " ( \n";
					
					System.out.print("Generating " + tableName);
					
					
					//Access to the columns of a table
					ResultSet columns = databaseMetaData.getColumns(catalog, schemaPattern,  tableName, columnNamePattern);
					
					
					//Extracting columns data
					while(columns.next()){
						String columnName = columns.getString(4);
						String typeName = columns.getString("TYPE_NAME");
						
					    String columnSize = columns.getString("COLUMN_SIZE");
					    String typeNameNumbers = (columnSize != null)? "(" + columnSize + ")" : "";
					    
					    String isNullable = columns.getString("IS_NULLABLE");
					    String isNullableBool = (isNullable == "YES") ? "NULL" : "NOT NULL";
					    
					    String isAutoIncrment = columns.getString("IS_AUTOINCREMENT");
					    String isAutoIncrementBool = (isAutoIncrment == "YES")? " AUTO_INCREMENT": "";
						
						sqlInstructions += columnName + " " + typeName + typeNameNumbers + " " + isNullableBool + isAutoIncrementBool + ", \n";

						
					}
					
					//GET ALL KEYS
					ResultSet primaryKey = databaseMetaData.getPrimaryKeys(catalog, schema, tableName);
					ResultSet foreignKey = databaseMetaData.getImportedKeys(catalog, schema, tableName);
					ResultSet uniqueKey = databaseMetaData.getIndexInfo(catalog, schema, tableName, true, true);
					
					String primaryKeys = getPrimaryKeys(primaryKey); //Primary keys
					sqlInstructions += primaryKeys;
					
					String uniqueKeys = getUniqueKeys(uniqueKey); //Unique keys
					sqlInstructions += uniqueKeys;
					
					String foreignKeys = getForeignKeys(foreignKey); //Foreign keys
					sqlInstructions += foreignKeys;
					
					//Table fully generated in instructions
					System.out.print(" -> done \n");
					
					//Writing these instructions on a file
					writeFile(sqlInstructions);
					
					//UNCOMMENT HERE TO DISPLAY THE SQL INSTRUCTIONS
//					System.out.println(sqlInstructions);
				}
				System.out.println("\n--Database instructions generated--");
				System.out.println("You can find the sql file at the start of your project directory");
				
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
	 
		}
		
		public static String getPrimaryKeys(ResultSet primaryKey) throws SQLException {
			//PRIMARY KEYS
			int i = 0; //compteur pour virgules sur tout sauf la dernière entrée
			String sqlToAdd = "PRIMARY KEY (";
			while(primaryKey.next()){
				String primaryColumnName = primaryKey.getString(4);
				sqlToAdd += (i == 0)? primaryColumnName : ", " + primaryColumnName;
				i++;
			}	
			sqlToAdd += "), \n";
			return sqlToAdd;
		}
		
		public static String getUniqueKeys(ResultSet uniqueKeys) throws SQLException {
			//UNIQUE KEYS
			int j = 0; //compteur pour virgules sur tout sauf la dernière entrée
			String sqlToAdd = "UNIQUE (";
			
			while(uniqueKeys.next()){
				String uniqueColumnName = uniqueKeys.getString("COLUMN_NAME");
				sqlToAdd += (j == 0)? uniqueColumnName : ", " + uniqueColumnName;
				j++;
			}
			sqlToAdd += "), \n";
			return sqlToAdd;
		}
		
		public static String getForeignKeys(ResultSet foreignKeys) throws SQLException {
			//FOREIGN KEYS
			int k = 0; //compteur pour virgules sur tout sauf la dernière entrée
			String sqlToAdd ="";
			while(foreignKeys.next()){
				String foreignColumnName = "FOREIGN KEY ("+ foreignKeys.getString("FKCOLUMN_NAME") + ") REFERENCES " + foreignKeys.getString("PKTABLE_NAME") + "(" + foreignKeys.getString("PKCOLUMN_NAME") + ")";
				sqlToAdd += (k == 0)? foreignColumnName : ", \n" + foreignColumnName;
				k++;
			}
			sqlToAdd += "\n); \n";
			return sqlToAdd;
		}
		
		public static void writeFile(String sqlInstructions)
	    {
	        try
	        {
	        		System.out.print("Writing on the file ");
	            File file = new File("CreateDB.sql");
	            
	            //Selection/ Creation of a file
	            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
	            BufferedWriter bw = new BufferedWriter(fw);
	            
	            //Writing on it
	            bw.newLine();
	            bw.write(sqlInstructions);
	            System.out.print(" -> done \n");
	            bw.close();
	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
	    }
		public static void deleteFile()
	    {
			try {
	        File file = new File("CreateDB.sql");
			if (file.exists()) {
			    file.delete();
			    }
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	    }
		
	
	}