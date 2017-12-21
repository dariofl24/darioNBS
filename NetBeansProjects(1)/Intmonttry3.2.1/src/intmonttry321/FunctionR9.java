

package intmonttry321;

/**
 *
 * @author DarioF
 */
public class FunctionR9 {

    double u,pi=3.1415926535;
    
    public FunctionR9(double v){
        u=v;
    }//
    
    public synchronized double valuate(double[]x){
        //double[]x R9 single point
            double q11=x[0],q12=x[1],q13=x[2],q21=x[3],q22=x[4],q23=x[5],q31=x[6],
                    q32=x[7],q33=x[8];
            double r1,r2;
            
            r1= funA(q11,q12,q13,q21,q22,q23);
            r2= funA(q31,q32,q33,q21,q22,q23);
            //r2= (q11*q11)+(q12*q12)+(q13*q13)+ (q21*q21)+(q22*q22)+(q23*q23)+(q31*q31)+(q32*q32)+(q33*q33);
            
            return r1*r2;
            //return (1/Math.pow(pi,9.0/2.0))*Math.exp(-r2);
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
        
        sin= sin*Math.sin(rtp[13]);
        x[6]= r*rtp[7]*sin;
        
        sin= sin*rtp[14];
        x[7]= r*Math.sin(t)*sin;
        x[8]= r*Math.cos(t)*sin;
        
        return funB(x);
        //return Math.exp(-(r*r));
        //return Math.exp(-1*Math.pow(r,9));
    }//valuatepol
    
