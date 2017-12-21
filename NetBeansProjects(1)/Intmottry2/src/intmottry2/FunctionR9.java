

package intmottry2;

/**
 *
 * @author DarioF
 */
public class FunctionR9 {

    public synchronized double valuate(double[]x1,double[]x2,double[]x3){
        //double[]x1,double[]x2,double[]x3 R9 single point
            double r=0;
            double a,b,c;
            
            a= 1/((x1[0]*x1[0])+(x1[1]*x1[1])+(x1[2]*x1[2])+1);
            a= Math.sqrt(a);
            
            b= 1/((x2[0]*x2[0])+(x2[1]*x2[1])+(x2[2]*x2[2])+1);
            b= Math.sqrt(b);
            
            c= 1/((x3[0]*x3[0])+(x3[1]*x3[1])+(x3[2]*x3[2])+1);
            c= Math.sqrt(c);
            
            r=a*b*c;
            
            return r;
        }//valuate
    
    public synchronized double valuatepol(double[][] rpt){
        double[]x1= { rpt[0][0]*(Math.sin(rpt[0][1]))*(Math.cos(rpt[0][2])),
        rpt[0][0]*(Math.sin(rpt[0][1]))*(Math.sin(rpt[0][2])),rpt[0][0]*(Math.cos(rpt[0][1]))};
        
        double[]x2={ rpt[1][0]*(Math.sin(rpt[1][1]))*(Math.cos(rpt[1][2])),
        rpt[1][0]*(Math.sin(rpt[1][1]))*(Math.sin(rpt[1][2])),rpt[1][0]*(Math.cos(rpt[1][1]))};
        
        double[]x3= { rpt[2][0]*(Math.sin(rpt[2][1]))*(Math.cos(rpt[2][2])),
        rpt[2][0]*(Math.sin(rpt[2][1]))*(Math.sin(rpt[2][2])),rpt[2][0]*(Math.cos(rpt[2][1]))};
        
        return 1;
        //return valuate(x1,x2,x3);
    }//valuatepol
    
    
    
    
    
    
}//class
