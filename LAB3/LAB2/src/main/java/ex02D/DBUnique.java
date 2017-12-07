package ex02D;

public class DBUnique {
	
    private String uniqueKeyName;
    
    //Getting the unique key references
    public DBUnique(final String uniqueKeyName) throws Exception {
    	
    		this.uniqueKeyName = uniqueKeyName;	
    }
    
    //Writing the unique keys references in sql
    public String toSQL() throws Exception {
    	
        final StringBuffer sb = new StringBuffer();
        sb.append(this.uniqueKeyName);

        return sb.toString();
    }
    
    
}
