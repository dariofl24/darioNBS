

package intmonttry32;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        double rma=0;
        int lim= 40500;
        double asm=2;
        double tot=32;
        int maxth=4;
        int infop=8;
        double u=0.5;
        
        
        BufferedReader con= new BufferedReader(new InputStreamReader(System.in));
        
        /*
        try{
            System.out.print("Radio minimo rma= ");
            rma= Double.parseDouble( con.readLine().trim() );
            
            System.out.print("Puntos por capa= ");
            lim= Integer.parseInt( con.readLine().trim() );
            
            System.out.print("Volumen por capa (S.M.U.)= ");
            asm= Double.parseDouble( con.readLine().trim() );
            
            System.out.print("Total de capas= ");
            tot= Double.parseDouble( con.readLine().trim() );
            
            System.out.print("Procesos simultaneos= ");
            maxth= Integer.parseInt( con.readLine().trim() );
            
            System.out.print("Intervalo de informacion= ");
            infop= Integer.parseInt( con.readLine().trim() );
            
            System.out.print("u= ");
            u= Double.parseDouble( con.readLine().trim() );
        }catch(IOException ee){
            
        }catch(NumberFormatException e){
           return; 
        }//
        */
        
        new MontecarloTM().launchThs(rma,lim,asm,tot,maxth,infop,u);
        
        
    }//main

}//class
