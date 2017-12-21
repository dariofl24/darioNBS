

package paraleltry;
import java.io.*;

/**
 *
 * @author DarioF
 */
public class Individual extends Thread{
    
    String ms;
    Printer mpr;
    BufferedWriter writer;
    BufferedReader reader;
    
    public Individual(String s,Printer p){
        ms= s;
        mpr=p;
    }//
    
    @Override
    public void run(){
        
        try{
            
            for(int i=0;i<100;++i){
                mpr.print(ms);
                wfile(ms);
                
                if( (i%5)==0 ) reader();
                
                Thread.sleep(40);
            }//for
            
        }catch(InterruptedException e){
            System.out.println("error");
        }//try-catch
        
    }//run
    
    private void wfile(String msj){
        
        try{
            writer= new BufferedWriter(new FileWriter("file.txt",true));
            writer.write(msj);
            writer.newLine();
            writer.close();
            
        }catch(IOException e){
            System.out.println("Write File err");
            wfile(msj+" e*********************");
        }//try-catch
        
    }//wflie
    
    private void reader(){
        String s;
        
        try{
            reader= new BufferedReader(new FileReader("file.txt"));
            s= reader.readLine().trim();
            
            while(s!=null){
                s= reader.readLine();
            }//while
            reader.close();
            System.out.println("read okok");
        }catch(IOException e){
            System.err.println("read File err");
            
        }//try-catch
        
    }//rea

}//class
