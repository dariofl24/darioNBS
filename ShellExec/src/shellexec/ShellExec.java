
package shellexec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShellExec {

    
    public static void main(String[] args) {
        
        Process p;
        
        long t1 = new Date().getTime();
        long t2;
        
        try{
            
            p = Runtime.getRuntime().exec("cat /Users/Dario/apache_startup.sh");
            
            p.waitFor();
 
            BufferedReader reader = new BufferedReader(new InputStreamReader(
            p.getInputStream()));
            String line = reader.readLine();
        
            t2 = new Date().getTime();
            
            while (line != null) {
                line = reader.readLine();
                System.out.println(line);
            }//while
            
            System.out.println("T: "+( Math.floor((t2-t1)/1000 ))  );
            
        }catch(Exception e){
            System.out.println("ERROR");
            e.printStackTrace();
        }//try - catch
        
    }//main
    
}//class
