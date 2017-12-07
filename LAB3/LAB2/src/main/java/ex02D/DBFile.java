package ex02D;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class DBFile {
    private static File file;
    private static FileWriter fWriter;
    private static BufferedWriter bWriter;
    
    
    //Creation of the SQL file
    public DBFile(String sqlInstructions) throws Exception {
        file = new File("SQLInstructions.sql");	
        
        //If the file exist, we delete it so that we don't have copies of the information
        if(file.exists()) {
            file.delete();
        }
        
        fWriter = new FileWriter(file.getAbsoluteFile(), true);
        bWriter = new BufferedWriter(fWriter);
        
        //Writing the new instructions
        bWriter.newLine();
        bWriter.write(sqlInstructions);
        
        //Closing the file to save it
        bWriter.close();
 
    }
}
