

package intmottry2;

/**
 *
 * @author DarioF
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double rma=0,rmb=1,lim=51000;
        int ts=4;
        //lim= lim*lim*lim;
        
        new MontecarloTM().launch(rma, rmb, ts, lim);
        
        
    }//main 

}//class
