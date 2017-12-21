

package rreader_cpp;
import java.io.*;

/**
 *
 * @author DarioF
 */
public class Reader {
    
    Lista_dob<Double> ids= new Lista_dob<Double>();
    Lista_dob<String> infs= new Lista_dob<String>();
    Lista_dob<Double> ss= new Lista_dob<Double>();
    
    public void read(){
        String s1,s2,s3,s4,inf;
        Lista_dob<String> IDs= new Lista_dob<String>();
        Lista_dob<String> Ival= new Lista_dob<String>();
        Lista_dob<String> Infs= new Lista_dob<String>();
        double sum=0;
        
        try{
            BufferedReader reader= new BufferedReader(new FileReader("IntVal.dat"));
            
            s1=reader.readLine();
            s2=reader.readLine();
            s3=reader.readLine();
            s4=reader.readLine();
            
            while( (s1!=null)&&(s2!=null)&&(s3!=null)&&(s4!=null) ){
                
                IDs.insertarUltimo(s1.trim());
                Ival.insertarUltimo(s2.trim());
                Infs.insertarUltimo(s3.trim()+s4.trim());
                
                s1=reader.readLine();
                s2=reader.readLine();
                s3=reader.readLine();
                s4=reader.readLine();
            }//while
            reader.close();
            
            IDs.primero();
            Ival.primero();
            Infs.primero();
            
            while(IDs.elemento()!=null){
                
                store( Double.parseDouble(IDs.elementoav()),Double.parseDouble(Ival.elementoav()),Infs.elementoav() );
                
            }//while
            
            
            
        }catch(IOException e){
            System.out.println("Write File err Iboxt");
            
            read();
        }//try-catch
        
    }//read
    
    public synchronized void store(double ID,double s,String inf){
        double a=0,b=0;
        
        inf= inf.replaceAll(";","\n");
        
        if(ids.Vacia()){
            ids.insertarPrimero(ID);
            infs.insertarPrimero(inf);
            ss.insertarPrimero(s);
            //System.out.println("stV:"+ID);
            return;
        }//if
        
        ids.primero();
        infs.primero();
        ss.primero();
        
        do{
            a=(ids.estaAlPrincipio())?0:b;
            b=ids.elemento();
            
            if(a<ID && ID<b){
                ids.insetarAntes(ID);
                infs.insetarAntes(inf);
                ss.insetarAntes(s);
                
                return;
            }//if
            
            if(ids.estaAlFinal()){
                ids.insertarUltimo(ID);
                infs.insertarUltimo(inf);
                ss.insertarUltimo(s);
                
                return;
            }//if
            
                ids.avanza();
                infs.avanza();
                ss.avanza();
            
        }while( !(a<ID && ID<b) );
        
    }//store
    
    public void write(String fn,String info){
            ids.primero();
            infs.primero();
            ss.primero();
            double sum=0;
            String sn="\n";
            
            if((fn==null)||(info==null)) return;
            
            for(int i=1;i<=ids.lenght;++i){
                
                if(ids.elemento()!=i) break;
                
                sum=sum + ss.elemento();
                
                System.out.println(infs.elemento()+"Integral(Parcial): "+sum);
                System.out.println("------------------------------------------");
                
                sn=sn+infs.elemento()+"Integral(Parcial): "+sum+"\n"+"------------------------------------------"+"\n";
                
                ids.avanza();
                infs.avanza();
                ss.avanza();
            }//for
            
            
            
            try{
                BufferedWriter writer= new BufferedWriter(new FileWriter(fn+".txt"));
                writer.write(info);
                writer.newLine();
                        
                writer.write(sn);
                writer.newLine();
                writer.close();
            }catch(IOException e){
                System.out.println(e.getMessage());
            
            }//try-catch
        
    }//write

    
    
}//class
