

package intmottry1;

/**
 *
 * @author DarioF
 */
public class FunctionR2 {
    
    
    public synchronized double valuate(double x,double y){
            double r;
            r=(x*x)+(y*y)+1;
            r= 1/(r*r);
            
            return r;
        }//valuate
    
    public synchronized double valuatepol(double r, double t){
        
        return valuate(r*(Math.cos(t)),r*( Math.sin(t)));
    }//valuatepol

}//clas
