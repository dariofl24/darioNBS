

package intmonttry3d2_12;
import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 *
 * @author DarioF
 */
public class Iboxt {
    private double sum=0,infosum=0,ainf=1;
    private double turn=0,eproms=0,cerotime=0;
    private int infint=0;
    private String info="",FN="intMres";
    
    Lista_dob<Double> ids= new Lista_dob<Double>();
    Lista_dob<String> infs= new Lista_dob<String>();
    //Lista_dob<Double> errs= new Lista_dob<Double>();
    Lista_dob<Double> ss= new Lista_dob<Double>();
    BufferedWriter writer,wrte;
    
   
    public Iboxt(int iint){
        infint=iint;
        try{
            wrte= new BufferedWriter(new FileWriter("fval.txt"));
     
        }catch(IOException e){
            System.out.println("Write File err Iboxt");
        }//try-catch
    }//
   
    public Iboxt(int iint,String fn){
        infint=iint;
        FN=fn;
        try{
            wrte= new BufferedWriter(new FileWriter("fval.txt"));
     
        }catch(IOException e){
            System.out.println("Write File err Iboxt");
        }//try-catch
    }//
    
    
    
    public synchronized double sumpp(double s,String inf,double ID){
        
        sum= sum +s;
        
        
        turn=turn+1;
        
        store(s,inf,ID);
        
        return turn;
    }//sum
    
    private synchronized void store(double s,String inf,double ID){
        double a=0,b=0;
        
        
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
                printinfopp();
                return;
            }//if
            
            if(ids.estaAlFinal()){
                ids.insertarUltimo(ID);
                infs.insertarUltimo(inf);
                ss.insertarUltimo(s);
                printinfopp();
                return;
            }//if
            
                ids.avanza();
                infs.avanza();
                ss.avanza();
            
        }while( !(a<ID && ID<b) );
        
        
    }//store
    
    private synchronized void printinfopp(){
        
        double a=0,b=0,k=0;
        String sinf="";
        ids.primero();
        infs.primero();
        ss.primero();
        
        if(ids.lenght<infint){
            //System.out.println("print R1");
            return;
        }//if
        
        if(ids.elemento()!=ainf){
            //System.err.println("print R3:"+ids.elemento());
            return;
        }//if
        
        
        for(int i=1;i<infint;++i){
            a=ids.elemento();
            b=ids.elementosig();
            
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
            
            sinf=infs.elementoav()+"Partial I:"+infosum
                    +"\n---------------------------------\n";
        }//for
        
        sinf=time()+"\n"+"\n"+ sinf;
        
        //System.out.println(time()+"\n");
        System.out.println(sinf);
        writefile(sinf);
        ainf=ainf+infint;
    
    }//printinfopp
    
    public String time(){
        double time=0,seg,min,hor,dia;
        String tsd="";
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE,d MMM, H:mm:ss ");
        
        time= Math.round( (System.currentTimeMillis()-cerotime)/1000 ); 
        seg= time%60;
        
        min= Math.floor((time/60))%60;
                
        hor= Math.floor((time/3600));
        dia= Math.floor(hor/24);
        hor= hor%24;
        
        tsd=(dia==0)?"":dia+" D, ";
        tsd=tsd+ ((hor==0)?"":hor+ " h, ");
        tsd=tsd+ ((min==0)?"":min+ " min, ");
        tsd=tsd+ ((seg==0)?"":seg+ " seg.");
        
        return sdf.format(cal.getTime())+"; @ "+tsd; 
    }//time
    
    public void settime(){
        cerotime= System.currentTimeMillis();
    }//settime
    
    public synchronized double gettotal(){
        return sum;
    }//gettotal
    
    
   
    public synchronized void printinfo(){
        System.out.println(info);
         writefile(info);
    }//printinfo
    
    private synchronized void writefile(String info){
       
        if(info.equalsIgnoreCase("")){
            System.out.println("****File: empty");
            
            return;
        }//if
        
        try{
            writer= new BufferedWriter(new FileWriter(FN.trim()+".txt",true));
            writer.write(info);
            writer.newLine();
            writer.close();
            
        }catch(IOException e){
            System.out.println("Write File err Iboxt");
        }//try-catch
        
    }//writefile
    
    public synchronized void storeEInf(double[] fval,double eprom){
        
        for(double i=0;i<fval.length;++i){
            
            try{
                wrte.write(fval[(int)i]+"");
                wrte.newLine();
            }catch(IOException e){ 
                System.out.println("Write File err Iboxt");
            }//try-catch
            
        }//for
        
        eproms= eproms+eprom;
        
    }//storeEinf
    
    public double geterror(boolean flag,double n,double Vt){
        
        double error=0,sum=0;
        String s;
        
        try{
            wrte.close();
            if(!flag) return 0;
            
            BufferedReader reader= new BufferedReader(new FileReader("fval.txt"));
            
            s= reader.readLine().trim();
            
            while(s!=null){
                
                sum= sum + Math.pow( Double.parseDouble(s)-eproms ,2);
                
                s= reader.readLine();
            }//while
            
            error= sum/(n*n);
            error= Math.sqrt(error)*Vt;
            
        }catch(IOException e){
            System.out.println("Write File err Iboxt");
        }//try-catch
        
        return error;
    }//geterror
    
}//class
