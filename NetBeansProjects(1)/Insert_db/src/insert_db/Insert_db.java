
package insert_db;
import java.io.*;

public class Insert_db {

    public static void main(String[] args) {
        
        String line;
        double rn;
        int fk,aux;
        String[] year={"2010","2011","2012","2013","2013"};
        String[] month={"01","02","03","04","05","06","01","08","02","10","01","02","01","02"};
        String[] day={"01","15","25","28","10","11"};
        
        try{
            
            BufferedWriter writer= new BufferedWriter(new FileWriter("insert4.sql"));
            
            for(int i=1;i<=1500;i++){
                
                line="INSERT INTO comprobante (COMP_ID_PK,FECHA_CREACION,STATUS,USU_ID,TIPO_COMPROBANTE,TIPO_CFD_ID_FK,TOTAL,CONTRIBUYENTE_ID_FK,CLIENTE_ID_FK) VALUES (";
                line=line+i+",";
                
                rn=  Math.floor( (Math.random()*1000) );
                rn= (rn%5);
                aux= (int) rn;
                
                line=line+"'"+year[aux]+"-";
                
                rn=  Math.floor( (Math.random()*1000) );
                rn= (rn%14);
                aux= (int) rn;
                
                line=line+month[aux]+"-";
                
                rn=  Math.floor( (Math.random()*1000) );
                rn= (rn%6);
                aux= (int) rn;
                
                line=line+day[aux]+" 12:00:00',"; //fecha de creacion
                
                line=line+( (i%2)+1 )+",";//status
                
                line=line+( (i%100)+1 )+",";
                
                line=line+"'Tipo de comprobante-"+i+"',";
                
                line=line+( (i%12)+1 )+",";//tipo cfd
                
                rn=  Math.floor( (Math.random()*1000) );
                
                line=line+rn+",";//total
                
                rn=  Math.floor( (Math.random()*1000) );
                rn= (rn%190)+1;
                aux= (int) rn;
                
                line=line+aux+",";//contribuyente ID
                
                rn=  Math.floor( (Math.random()*1000) );
                rn= (rn%100)+1;
                aux= (int) rn;
                
                line=line+aux+");";//cliente ID
                
                
                writer.write(line);
                writer.newLine();
                
            }//for 
            
            writer.close();
            
            
        }catch(IOException e){
            
        }//try-catch
        
        
    }//main
    
}//class 
