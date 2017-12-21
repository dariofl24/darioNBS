

package rreader_cpp;
import java.io.*;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        Reader rw= new Reader();
        String fn="",inf="";
        
        try{
            BufferedReader reader= new BufferedReader(new FileReader("readerinf.dat"));
            
            fn= reader.readLine(); 
            
            for(int i=1;i<=17;++i){
                inf= inf+reader.readLine()+"\n";
            }//for
            reader.close();
            inf=inf+"\n"+"*Resultados:\n"+"------------------------------------------";
            System.out.println(inf);
            
        }catch(IOException e){
            
        }//try-catch
        
        rw.read();
        rw.write(fn,inf);
        
    }//main

}//class
