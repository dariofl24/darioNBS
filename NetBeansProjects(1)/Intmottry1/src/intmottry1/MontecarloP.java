

package intmottry1;

/**
 *
 * @author DarioF
 */
public class MontecarloP extends Thread {
    
    FunctionR2 fun;
    Iboxt box;
    Lista_dob<MontecarloP> Lm;
    double r,t,f;
    double pi2=(6.28318530717),pi=3.1415926535,vol,sum,prom,mm,sumt;
    //Thread
    double Rmin, Rmax;
    int Lim,TT;
    boolean flag=false;
    
    public MontecarloP(FunctionR2 f){
       fun= f; 
    }//
    
    public MontecarloP(FunctionR2 f,double rmin,double rmax,int lim,Iboxt Box,int tt){
        fun=f;
        Rmin= rmin;
        Rmax= rmax;
        Lim= lim;
        box=Box;
        TT=tt;
    }//constructor Thread
    
    public MontecarloP(FunctionR2 f,double rmin,double rmax,int lim,Iboxt Box,int tt,Lista_dob<MontecarloP> lt){
        fun=f;
        Rmin= rmin;
        Rmax= rmax;
        Lim= lim;
        box=Box;
        TT=tt;
        flag= true;
        Lm= lt;
    }//constructor Thread
    
    @Override
    public void run(){
        double ival;
        MontecarloP maux;
        
        if(!flag){
            ival= integratef(Lim,Rmin,Rmax);
            if(TT==box.sum(ival)){
               System.out.println("R: \n"+box.gettotal()+"\n"+"Rmax: "+Rmax);
            }//if
        }else{
            
            ival= integratef(Lim,Rmin,Rmax);
            if(TT==box.sum(ival)){
               System.out.println("R: \n"+box.gettotal()+"\n"+"Rmax: "+Rmax);
               return;
            }//if
            maux=Lm.elementoav();
            
            if(maux!=null) maux.run();
            
        }//if-else
        
        
    }//run
    
    public double integratefss(double rma, double rmb, int stps, int lim){ 
        double as; //area de cada paso 
        double ra, rb; //radios de cada paso 
        sumt=0;
        
        as= (pi*((rmb*rmb)-(rma*rma)))/stps;
        ra=rma;
        
        for(int i=1; i<=stps;++i){
            
            rb= Math.sqrt( ((1/pi)*as) +(ra*ra) );
            if(rb>rmb){ rb=rmb; }
            
            sumt= sumt + integratef(lim,ra,rb);
            
            ra=rb;
        }//for
        
        
        return sumt;
    }//integratefss
    
    public double integratef(int lim,double rmin,double rmax){
        double volR6;
        vol= pi*((rmax*rmax)-(rmin*rmin));
        sum=0;
        volR6= vol*vol*vol;
        
        for(int i=1;i<=lim;++i){
            r= ((rmax-rmin) * (Math.random()))+rmin;
            t= pi2* (Math.random());
            
            f= fun.valuatepol(r, t);
            //lf.insertarUltimo(f);
            
            sum= sum + f;
        }//for
       
        prom= sum/lim;
        
        return prom*vol;
    }//integratef
    
    
    
    
    

}//class
