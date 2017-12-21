

package commandim_cpp;
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
        String fn="ffa",s1,s2;
        double as1,as2,tt1,tt2,ra,rb=0,ra2,rb2=0;
        double rma2=0,rmb2=1,asm2=128,lim2=100500;
        double pi2=(6.28318530717),pi=3.1415926535;
              
        BufferedReader con= new BufferedReader(new InputStreamReader(System.in));
        
        
        try{
            BufferedWriter writer;  
            
            System.out.println("*** Configuracion de la integral A \n");
            System.out.print("Radio minimo rma1= ");
            rma1= Double.parseDouble( con.readLine().trim() );
            
            
            System.out.print("Radio Maximo rmb1= ");
            rmb1= Double.parseDouble( con.readLine().trim() );
            
            
            System.out.print("Puntos por capa= ");
            lim1= Integer.parseInt( con.readLine().trim() );
            
            
            System.out.print("Volumen por capa (S.M.U.)= ");
            asm1= Double.parseDouble( con.readLine().trim() );
            
            
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
            
            
            System.out.print("Procesos simultaneos= ");
            maxth= Integer.parseInt( con.readLine().trim() );
            
            System.out.print("u= ");
            u= Double.parseDouble( con.readLine().trim() );
            
            System.out.println("Nombre de archivo: ");
            fn= con.readLine().trim();
            
            if(rmb1<=rma1){ System.err.println("rmb1<rma1"); return; }//if
            if(rmb2<=rma2){ System.err.println("rmb2<rma2"); return; }//if
            
            as1= ( (4.0/3.0)*pi )/(asm1);
            tt1= ( (4.0/3.0)*pi*(Math.pow(rmb1,3)-Math.pow(rma1,3)) )/( ((4.0/3.0)*pi)/(asm1) );
            tt1= (double) Math.round(tt1);
        
            as2= ( (4.0/3.0)*pi )/(asm2);
            tt2= ( (4.0/3.0)*pi*(Math.pow(rmb2,3)-Math.pow(rma2,3)) )/( ((4.0/3.0)*pi)/(asm2) );
            tt2= (double) Math.round(tt2);
        
            if(tt1<1.0){ System.err.println("tt1<1"); return; }//if
            if(tt2<1.0){ System.err.println("tt2<1"); return; }//if
            if(tt1<maxth){ System.err.println("tt1<maxth"); return; }//if
            
            ra=rma1;
            for(int i=1;i<=tt1;++i){
                rb= Math.pow( ((3.0/(4.0*pi))*as1)+Math.pow(ra,3) ,1.0/3.0);
                ra=rb;
            }//for
            
            ra2=rma2;
            for(int i=1;i<=tt2;++i){
                rb2= Math.pow( ((3.0/(4.0*pi))*as2)+Math.pow(ra2,3) ,1.0/3.0);
                ra2=rb2;
            }//for
            
            s1="\n"+"****Info: \n\n"+" Rmin1= "+rma1+"\n"+" Rmax1= "+rb+"\n"+" N.puntos(1)= "+lim1+"\n"+" Subm.area (1)= "+asm1+"\n"+" Total Capas (1)= "+tt1+"\n";
            s2=" Rmin2= "+rma2+"\n"+" Rmax2="+rb2+"\n"+" N.puntos(2)= "+lim2+"\n"+" Subm.area (2)= "+asm2+"\n"+" Total Capas (2)= "+tt2+"\n\n"+" u="+u+"\n"
            +" Nombre de archivo: "+fn+"\n"+" Procesos sim: "+maxth;
            System.out.println(s1+"\n"+s2);
            
            
            for(int i=1;i<=maxth;++i){
                writer= new BufferedWriter(new FileWriter("com_dat"+i+".dat"));
                
                writer.write(""+rma1); writer.newLine();
                writer.write(""+rmb1); writer.newLine();
                writer.write(""+lim1); writer.newLine();
                writer.write(""+asm1); writer.newLine();
                
                writer.write(""+rma2); writer.newLine();
                writer.write(""+rmb2); writer.newLine();
                writer.write(""+lim2); writer.newLine();
                writer.write(""+asm2); writer.newLine();
                
                writer.write(""+maxth); writer.newLine(); //jmp
                writer.write(""+u); writer.newLine();
                writer.write(""+i); writer.newLine(); //Capa de inicio
                
                writer.close();
            }//for 
            
            writer= new BufferedWriter(new FileWriter("readerinf.dat"));
            writer.write(fn);
            writer.write(s1+"\n"+s2);
            writer.close();
            
            writer= new BufferedWriter(new FileWriter("stint"));
            
            for(int i=1;i<=maxth;++i){
                writer.write("nohup ./a.out "+i+" &");
                writer.newLine();
            }//for
            
            writer.write("echo *Launched");
            writer.newLine();
            
            writer.close();
            
            writer= new BufferedWriter(new FileWriter("IntVal.dat"));
            writer.write("");
            writer.close();
            
            
            
        }catch(IOException ee){
            System.err.println("error Main IO");
            return;
        }catch(NumberFormatException e){
            System.err.println("***Error al ingresar un numero");
           return; 
        }//try-catch
        
    }//main

}//class
