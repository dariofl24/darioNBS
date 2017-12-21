

package intmonttry3d2;

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
    double Lim,TT;
    boolean flag=false;
    private double x,y,error;
    private String info;
    private double ID;
    
    public MontecarloP(FunctionR f){
       fun= f; 
    }//
    
    public MontecarloP(FunctionR f,double rmin,double rmax,double lim,Iboxt Box,double tt,double id){
        fun=f;
        Rmin= rmin;
        Rmax= rmax;
        Lim= lim;
        box=Box;
        TT=tt;
        ID=id;
        info="Trhead ID: "+ID+"\n"+"N poits:"+lim+"\n"+"Rmin="+rmin+"\n"+"Rmax="+rmax+"\n";
    }//constructor Thread
    
    public MontecarloP(FunctionR f,double rmin,double rmax,double lim,Iboxt Box,double tt,Lista_dob<MontecarloP> lt,double id){
        fun=f;
        Rmin= rmin;
        Rmax= rmax;
        Lim= lim;
        box=Box;
        TT=tt;
        flag= true;
        Lm= lt;
        ID=id;
        info="Capa ID: "+ID+"\n"+"N poits:"+lim+"\n"+"Rmin="+rmin+"\n"+"Rmax="+rmax+"\n";
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
        
        return prom*vol; 
    }//integratef
    
    private void setRandomR(double rmin,double rmax){     
        x= Math.pow(rmin,3);
        y= (Math.pow(rmax,3)-Math.pow(rmin,3))/(rmax-rmin);
    }//setRandomR
    
    private double randomR(double r,double rmin){//r= ((rmax - rmin)*Math.random())+ rmin
        return Math.pow(x + (y*(r-rmin)), 1.0/3.0);
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
    
    private boolean admisR(double[] rtp,double rmin,double rmax){
        //double[] rtp t,cp1,cp2,cp3,cp4,cp5,cp6,cp7,sp1,sp2,sp3,sp4,sp5,sp6,sp7,r
        double r=rtp[15],t=rtp[0],sin=rtp[8],rp;
        double[] x= new double[9];
        
        x[0]= r*rtp[1];
        
        x[1]= r*rtp[2]*sin;
        
        sin= sin*rtp[9];
        x[2]= r*rtp[3]*sin;
        
        sin= sin*rtp[10];
        x[3]= r*rtp[4]*sin;
        
        sin= sin*rtp[11];
        x[4]= r*rtp[5]*sin;
        
        sin= sin*rtp[12];
        x[5]= r*rtp[6]*sin;
        
        sin= sin*Math.sin(rtp[13]);
        x[6]= r*rtp[7]*sin;
        
        sin= sin*rtp[14];
        x[7]= r*Math.sin(t)*sin;
        x[8]= r*Math.cos(t)*sin;
        
        rp=Math.sqrt( (x[0]*x[0])+(x[1]*x[1])+(x[2]*x[2])+(x[3]*x[3])+(x[4]*x[4])+(x[5]*x[5])
                +(x[6]*x[6])+(x[7]*x[7])+(x[8]*x[8]));
       
        if(rp<rmin){ 
            //System.out.println("R-"); 
            return false; }
        if(rp>rmax){ 
            System.out.println("R+"); 
            return false; }
        
        return true;
    }//admisR

}//class
