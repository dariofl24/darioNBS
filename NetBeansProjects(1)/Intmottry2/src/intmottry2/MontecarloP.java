

package intmottry2;

/**
 *
 * @author DarioF
 */
public class MontecarloP extends Thread {
    
    FunctionR9 fun;
    Iboxt box;
    Lista_dob<MontecarloP> Lm;
    double r,t,p,f,Lim;
    double pi2=(6.28318530717),pi=3.1415926535,vol,sum,prom,mm,sumt;
    //Thread
    double[] Rmin, Rmax;
    double TT;
    boolean flag=false;
    
    
    public MontecarloP(FunctionR9 f){
       fun= f; 
    }//
    
    public MontecarloP(FunctionR9 f,double[] rmin,double[] rmax,double lim,Iboxt Box,int tt){
        fun=f;
        Rmin= rmin;
        Rmax= rmax;
        Lim= lim;
        box=Box;
        TT=tt;
    }//constructor Thread
    
    public MontecarloP(FunctionR9 f,double[] rmin,double[] rmax,double lim,Iboxt Box,int tt,Lista_dob<MontecarloP> lt){
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
               System.out.println("*****************\n"+"***R: "+box.gettotal());
            }//if
        }else{
            
            ival= integratef(Lim,Rmin,Rmax);
            if(TT==box.sum(ival)){
               System.out.println("*****************\n"+"***R: "+box.gettotal());
               return;
            }//if
            maux=Lm.elementoav();
            
            if(maux!=null) maux.run();
            
        }//if-else
        
        
    }//run
    
    public double integratefss(double rma, double rmb, int stps, int lim){ 
        /**
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
         */
        return 0;
    }//integratefss
    
    public double integratef(double lim,double[] rmin,double[] rmax){
        double[][] point= new double[3][3];
        
        vol= (4.0/3.0)*pi*((rmax[0]*rmax[0]*rmax[0])-(rmin[0]*rmin[0]*rmin[0]));
        vol= vol*vol*vol;
        sum=0;
        
        System.out.println("s int");
        for(double i=1;i<=lim;++i){
            
            for(int k=0;k<=2;++k){
                point[k][0]= ((rmax[k]-rmin[k]) * (Math.random()))+rmin[k]; //r
                point[k][1]= pi*(Math.random()); //p
                point[k][2]= pi2* (Math.random()); //t
            }//for
            
            if((i%1000000)==0){ System.out.println(i+" ; "+((i/lim)*100)+"%"); }//if
            
            //f= fun.valuatepol(point);
            sum= sum + fun.valuatepol(point);
        }//for
        System.out.println("end int");
        
        prom= sum/lim;
        System.out.println("prom:"+prom);
        return prom*vol;
    }//integratef
    
    
    
    
    

}//class
