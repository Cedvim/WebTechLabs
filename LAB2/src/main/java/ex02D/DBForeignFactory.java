package ex02D;

import java.sql.ResultSet;

public class DBForeignFactory {
	
    private DBForeignFactory() {
    }
    
    //Construction of the foreign keys by calling the DBForeign constructor
    public static DBForeign DBForeignFactory(ResultSet foreignKeysRS) throws Exception {
    	
        String primaryKeyName = foreignKeysRS.getString(8);
        String foreignTableName = foreignKeysRS.getString(3);
        String foreignKeyName = foreignKeysRS.getString(4);
        
        return new DBForeign(primaryKeyName, foreignTableName, foreignKeyName);
    }
}
