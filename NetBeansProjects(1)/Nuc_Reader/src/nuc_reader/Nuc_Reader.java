
package nuc_reader;
import java.io.*;

/**
 *
 * @author DarioF
 */
public class Nuc_Reader {

    
    public static void main(String[] args) {
        
        String line="",aux="",bl="      ";
        double a=0,z=0,n=0,bin=0,tb=0,t=0;
        double av=14.0,as=13.0,ac=0.58,aa=19.3,ap=33.5;
        
        try{
            BufferedReader reader= new BufferedReader(new FileReader("spine.txt"));
            BufferedWriter writer= new BufferedWriter(new FileWriter("spres.dat"));
            
            line= reader.readLine();
            
            
            while(line!=null){
                
                line=line.trim();
                
                //aux=line.substring(0,line.indexOf(" "))+"  ";
                //aux=aux+line.substring(line.length()-3,line.length()).trim();
                
                writer.write(line);
                writer.newLine();
                aux="";
                
                line= reader.readLine();
                
                
            }//while
            
            
            
            reader.close();
            writer.close();
        }catch(IOException e){
            
        }catch(NumberFormatException ee){
            System.out.println("Number **");
        }//try-catch
        
        
        
    }//main
}//class
