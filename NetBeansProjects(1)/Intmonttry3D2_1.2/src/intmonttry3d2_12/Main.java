

package intmonttry3d2_12;
import java.io.*;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        double rma1=0,rmb1=0,asm1=0,lim1=0;
        int infint=0;
        double u=0,maxth=0;
        String fn="ffa";
        double rma2=0,rmb2=0,asm2=0,lim2=0;
        BufferedReader reader;
        
        try{
            reader= new BufferedReader(new FileReader("com_dat.dat"));
            
            rma1= Double.parseDouble( reader.readLine().trim() );
            rmb1= Double.parseDouble( reader.readLine() );
            lim1= Double.parseDouble( reader.readLine() );
            asm1= Double.parseDouble( reader.readLine() );
            rma2= Double.parseDouble( reader.readLine() );
            rmb2= Double.parseDouble( reader.readLine() );
            lim2= Double.parseDouble( reader.readLine() );
            asm2= Double.parseDouble( reader.readLine() );
            maxth=Double.parseDouble( reader.readLine() );
            infint= Integer.parseInt( reader.readLine() );
            u= Double.parseDouble( reader.readLine() );
            fn= reader.readLine().trim();
            
            System.out.println("rma1: "+rma1);
            System.out.println("rmb1: "+rmb1);
            System.out.println("lim1: "+lim1);
            System.out.println("asm1: "+asm1);
            
            System.out.println("rma2: "+rma2);
            System.out.println("rmb2: "+rmb2);
            System.out.println("lim2: "+lim2);
            System.out.println("asm2: "+asm2);
            
            System.out.println("maxth: "+maxth);
            System.out.println("infint: "+infint); //
            System.out.println("u: "+u);
            System.out.println("fn: "+fn);
            
            new MontecarloTM().launch(rma1,rma2,rmb1,rmb2,asm1,asm2,lim1,lim2,infint,u,maxth,fn);
            
        }catch(IOException ee){
            System.out.println("error Main IO");
            return;
        }//try-catch
        
        
        
        
    }//main

}//class
