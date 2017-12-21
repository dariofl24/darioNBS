

package cleaner;
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
            
            writer= new BufferedWriter(new FileWriter("fval.dat"));
            writer.write("");
            writer.close();
            
            System.out.println("IntVal.dat");
            System.out.println("fval.dat");
            
        }catch(IOException ee){
            System.err.println("error Main IO");
            return;
        }//catch
        
        
        
    }//class

}//main
