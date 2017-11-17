package ex02D;

public class DBPrimary {
	
    private String primaryKeyName;
    
    //Getting the primary key
    public DBPrimary(final String primaryKeyName) throws Exception {
    	
    		this.primaryKeyName = primaryKeyName;	
    }
    
    //Writing the primary key in sql
    public String toSQL() throws Exception {
    	
        final StringBuffer sb = new StringBuffer();
        sb.append(this.primaryKeyName);

        return sb.toString();
    }
    
    
}
