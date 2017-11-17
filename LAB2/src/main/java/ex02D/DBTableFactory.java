package ex02D;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class DBTableFactory {
	
    private static ResultSet columnRS;
    private static ResultSet primaryKeysRS;
    private static ResultSet foreignKeysRS;
    private static ResultSet uniqueKeysRS;
    
    private DBTableFactory() {
    }
    
    //Creation of a table, using the DBTable object, and the access to metadata, and then calling DBTable constructor
    public static DBTable DBTableFactory(ResultSet table, DatabaseMetaData data) throws Exception {       
        
    		String tableName = table.getString("TABLE_NAME");
        String catalog = null;
        String schema = null;
        String column = null;
        
        columnRS = data.getColumns(catalog, schema, tableName, column);
        primaryKeysRS = data.getPrimaryKeys(catalog, schema, tableName);
        foreignKeysRS = data.getImportedKeys(catalog, schema, tableName);
        uniqueKeysRS = data.getIndexInfo(catalog, schema, tableName, true, true);

        return new DBTable(tableName, columnRS, primaryKeysRS, foreignKeysRS, uniqueKeysRS);
    } 

    public static ResultSet getColumnRS() {
        return columnRS;
    }

    public static ResultSet getPrimaryKeysRS() {
        return primaryKeysRS;
    }

    public static ResultSet getForeignKeysRS() {
        return foreignKeysRS;
    }

    public static ResultSet getUniqueKeysRS() {
        return uniqueKeysRS;
    }
    
    
}
