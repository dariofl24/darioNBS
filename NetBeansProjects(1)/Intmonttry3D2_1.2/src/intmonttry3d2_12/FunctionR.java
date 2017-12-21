

package intmonttry3d2_12;

/**
 *
 * @author DarioF
 */
public class FunctionR {

    double u,pi=3.1415926535;
    double q21,q22,q23;
    boolean flagFA;
    MontecarloP mont;
    double rma,asm,lim,tt;
    
    
    
    public FunctionR(double v,double ra,double subm,double Lim,double TT){
        u=v;
        rma= ra;
        asm= subm;
        lim= Lim;
        tt= TT;
        flagFA= false;
    }//
    
    public FunctionR(double v,double q1,double q2,double q3){
        u=v;
        q21= q1;
        q22= q2;
        q23= q3;
        flagFA= true;
    }//
    
    
    
    public synchronized double valuatepol(double[] rtp){
        //double[] rtp t,p,r
        double r=rtp[2],t=rtp[0],p=rtp[1];
        double[] x= new double[3];
        
        x[0]= r*(Math.sin(p))*(Math.cos(t));
        x[1]= r*(Math.sin(p))*(Math.sin(t));
        x[2]= r*Math.cos(p);
        
        if(flagFA) return funA(x[0],x[1],x[2]);
        
        
        return Math.pow(funB(x),2);
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
            
            //xp= xp*x*x;
            //16
            //r= r+(xp/355687428096000.0);
            
            //xp= xp*x*x;
            //18
            //r= r+(xp/121645100408832000.0);
            
            //xp= xp*x*x;
            //20
            //r= r+(xp/51090942171709440000.0);
            
            return r;
        }//if
        
        return Math.sinh(x)/x;
    }//functionF
    
    private synchronized double funA(double q11,double q12,double q13){
        
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
        double r=0,ra,rb,as;
        MontecarloP mont1= new MontecarloP(new FunctionR(u,x[0],x[1],x[2])    );
        
        as= ( (4.0/3.0)*pi )/(asm);
        
        ra=rma;
        
        for(int i=1;i<=tt;++i){
            rb= Math.pow( ((3.0/(4.0*pi))*as)+Math.pow(ra,3) ,1.0/3.0);
            r= r+mont1.integratef(lim, ra, rb,false);
            ra=rb;
        }//for
        
        
        return r;
    }//funB
    
    
}//class