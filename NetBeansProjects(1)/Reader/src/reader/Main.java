

package reader;
import java.io.*;

/**
 *
 * @author DarioF
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BufferedReader reader;
        double max=0,min;
        String x="",y="",st;
        
        try{
            reader=new BufferedReader(new FileReader("SUERTE14.txt"));
            
            st= reader.readLine();
            
            while(st != null){
                x=x+ st.substring(0,st.lastIndexOf(","))+"\n";
                y=y+ st.substring(st.lastIndexOf(",")+1,st.length())+"\n";
                
                if(max< Double.parseDouble(st.substring(st.lastIndexOf(",")+1,st.length()).trim()))
                    max= Double.parseDouble(st.substring(st.lastIndexOf(",")+1,st.length()).trim());
                
                st=reader.readLine();
            }//while
            
            
            reader.close();
            
            System.out.println("x");
            System.out.println(x);
            
            System.out.println("******************************************");
            System.out.println(y);
            System.out.println("max:"+max);
        }catch(IOException io){
            
        }//try-catch
        
        
    }//main

}//class
