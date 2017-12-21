

package intmonttry3d2_2;
import java.io.*;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        double rma1=0,rmb1=0,asm1=0,lim1=0;
        int str=0;
        double u=0,maxth=0;
        String fn="ffa";
        double rma2=0,rmb2=0,asm2=0,lim2=0;
        BufferedReader reader;
        BufferedWriter writer;
        
        try{
            reader= new BufferedReader(new FileReader("com_dat1.dat"));
            
            rma1= Double.parseDouble( reader.readLine().trim() );
            rmb1= Double.parseDouble( reader.readLine() );
            lim1= Double.parseDouble( reader.readLine() );
            asm1= Double.parseDouble( reader.readLine() );
            
            rma2= Double.parseDouble( reader.readLine() );
            rmb2= Double.parseDouble( reader.readLine() );
            lim2= Double.parseDouble( reader.readLine() );
            asm2= Double.parseDouble( reader.readLine() );
            
            maxth=Double.parseDouble( reader.readLine() );
            u= Double.parseDouble( reader.readLine() );
            str= Integer.parseInt( reader.readLine() );
            
            writer= new BufferedWriter(new FileWriter("IntVal.dat"));
            writer.write("");
            writer.close();
            
            new MontecarloTM().launch(rma1,rma2,rmb1,rmb2,asm1,asm2,lim1,lim2,str,u,maxth,fn);
            
        }catch(IOException ee){
            System.out.println("error Main IO");
            return;
        }//try-catch
        
        
    }//main

}//class
