

package intmonttry321a;
import java.io.*;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        double rma=0,rmb=1,asm=128,lim=100500;
        int infint=2;
        double u=0.5,maxth=2;
        String fn="ffa";
        
        BufferedReader con= new BufferedReader(new InputStreamReader(System.in));
        
        
        try{
            System.out.print("Radio minimo rma= ");
            rma= Double.parseDouble( con.readLine().trim() );
            
            System.out.print("Radio Maximo rmb= ");
            rmb= Double.parseDouble( con.readLine().trim() );
            
            System.out.print("Puntos por capa= ");
            lim= Integer.parseInt( con.readLine().trim() );
            
            System.out.print("Volumen por capa (S.M.U.)= ");
            asm= Double.parseDouble( con.readLine().trim() );
            
            System.out.print("Procesos simultaneos= ");
            maxth= Integer.parseInt( con.readLine().trim() );
            
            System.out.print("Intervalo de informacion= ");
            infint= Integer.parseInt( con.readLine().trim() );
            
            System.out.print("u= ");
            u= Double.parseDouble( con.readLine().trim() );
            
            System.out.println("Nombre de archivo: ");
            fn= con.readLine().trim();
            
        }catch(IOException ee){
            
        }catch(NumberFormatException e){
           return; 
        }//
        
        
        new MontecarloTM().launch(rma, rmb, asm, lim, infint, u, maxth,fn);
        
    }//main

}//class
