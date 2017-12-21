

package intmottry1;

/**
 *
 * @author DarioF
 */
public class Iboxt {
    private double sum=0,lims;
    private int turn=0,maxTh;
    private boolean limiter=false;
    
    public Iboxt(){
        sum=0;
        turn=0;
    }//
   
   
    public synchronized int sum(double s){
        
        sum= sum +s;
        turn=turn+1;
        
        return turn;
        
    }//sum
    
    public synchronized double gettotal(){
        return sum;
    }//gettotal
    
}//class
