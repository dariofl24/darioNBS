

package intmonttry32;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author DarioF
 */
public class Iboxt {
    private double sum=0,infosum=0,infoerr=0,error=0,ainf=1;
    private double turn=0;
    private int infint=0,file=1;
    private String info="";
    
    Lista_dob<Double> ids= new Lista_dob<Double>();
    Lista_dob<String> infs= new Lista_dob<String>();
    Lista_dob<Double> errs= new Lista_dob<Double>();
    Lista_dob<Double> ss= new Lista_dob<Double>();
    
    //public Iboxt(){
      //  sum=0;
        //turn=0;
    // }//
   
    public Iboxt(int iint){
        infint=iint;
    }//
   
    
    
    public synchronized double sum(double s,String inf){
        
        sum= sum +s;
        turn=turn+1;
        info= info +"---------------------------------\n"
                +inf+"Partial I: "+sum+"\n---------------------------------\n";
        if(turn%infint==0){
            System.out.print(info);
            writefile(info);
            
            info="";
        }//if
        
        return turn;
    }//sum
    
    public synchronized double sumpp(double s,double err,String inf,double ID){
        
        sum= sum +s;
        error= error+err;
        
        turn=turn+1;
        
        store(s,err,inf,ID);
        
        return turn;
    }//sum
    
    private synchronized void store(double s,double err,String inf,double ID){
        double a=0,b=0;
        
        
        if(ids.Vacia()){
            ids.insertarPrimero(ID);
            infs.insertarPrimero(inf);
            errs.insertarPrimero(err);
            ss.insertarPrimero(s);
            //System.out.println("stV:"+ID);
            return;
        }//if
        
        ids.primero();
        infs.primero();
        errs.primero();
        ss.primero();
        
        do{
            a=(ids.estaAlPrincipio())?0:b;
            b=ids.elemento();
            
            if(a<ID && ID<b){
                ids.insetarAntes(ID);
                infs.insetarAntes(inf);
                errs.insetarAntes(err);
                ss.insetarAntes(s);
                printinfopp();
                return;
            }//if
            
            if(ids.estaAlFinal()){
                ids.insertarUltimo(ID);
                infs.insertarUltimo(inf);
                errs.insertarUltimo(err);
                ss.insertarUltimo(s);
                printinfopp();
                return;
            }//if
            
                ids.avanza();
                infs.avanza();
                errs.avanza();
                ss.avanza();
            
        }while( !(a<ID && ID<b) );
        
        
    }//store
    
    private synchronized void printinfopp(){
        
        double a=0,b=0,k=0;
        String sinf="";
        ids.primero();
        infs.primero();
        errs.primero();
        ss.primero();
        
        if(ids.lenght<infint){
            //System.out.println("print R1");
            return;
        }//
        if(ids.elemento()!=ainf){
            //System.err.println("print R3:"+ids.elemento());
            return;
        }//
        String st="";//
        for(int i=1;i<infint;++i){
            a=ids.elemento();
            b=ids.elementosig();
            st=st+a+","+b+" ";
            if(a!=b-1){
                //System.err.println("print R2: "+st);
                return;
            }//if
            ids.avanza();
        }//for
        ids.primero();
        
        for(int j=1;j<=infint;++j){
            k= ids.elementoav();
            infosum= infosum + ss.elementoav();
            infoerr= infoerr + errs.elementoav();
            sinf= sinf+ infs.elementoav()+"Partial e:"+infoerr+"\n"+"Partial I:"+infosum
                    +"\n---------------------------------\n";
        }//for
        
                
        
        System.out.println(sinf);
        writefile(sinf);
        ainf=ainf+infint;
    
    }//printinfopp
    
    public synchronized double gettotal(){
        return sum;
    }//gettotal
    
    public synchronized double gettotalerror(){
        return error;
    }//gettotal
   
    public synchronized void printinfo(){
        System.out.println(info);
         writefile(info);
    }//printinfo
    
    private synchronized void writefile(String info){
       
        if(info.equalsIgnoreCase("")){
            System.out.println("****File:"+this.file+" empty");
            
            return;
        }//if
        
        try{
            BufferedWriter writer= new BufferedWriter(new FileWriter("Int_A"+file+".txt"));
            writer.write(info);
            writer.newLine();
            writer.close();
            
            System.out.println("****A_I:"+this.file+" , writen");file= file+1;
            
        }catch(IOException e){
            System.out.println("werr");
        }//try-catch
        
    }//writefile
    
}//class
