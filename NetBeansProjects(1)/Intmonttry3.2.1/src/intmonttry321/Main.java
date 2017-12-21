

package intmonttry321;
import java.io.*;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        double rma=0;
        double lim= 40500;
        double asm=2;
        double tot=32;
        int maxth=4;
        int infop=8;
        double u=0.5;
        String file,sadd="";
        
        Lista_dob<Double> liml= new Lista_dob<Double>();
        Lista_dob<Double> asml= new Lista_dob<Double>();
        Lista_dob<Double> IDbl= new Lista_dob<Double>();
        double ida=1,idb;
        
        BufferedReader con= new BufferedReader(new InputStreamReader(System.in));
        //con.readLine()
        
        try{
            System.out.print("Radio minimo rma= ");
            rma= Double.parseDouble( con.readLine().trim() );
            
            //System.out.print("Puntos por capa= ");
            //System.out.print("Volumen por capa (S.M.U.)= ");
            System.out.println("***CONFIGURACION DE VOLUMENES Y PUNTOS PARA LAS CAPAS");
            System.out.println("-----------------------------------------------------");
            
            IDbl.insertarUltimo(0.0);
            
            do{
                
                System.out.println("Configurar de Cap:"+ida+" a Cap:");
                idb=Double.parseDouble( con.readLine().trim() );
                if(idb<=ida){ System.out.println("error: "+idb+" < "+ida+"!!!"); continue;}
                IDbl.insertarUltimo(idb);
                ida=idb+1;
                
                System.out.print("Volumen de las capas (S.M.U.)= ");
                asml.insertarUltimo( Double.parseDouble( con.readLine().trim() ) );
                
                System.out.print("Puntos por capa= ");
                liml.insertarUltimo( Double.parseDouble( con.readLine().trim() ) );
                
                System.out.println("Agregar mas? (enter/n):");
                sadd= con.readLine().trim();
                System.out.println("-----------------------------------------------------");
            }while(sadd.equalsIgnoreCase(""));
            System.out.println("***Configuracion de capas terminada");
            
            tot= idb;
            
            System.out.print("Procesos simultaneos= ");
            maxth= Integer.parseInt( con.readLine().trim() );
            
            System.out.print("Intervalo de informacion= ");
            infop= Integer.parseInt( con.readLine().trim() );
            
            System.out.print("u= ");
            u= Double.parseDouble( con.readLine().trim() );
            
            System.out.print("Nombre de archivo: ");
            file= con.readLine().trim();
            
        }catch(IOException ee){
            return;
        }catch(NumberFormatException e){
            System.out.println("error: No se inserto numero");
           return; 
        }//try-catch
        
        /*
        System.out.println("tot:"+tot);
        
        liml.primero();
        asml.primero();
        IDbl.primero();
        
        for(int k=1;k<IDbl.lenght;++k){
            System.out.println("IDab:"+(IDbl.elemento()+1)+" ; "+IDbl.elementosig());
            System.out.println("asm:"+asml.elemento());
            System.out.println("lim:"+liml.elemento());
            System.out.println("-----------------------------------------------------");
            
            liml.avanza();
            asml.avanza();
            IDbl.avanza();
        }//for
        */
        
        
        new MontecarloTM().launchThsPl(rma,liml,asml,IDbl,tot,maxth,infop,u,file);
        //launchThsPl(rma,liml,asml,IDbl,tot,maxth,infint,u,file)
    }//main

}//class
