

package gsltry;

/**
 *
 * @author DarioF
 */
public class FunctionR9 {

    double u;
    
    public FunctionR9(double v){
        u=v;
    }//
    
    public synchronized double valuate(double[]x){
        //double[]x R9 single point
            
            
            
            
            
            return 0;
        }//valuate
    
    public synchronized double valuatepol(double[] rtp){
        //double[] rtp t,cp1,cp2,cp3,cp4,cp5,cp6,cp7,sp1,sp2,sp3,sp4,sp5,sp6,sp7,r
        double r=rtp[15],t=rtp[0],sin=rtp[8];
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
        
        sin= sin*Math.sin(rtp[12+1]);
        x[6]= r*rtp[7]*sin;
        
        sin= sin*rtp[14];
        x[7]= r*Math.sin(t)*sin;
        x[8]= r*Math.cos(t)*sin;
        
        //return valuate(x);
        //return 1.0/((r*r)+1);
        return r;
    }//valuatepol
    
    private double Kf(double x){
        //p[x_]=1+x^2/6+x^4/120+x^6/5040+x^8/362880+x^10/39916800+x^12/6227020800
        //+x^14/1307674368000+x^16/355687428096000+x^18/121645100408832000
        //+x^20/51090942171709440000
        
        double r=0;
        double xp= x*x;
        
        if(Math.abs(x)<=0.5){
            r= 1+((xp)/6.0);
            xp= xp*x*x;//4
            r= r+(xp/120.0);
            xp= xp*x*x;//6
            r= r+(xp/5040.0);
            xp= xp*x*x;//8
            r= r+(xp/362880.0);
            xp= xp*x*x;//10
            r= r+(xp/39916800.0);
            xp= xp*x*x;//12
            r= r+(xp/6227020800.0);
            xp= xp*x*x;//14
            r= r+(xp/1307674368000.0);
            xp= xp*x*x;//16
            r= r+(xp/355687428096000.0);
            xp= xp*x*x;//18
            r= r+(xp/121645100408832000.0);
            xp= xp*x*x;//20
            r= r+(xp/51090942171709440000.0);
            
            return r;
        }//if
        
        return Math.sinh(x)/x;
    }//functionF
    
    
    
    
}//class
