package ex02D;

public class DBFileFactory {
	
    private DBFileFactory() {
    }
    
    //Creation of the file by calling DBFile constructor
    public static DBFile DBFileFactory(String sqlInstructions) throws Exception {
    	
        return new DBFile(sqlInstructions);
    }
}
