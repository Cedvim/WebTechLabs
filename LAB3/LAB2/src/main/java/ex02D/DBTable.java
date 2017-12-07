package ex02D;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DBTable {
	
    private List<DBColumn> columns = new LinkedList<DBColumn>();
    private List<DBPrimary> primaryKeys = new LinkedList<DBPrimary>();
    private List<DBUnique> uniqueKeys = new LinkedList<DBUnique>();
    private List<DBForeign> foreignKeys = new LinkedList<DBForeign>();
    
    private String tableName;
    private ResultSet columnRS;
    private ResultSet primaryKeysRS;
    private ResultSet foreignKeysRS;
    private ResultSet uniqueKeysRS;
    private DBColumn column;
    private DBPrimary primaryKey;
    private DBUnique uniqueKey;
    private DBForeign foreignKey;
    
    
    //Creation of the columns with primary, foreign and unique keys
    protected DBTable(final String tableName, final ResultSet columnRS, final ResultSet primaryKeysRS, final ResultSet foreignKeysRS, final ResultSet uniqueKeysRS) throws Exception {
        this.tableName = tableName;
        this.columnRS = columnRS;
        this.foreignKeysRS = foreignKeysRS;
        this.uniqueKeysRS = uniqueKeysRS;
        this.primaryKeysRS = primaryKeysRS;
        

        //Construction of the columns with DBColumnFactory
        while(columnRS.next()) {
            column = DBColumnFactory.DBColumnFactory(columnRS);
            columns.add(column);
        }    
        
        
        //Construction of the primary keys with DBPrimaryFactory
        while(primaryKeysRS.next()) {
        		primaryKey = DBPrimaryFactory.DBPrimaryFactory(primaryKeysRS);
        		primaryKeys.add(primaryKey);
        }
        
        //Construction of the unique keys with DBUniqueFactory
        while(uniqueKeysRS.next()) {
            uniqueKey = DBUniqueFactory.DBUniqueFactory(uniqueKeysRS);
            uniqueKeys.add(uniqueKey);
        }
        
        
        //Construction of the foreign keys with DBForeignactory
        while(foreignKeysRS.next()) {
            foreignKey = DBForeignFactory.DBForeignFactory(foreignKeysRS);
            foreignKeys.add(foreignKey);
        }
    }
  
    //Conversion of the table to sql
    public String toSQL() throws Exception {
    	
        final StringBuffer sb = new StringBuffer();
        
        //"CREATE TABLE ("
        sb.append("\n\nCREATE TABLE " + this.tableName + "(");

        System.out.print("\nGenerating table " + this.tableName + " ---> ");

        //Columns SQL instructions
        for(int i=0; i<columns.size(); i++) { //Add a "," for all except the last one
            sb.append(columns.get(i).toSQL());
        }
        
        System.out.print("columns");
        
        
        //Primary keys SQL
        if (primaryKeys.size()>0) {
	        sb.append("\nPRIMARY KEY (");
	        
	        for(int j=0; j < primaryKeys.size(); j++)
	        {
	            sb.append(primaryKeys.get(j).toSQL());
	            
	            if(j != (primaryKeys.size() - 1 )) { //Add a "," for all except the last one
	            		sb.append(", ");
	            }
	        }
	        
	        sb.append(")");
	        
	        System.out.print("/primary");
        }
        
        
        //Unique keys SQL
        if (uniqueKeys.size()>0) {
	        sb.append(",\nUNIQUE (");
	        
	        for(int k=0; k < uniqueKeys.size(); k++)
	        {
	            sb.append(uniqueKeys.get(k).toSQL());
	            
	            if(k != (uniqueKeys.size() - 1 )) { //Add a "," for all except the last one
	            		sb.append(", ");
	            }
	        }
	        
	        sb.append(")");
	        
	        System.out.print("/unique");
        }
        
        //Foreign keys SQL
        if (foreignKeys.size()>0) {
	        sb.append(",");
	        
	        for(int k=0; k < foreignKeys.size(); k++)
	        {
	            sb.append(foreignKeys.get(k).toSQL());
	            
	            if(k != (foreignKeys.size() - 1 )) { //Add a "," for all except the last one
	            		sb.append(", ");
	            }
	        }
	        
	        System.out.print("/foreign");
	        
        }    
        
        sb.append("\n);");

        System.out.print("--> Done");
        
        return sb.toString();
        
    }

    
    public List<DBColumn> getColumns() {
        return columns;
    }

    public String getTableName() {
        return tableName;
    }

    public ResultSet getColumnRS() {
        return columnRS;
    }

    public ResultSet getPrimaryKeysRS() {
        return primaryKeysRS;
    }

    public ResultSet getForeignKeysRS() {
        return foreignKeysRS;
    }

    public ResultSet getUniqueKeysRS() {
        return uniqueKeysRS;
    }

    public DBColumn getColumn() {
        return column;
    }
    
    
}
