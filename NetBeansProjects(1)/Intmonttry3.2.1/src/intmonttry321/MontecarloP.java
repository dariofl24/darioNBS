

package intmonttry321;

/**
 *
 * @author DarioF
 */
public class MontecarloP extends Thread {
    
    FunctionR9 fun;
    Iboxt box;
    Lista_dob<MontecarloP> Lm;
    double r,t,p;
    double pi2=(6.28318530717),pi=3.1415926535,vol,sum,prom,mm,sumt;
    //Thread
    double Rmin, Rmax;
    double Lim,TT;
    boolean flag=false;
    private double x,y,error;
    private String info;
    private double ID;
    
    public MontecarloP(FunctionR9 f){
       fun= f; 
    }//
    
    
    public MontecarloP(FunctionR9 f,double rmin,double rmax,double lim,Iboxt Box,double tt,Lista_dob<MontecarloP> lt,double asm,double id){
        fun=f;
        Rmin= rmin;
        Rmax= rmax;
        Lim= lim;
        box=Box;
        TT=tt;
        flag= true;
        Lm= lt;
        ID=id;
        info="Capa ID: "+ID+"\n"+"N poits:"+lim+"\n"+"asm="+asm+"\n"+"Rmin="+rmin+"\n"+"Rmax="+rmax+"\n";
    }//constructor Thread
    
    @Override
    public void run(){
        double ival;
        MontecarloP maux;
            
            ival= integratef(Lim,Rmin,Rmax);
            info= info+"Integral:"+ival+"\n"+"Error:"+error+"\n";
            //(double s,double err,String inf,double ID)
            if(TT==box.sumpp(ival,error,info,ID)){
               //box.printinfo(); 
               System.out.println("**Itot: "+box.gettotal()+"\n"+"**Etot: "+box.gettotalerror()+"\n"+"Rmax: "+Rmax+" ; ths:"+TT);
               return;
            }//if
            maux=Lm.elementoav();
            
            if(maux!=null) maux.start();
             
    }//run
    
    
    
    public double integratef(double lim,double rmin,double rmax){
        
        double[] rtp= new double[16];
        double[] fval= new double[(int)lim];
        double f;
        
        vol= (32.0/945.0)*(pi*pi*pi*pi)*(Math.pow(rmax,9)-Math.pow(rmin,9)); 
        
        setRandomR(rmin,rmax);
        sum=0;
        
        for(double i=1;i<=lim;++i){
            //double[] rtp t,cp1,cp2,cp3,cp4,cp5,cp6,cp7,sp1,sp2,sp3,sp4,sp5,sp6,sp7,r
            r= randomR(((rmax-rmin) * (Math.random()))+rmin,rmin);
            
            t= pi2* (Math.random());
            rtp[0]=t;
            rtp[15]=r;
            
            for(int j=1;j<=7;++j){
                p= pi*(Math.random());
                rtp[j]= Math.cos(p); //cos phi
                rtp[j+7]= Math.sin(p); //sin phi
            }//for
            f= fun.valuatepol(rtp);
            fval[((int)i)-1]=f;
            sum= sum + f;
        }//for
        
        prom= sum/((double)lim);
        
        seterror(fval,prom,lim,vol);
        
        return prom*vol; 
    }//integratef
    
    private void setRandomR(double rmin,double rmax){     
        x= Math.pow(rmin,9);
        y= (Math.pow(rmax,9)-Math.pow(rmin,9))/(rmax-rmin);
    }//setRandomR
    
    private double randomR(double r,double rmin){//r= ((rmax - rmin)*Math.random())+ rmin
        return Math.pow(x + (y*(r-rmin)), 1.0/9.0);
    }//randomR
    
    private void seterror(double[] fval,double prom,double lim,double vol){
        double err=0;
        
        for(double i=0;i<lim;++i){
            err= err + Math.pow(fval[(int)i]-prom , 2);
            
        }//for
        
        err= err/( (double)(lim-1) );
        err= Math.sqrt(err/( (double)lim ));
        error= err*vol;
    }//seterror

}//class
