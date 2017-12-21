

package javaapplication16;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        double r,rmax=0,rmin=1;
        double t,p;
        double pi2=(6.28318530717),pi=3.1415926535;
        double[] rtp= new double[16];
        FunctionR9 fun = new FunctionR9(0.5);
        
        //double[] rtp t,cp1,cp2,cp3,cp4,cp5,cp6,cp7,sp1,sp2,sp3,sp4,sp5,sp6,sp7,r
            r= ((rmax-rmin) * (Math.random()))+rmin;
            
            t= pi2* (Math.random());
            rtp[0]=t;
            rtp[15]=r;
            
            for(int j=1;j<=7;++j){
                p= pi*(Math.random());
                rtp[j]= Math.cos(p); //cos phi
                rtp[j+7]= Math.sin(p); //sin phi
            }//for
        
            System.out.println("r: "+r);
            fun.valuatepol(rtp);
            
    }//main

}//class
