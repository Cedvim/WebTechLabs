package ex02D;

public class DBMain 
{
    private static DBBase dbBase;
    private static DBFile dbFile;
    
    public DBMain(){
    }
    
    public static void main(String[] args) {
        
    	try {
    			//Call to the DBBaseFactory constructor on "Sakila" database to modelise it in objects
            dbBase = DBBaseFactory.DBBaseFactory("sakila");
            
            //Conversion of the database object to sql instructions
            String sqlInstruction = dbBase.toSQL();
            
            //Print the instructions if necessary
            //System.out.println(sqlInstruction);
            
            //Write it in files
            dbFile = DBFileFactory.DBFileFactory(sqlInstruction);
           
        }
        catch(Exception e) {
        	
            e.printStackTrace();
        }  
    }
}
