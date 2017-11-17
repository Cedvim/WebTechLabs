package ex02D;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DBBase { 
    private List<DBTable> tables = new LinkedList();
    private ResultSet tableRS;
    private DatabaseMetaData data;
    private DBTable table;
    private String dbName;
    
    
    //Database creation
    protected DBBase(final String dbName, final ResultSet tableRS, DatabaseMetaData data) throws Exception {
        this.dbName = dbName;
        this.tableRS = tableRS;
        this.data = data;
        
        //Creation of the tables
        while(this.tableRS.next()) {
            table = DBTableFactory.DBTableFactory(this.tableRS, this.data);  
            tables.add(table); //add a DBTable Object to a list
        }
    }        
    
    //Conversion of the database to sql
    public String toSQL() throws Exception {
    	
    		System.out.println("\nGenerating database " + this.dbName + "...");
    		
        final StringBuffer sb = new StringBuffer();
        sb.append("\nCREATE DATABASE " + this.dbName + ";");

        //conversion of every table to sql
        for(int i=0; i<tables.size(); i++) {
            sb.append(tables.get(i).toSQL());
        }
        System.out.println("\n\n--Database instructions generated--");
		System.out.println("You can find the sql file \"SQLInstructions.sql\" at the start of your project directory");
        
        //return final result = database in sql instructions
        return sb.toString();
    }
    

    public List<DBTable> getTables() {
        return this.tables;
    }

    public String getDbName() {
        return this.dbName;
    }

    public ResultSet getTableRS() {
        return this.tableRS;
    }

    public DatabaseMetaData getData() {
        return this.data;
    }

    public DBTable getDbt() {
        return this.table;
    }
    
    
    
  
}
