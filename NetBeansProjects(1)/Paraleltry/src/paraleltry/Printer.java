

package paraleltry;

/**
 *
 * @author DarioF
 */
public class Printer {
    
    int i=1;

    public synchronized void print(String ps){
        
        System.out.println(i+": "+ps);
        i+=1;
        
    }//print
    
}//