    private synchronized double Kf(double x){
        //p[x_]=1+x^2/6+x^4/120+x^6/5040+x^8/362880+x^10/39916800+x^12/6227020800
        //+x^14/1307674368000+x^16/355687428096000+x^18/121645100408832000
        //+x^20/51090942171709440000
        
        double r=0;
        double xp= x*x;
        
        if(Math.abs(x)<=0.5){
            r= 1.0+((xp)/6.0);
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
    
    private synchronized double funA(double q11,double q12,double q13,double q21,double q22,double q23){
        
        double r=0;
        
        //Exp[-0.25*(1 + (2*u - 1)^2)*((q11 + q21)^2 + (q12 + q22)^2 + (q13 + q23)^2)]
        r= Math.exp( -0.25*(1+((2*u-1)*(2*u-1)))*(((q11 + q21)*(q11 + q21)) + ((q12 + q22)*(q12 + q22))+((q13 + q23)*(q13 + q23)) ) );   
        
        //Sqrt[((1 - u)*q11 - u*q21)^2 + ((1 - u)*q12 - u*q22)^2 + ((1 - u)*q13 – u*q23)^2]
        r=r* Math.sqrt( Math.pow((1 - u)*q11 - u*q21,2)+ Math.pow((1 - u)*q12 - u*q22,2)+Math.pow((1 - u)*q13 - u*q23,2)  );
        
        //Exp[-(((1 - u)*q11 - u*q21)^2 + ((1 - u)*q12 - u*q22)^2 + ((1 - u)*q13 - u*q23)^2)]
        r=r*Math.exp( -( Math.pow((1 - u)*q11 - u*q21,2) + Math.pow((1 - u)*q12 - u*q22,2) + Math.pow((1 - u)*q13 - u*q23,2) ) );
        
        //k[(2 u – 1)* Sqrt[((1 - u)*q11 - u*q21)^2 + ((1 - u)*q12 - u*q22)^2 + ((1 - u)*q13 -u*q23)^2]*Sqrt[(q11 + q21)^2 + (q12 + q22)^2 + (q13 + q23)^2]]
        r=r* Kf( (2*u - 1)*Math.sqrt( Math.pow((1 - u)*q11 - u*q21, 2)+ Math.pow((1 - u)*q12 - u*q22, 2)+ Math.pow((1 - u)*q13 -u*q23,2))* Math.sqrt( ((q11 + q21)*(q11 + q21))+((q12 + q22)*(q12 + q22))+((q13 + q23)*(q13 + q23))) );
        
        //Exp[-0.5*(q11^2 + q12^2 + q13^2)]
        r=r*Math.exp( -0.5*( (q11*q11) + (q12*q12) + (q13*q13) ) );
        
        return r;
    }//funA
    
    private synchronized double funB(double[]x){
        double r=1,e1,e2,e3,e4,e5,e6;
        double q11=x[0],q12=x[1],q13=x[2],q21=x[3],q22=x[4],q23=x[5],q31=x[6],
               q32=x[7],q33=x[8];
        
        e1=-0.25*(1+((2*u-1)*(2*u-1)))*(((q11 + q21)*(q11 + q21)) + ((q12 + q22)*(q12 + q22))+((q13 + q23)*(q13 + q23)) );
        e2=-0.25*(1+((2*u-1)*(2*u-1)))*(((q31 + q21)*(q31 + q21)) + ((q32 + q22)*(q32 + q22))+((q33 + q23)*(q33 + q23)) );
        e3=-( Math.pow((1 - u)*q11 - u*q21,2) + Math.pow((1 - u)*q12 - u*q22,2) + Math.pow((1 - u)*q13 - u*q23,2) );
        e4=-( Math.pow((1 - u)*q31 - u*q21,2) + Math.pow((1 - u)*q32 - u*q22,2) + Math.pow((1 - u)*q33 - u*q23,2) );
        e5=-0.5*( (q11*q11) + (q12*q12) + (q13*q13) );
        e6=-0.5*( (q31*q31) + (q32*q32) + (q33*q33) );
        
        //Exp[-0.25*(1 + (2*u - 1)^2)*((q11 + q21)^2 + (q12 + q22)^2 + (q13 + q23)^2)]
        r= Math.exp( e1+e2+e3+e4+e5+e6 );   
        
        //Sqrt[((1 - u)*q11 - u*q21)^2 + ((1 - u)*q12 - u*q22)^2 + ((1 - u)*q13 – u*q23)^2]
        r=r* Math.sqrt( Math.pow((1 - u)*q11 - u*q21,2)+ Math.pow((1 - u)*q12 - u*q22,2)+Math.pow((1 - u)*q13 - u*q23,2)  );
        r=r* Math.sqrt( Math.pow((1 - u)*q31 - u*q21,2)+ Math.pow((1 - u)*q32 - u*q22,2)+Math.pow((1 - u)*q33 - u*q23,2)  );
        
        //Exp[-(((1 - u)*q11 - u*q21)^2 + ((1 - u)*q12 - u*q22)^2 + ((1 - u)*q13 - u*q23)^2)]
        
        //k[(2 u – 1)* Sqrt[((1 - u)*q11 - u*q21)^2 + ((1 - u)*q12 - u*q22)^2 + ((1 - u)*q13 -u*q23)^2]*Sqrt[(q11 + q21)^2 + (q12 + q22)^2 + (q13 + q23)^2]]
        r=r* Kf( (2*u - 1)*Math.sqrt( Math.pow((1 - u)*q11 - u*q21, 2)+ Math.pow((1 - u)*q12 - u*q22, 2)+ Math.pow((1 - u)*q13 -u*q23,2))* Math.sqrt( ((q11 + q21)*(q11 + q21))+((q12 + q22)*(q12 + q22))+((q13 + q23)*(q13 + q23))) );
        r=r* Kf( (2*u - 1)*Math.sqrt( Math.pow((1 - u)*q31 - u*q21, 2)+ Math.pow((1 - u)*q32 - u*q22, 2)+ Math.pow((1 - u)*q33 -u*q23,2))* Math.sqrt( ((q31 + q21)*(q31 + q21))+((q32 + q22)*(q32 + q22))+((q33 + q23)*(q33 + q23))) );
        
        //Exp[-0.5*(q11^2 + q12^2 + q13^2)]
        
        return r;
    }//funA
    
    
}//class
