package ex02D;

import java.sql.ResultSet;

public class DBUniqueFactory {
	
    private DBUniqueFactory() {
    }
    
    //Construction of the unique keys by calling the DBUnique constructor
    public static DBUnique DBUniqueFactory(ResultSet uniqueKeysRS) throws Exception {
    	
        String uniqueKeyName = uniqueKeysRS.getString(9);
        return new DBUnique(uniqueKeyName);
    }
}
