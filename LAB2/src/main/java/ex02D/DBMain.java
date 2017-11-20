package ex02D;

import org.apache.log4j.Logger;

import ex02B.DatabaseConnection;

public class DBMain 
{
    private static DBBase dbBase;
    private static DBFile dbFile;
	protected static Logger log = Logger.getLogger(DatabaseConnection.class);//Logs definition
    
    public DBMain(){
    }
    
    public static void main(String[] args) {
        
    	try {
    			//Call to the DBBaseFactory constructor on "Sakila" database to modelise it in objects
            dbBase = DBBaseFactory.DBBaseFactory("sakila");
            log.info("DB Connected");
            
            //Conversion of the database object to sql instructions
            String sqlInstruction = dbBase.toSQL();
            
            log.info("SQL instructions created");
            
            //Print the instructions if necessary
            //System.out.println(sqlInstruction);
            
            //Write it in files
            dbFile = DBFileFactory.DBFileFactory(sqlInstruction);
            log.info("File created with SQL instructions");
           
        }
        catch(Exception e) {
        	
            e.printStackTrace();
        }  
    }
}
