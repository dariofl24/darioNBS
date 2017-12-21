
package intmottry1;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        double rmax=1.5,rmin=1,i1,i2;
        int lim=40500;
        FunctionR2 fun = new FunctionR2();
        MontecarloP mo= new MontecarloP(fun);
        
        
        //double rma,int lim,int asm,int tot,int maxth
        new MontecarloTM().launchThs(0,lim,16,64,4);
        
        /**
        System.out.println("R:");
        i1= mo.integratef(lim, rmin, rmax);
        i2=mo.integratef(lim, 1.5, 2);
        System.out.println(i1+i2);
        System.out.println(mo.integratef(lim*2, 1, 2));
        */
         
        /**
        FunctionR2 func = new FunctionR2();
        double r=0,rm=1,t=0,pi2=(6.28318530717),sum=0;
        double rmax=3,rmin=2;
        int lim=38500;
        Lista_dob<Double> lr= new Lista_dob<Double>();
        Lista_dob<Double> lt= new Lista_dob<Double>();
        
        
        for(int i=1;i<=lim;++i){
            r= ((rmax-rmin) * (Math.random()))+rmin;
            t= pi2* (Math.random());
            
            if(lr.Existe(r) && lt.Existe(t) ){
                i=i-1; System.out.println("*r"); 
                continue;}//if
          lr.insertarPrimero(r);
          lt.insertarPrimero(t); 
           
            
            sum= sum + func.valuatepol(r, t);
            
        }//for 
        
        System.out.println("sum: "+sum+" ; lim:"+lim);
        System.out.println("Prom: ");
        System.out.println( (sum/lim)*(((rmax*rmax)-(rmin*rmin))*3.1415926535) );
        */
        
    }//main

}//class
