

package gsltry;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
         System.out.println(now("yyyy.MM.dd"));
         System.out.println(now("dd.MM.yy"));
         System.out.println(now("MM/dd/yy"));
         System.out.println(now("yyyy.MM.dd G 'at' hh:mm:ss z"));
         System.out.println(now("EEE, MMM d, ''yy"));
         System.out.println(now("h:mm a"));
         System.out.println(now("H:mm:ss:SSS"));
         System.out.println(now("H:mm"));
         System.out.println(now("K:mm a,z"));
         System.out.println(now("yyyy.MMMMM.dd GGG hh:mm aaa"));
        
    }//main

    
    public static String now(String dateFormat){
       
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime()); 

    }//now
    
    
}//class
