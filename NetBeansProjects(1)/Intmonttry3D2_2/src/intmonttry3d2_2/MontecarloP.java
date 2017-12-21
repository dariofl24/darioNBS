

package intmonttry3d2_2;
import java.io.*;


/**
 *
 * @author DarioF
 */
public class MontecarloP extends Thread {
    
    FunctionR fun;
    Iboxt box;
    Lista_dob<MontecarloP> Lm;
    double r,t,p;
    double pi2=(6.28318530717),pi=3.1415926535,vol,sum,prom,mm,sumt;
    //Thread
    double Rmin, Rmax;
    double Lim,TT,VT;
    boolean flag=false;
    private double x,y;
    private String info;
    private double cerotime;
    private double ID;
    BufferedWriter writer;
    
    public MontecarloP(FunctionR f){
       fun= f; 
    }//
    
    public MontecarloP(FunctionR f,double rmin,double rmax,double lim,Iboxt Box,double tt,double id,double vt){
        fun=f;
        Rmin= rmin;
        Rmax= rmax;
        Lim= lim;
        box=Box;
        TT=tt;
        ID=id;
        VT= vt;
        info="Trhead ID: "+ID+";"+"N poits:"+lim+";"+"Rmin="+rmin+";"+"Rmax="+rmax+";";
    }//constructor Thread
    
    public MontecarloP(FunctionR f,double rmin,double rmax,double lim,Iboxt Box,double tt,Lista_dob<MontecarloP> lt,double id,double vt){
        fun=f;
        Rmin= rmin;
        Rmax= rmax;
        Lim= lim;
        box=Box;
        TT=tt;
        flag= true;
        Lm= lt;
        ID=id;
        VT= vt;
        info="Capa ID: "+ID+";"+"N poits:"+lim+";"+"Rmin="+rmin+";"+"Rmax="+rmax+";";
    }//constructor Thread
    
    @Override
    public void run(){
        double ival;
        MontecarloP maux;
            cerotime= System.currentTimeMillis();
            ival= integratef(Lim,Rmin,Rmax,true);
            info=time()+" ; ;"+info+"Integral(capa):"+ival+";";
            
            
            box.storew(ival,info,ID);
             
            maux=Lm.elementoav();
            
            if(maux!=null) maux.start();
            
        
    }//run
    
    
    public double integratef(double lim,double rmin,double rmax,boolean eflag){
        
        double[] rtp= new double[3];
        double[] fval= new double[(int)lim];
        double f;
        
        vol= (4.0/3.0)*pi*(Math.pow(rmax,3)-Math.pow(rmin,3)); 
        
        setRandomR(rmin,rmax);
        sum=0;
        
        for(double i=1;i<=lim;++i){
            //double[] rtp t,p,r
            r= randomR(((rmax-rmin) * (Math.random()))+rmin,rmin);
            t= pi2* (Math.random());
            p= pi*(Math.random());
            
            rtp[0]=t;
            rtp[1]=p;
            rtp[2]=r;
            
            f= fun.valuatepol(rtp);
            fval[((int)i)-1]=f;
            sum= sum + f;
        }//for
        
        prom= sum/((double)lim);
        
        //seterror(fval,prom,lim,vol);
        
        if(eflag) box.errorinf(fval);
        
        
        return prom*vol; 
    }//integratef
    
    private void setRandomR(double rmin,double rmax){     
        x= Math.pow(rmin,3);
        y= (Math.pow(rmax,3)-Math.pow(rmin,3))/(rmax-rmin);
    }//setRandomR
    
    private double randomR(double r,double rmin){//r= ((rmax - rmin)*Math.random())+ rmin
        return Math.pow(x + (y*(r-rmin)), 1.0/3.0);
    }//randomR
    
    private String time(){
        double time=0,seg,min,hor,dia;
        String tsd="";
        
        
        time= Math.round( (System.currentTimeMillis()-cerotime)/1000 ); 
        seg= time%60;
        
        min= Math.floor((time/60))%60;
                
        hor= Math.floor((time/3600));
        dia= Math.floor(hor/24);
        hor= hor%24;
        
        tsd=(dia==0)?"":dia+" D, ";
        tsd=tsd+ ((hor==0)?"":hor+ " h, ");
        tsd=tsd+ ((min==0)?"":min+ " min, ");
        tsd=tsd+ ((seg==0)?"":seg+ " seg");
        
        return "Tiempo capa: "+tsd; 
    }//time
    

}//class
