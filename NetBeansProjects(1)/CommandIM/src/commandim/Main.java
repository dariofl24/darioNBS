

package commandim;
import java.io.*;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        double rma1=0,rmb1=1,asm1=128,lim1=100500;
        int infint=2;
        double u=0.5,maxth=2;
        String fn="ffa";
        double rma2=0,rmb2=1,asm2=128,lim2=100500;
              
        BufferedReader con= new BufferedReader(new InputStreamReader(System.in));
        
        
        try{
            
            BufferedWriter writer= new BufferedWriter(new FileWriter("com_dat.dat"));  
            
            System.out.println("*** Configuracion de la integral A \n");
            System.out.print("Radio minimo rma1= ");
            rma1= Double.parseDouble( con.readLine().trim() );
            writer.write(""+rma1);
            writer.newLine();
            
            System.out.print("Radio Maximo rmb1= ");
            rmb1= Double.parseDouble( con.readLine().trim() );
            writer.write(""+rmb1);
            writer.newLine();
            
            System.out.print("Puntos por capa= ");
            lim1= Integer.parseInt( con.readLine().trim() );
            writer.write(""+lim1);
            writer.newLine();
            
            System.out.print("Volumen por capa (S.M.U.)= ");
            asm1= Double.parseDouble( con.readLine().trim() );
            writer.write(""+asm1);
            writer.newLine();
            
            System.out.println("*** Configuracion de la integral B \n");
            System.out.println("Datos integral A = Datos integral b ? (s/n):");
            
            if(con.readLine().trim().equalsIgnoreCase("s")){
                rma2= rma1; System.out.println("rma2= "+rma1);
                rmb2= rmb1; System.out.println("rmb2= "+rmb1);
                lim2= lim1; System.out.println("lim2= "+lim1);
                asm2= asm1; System.out.println("asm2= "+asm1);
            }else{
                System.out.print("Radio minimo rma2= ");
                rma2= Double.parseDouble( con.readLine().trim() );
            
                System.out.print("Radio Maximo rmb2= ");
                rmb2= Double.parseDouble( con.readLine().trim() );
            
                System.out.print("Puntos por capa= ");
                lim2= Integer.parseInt( con.readLine().trim() );
            
                System.out.print("Volumen por capa (S.M.U.)= ");
                asm2= Double.parseDouble( con.readLine().trim() );
            }//if-else
            
            writer.write(""+rma2); writer.newLine();
            writer.write(""+rmb2); writer.newLine();
            writer.write(""+lim2); writer.newLine();
            writer.write(""+asm2); writer.newLine();
            
            System.out.print("Procesos simultaneos= ");
            maxth= Integer.parseInt( con.readLine().trim() );
            writer.write(""+maxth); writer.newLine();
            
            System.out.print("Intervalo de informacion= ");
            infint= Integer.parseInt( con.readLine().trim() );
            writer.write(""+infint); writer.newLine();
            
            System.out.print("u= ");
            u= Double.parseDouble( con.readLine().trim() );
            writer.write(""+u); writer.newLine();
            
            System.out.println("Nombre de archivo: ");
            fn= con.readLine().trim();
            writer.write(""+fn); writer.newLine();
            
            writer.close();
            
        }catch(IOException ee){
            System.out.println("error Main IO");
            return;
        }catch(NumberFormatException e){
            System.err.println("***Error al ingresar un numero");
           return; 
        }//try-catch
        
        
    }//main

}//class
