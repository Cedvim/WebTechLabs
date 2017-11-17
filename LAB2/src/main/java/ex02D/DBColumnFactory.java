package ex02D;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBColumnFactory 
{
    private DBColumnFactory() 
    {
    }

    //General constructor of columns : extract the important informations on a column and call a second constructor to build it
    public static DBColumn DBColumnFactory(ResultSet columnRS) throws SQLException 
    {
    		//Name, type, size and scale
        String colName = columnRS.getString(4);
        String colType = columnRS.getString("TYPE_NAME");
        int colSize = columnRS.getInt("COLUMN_SIZE");
        int colScale = columnRS.getInt("DECIMAL_DIGITS");
        
        //Nullable
        String isNullableBool = columnRS.getString("IS_NULLABLE");
        String isNullable = (isNullableBool.equalsIgnoreCase("YES")) ? "NULL" : "NOT NULL";
        
        //Autoincrement
        String isAutoIncrementBool = columnRS.getString("IS_AUTOINCREMENT");
        String isAutoIncrement = (isAutoIncrementBool.equalsIgnoreCase("YES")) ? " AUTO_INCREMENT" : "";
        
        return DBColumnFactory(colName, colType, isNullable, colSize, colScale, isAutoIncrement);
    }

    //Second constructor of columns : build a column differently regarding its type
    public static DBColumn DBColumnFactory(final String colName, final String colType, String isNullable, int colSize, int colScale, final String isAutoIncrement)  
    {
    		switch(colType) {
    			case "DECIMAL": //Columns with two params
    				return new DBColumnDoubleParam(colName, colType, isNullable, colSize, colScale, isAutoIncrement);
    			case "TINYINT UNSIGNED":
    			case "VARCHAR":
    			case "NCHAR":
    			case "INT":
    			case "SMALLINT UNSIGNED":
    			case "FLOAT":
    			case "REAL": //Columns with one param
    				return new DBColumnSingleParam(colName, colType, isNullable, colSize, isAutoIncrement);
    			case "BLOB":
    			case "BINARY": //Columns with no param
    				 return new DBColumnNoParam(colName, colType, isNullable, colSize, isAutoIncrement);
    			default: //Unidentified columns
    				return new DBColumnSingleParam(colName, colType, isNullable, colSize, isAutoIncrement);
    				
    		}
    	
    }
    
    
}
