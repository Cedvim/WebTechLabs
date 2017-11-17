package ex02D;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBBaseFactory{
    private static ResultSet tableRS;
    private static DatabaseMetaData data;
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static Connection connection;
    private static String catalog;//DB name
    private static String schema;//schema of the table
    private static String table;// tables name
    private static String column;//columns name
    private static String[] type;//table or view
    
    private DBBaseFactory() {        
    }
    
    //Creation of the database : call DBBase constructor to do so
    public static DBBase DBBaseFactory(final String dbName) throws Exception {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:8889/sakila";
		user = "root";
		password = "root"; 
		String[] type = {"TABLE"}; //Selection of all the tables in the database
        
        Class.forName(driver); // Driver registration
		connection = DriverManager.getConnection(url,user,password);
		System.out.println("\nConnection is set");
        
        
    		data = connection.getMetaData();//We get DB data
    		tableRS = data.getTables(catalog, schema, table, type);//We get every table/view from out DB
 
        
        return new DBBase(dbName, tableRS, data);
    }

    public static ResultSet getTableRS() {
        return tableRS;
    }

    public static DatabaseMetaData getData() {
        return data;
    }

    public static String getDriver() {
        return driver;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static Connection getCon() {
        return connection;
    }

    public static String getCatalog() {
        return catalog;
    }

    public static String getSchema() {
        return schema;
    }

    public static String getTable() {
        return table;
    }

    public static String getColumn() {
        return column;
    }

    public static String[] getType() {
        return type;
    }
    
    
}
