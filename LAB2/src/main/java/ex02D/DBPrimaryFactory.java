package ex02D;

import java.sql.ResultSet;

public class DBPrimaryFactory {
	
    private DBPrimaryFactory() {
    }
    
    //Construction of the primary keys by calling the DBPrimary constructor
    public static DBPrimary DBPrimaryFactory(ResultSet primaryKeysRS) throws Exception {
    	
        String primaryKeyName = primaryKeysRS.getString(4);
        
        return new DBPrimary(primaryKeyName);
    }
}
