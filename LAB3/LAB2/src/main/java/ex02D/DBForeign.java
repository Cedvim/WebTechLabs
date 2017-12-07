package ex02D;

public class DBForeign {
	
    private String primaryKeyName;
    private String foreignTableName;
    private String foreignKeyName;
    
    //Getting the foreign key references
    public DBForeign(final String primaryKeyName, final String foreignTableName,final String foreignKeyName) throws Exception {
    	
    		this.primaryKeyName = primaryKeyName;	
    		this.foreignTableName = foreignTableName;
    		this.foreignKeyName = foreignKeyName;
	
    }
    
    //Writing the foreign keys references in sql
    public String toSQL() throws Exception {
    	
        final StringBuffer sb = new StringBuffer();
        sb.append("\nFOREIGN KEY (" + this.primaryKeyName + ") REFERENCES " 
        + this.foreignTableName + "(" + this.foreignKeyName + ")");

        return sb.toString();
    }
    
    
}
