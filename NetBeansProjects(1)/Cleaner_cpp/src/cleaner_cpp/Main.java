
package cleaner_cpp;
import java.io.*;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        BufferedWriter writer;
        
        try{
            
            writer= new BufferedWriter(new FileWriter("IntVal.dat"));
            writer.write("");
            writer.close();
            
            System.out.println("IntVal.dat");
            
        }catch(IOException ee){
            System.err.println("error Main IO");
            return;
        }//catch
        
        
    }//main
    
}//class
