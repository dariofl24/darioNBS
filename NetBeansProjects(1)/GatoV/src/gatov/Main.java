

package gatov;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
       
        Vplayer vp= new Vplayer(100000);
        int[][] tab={ {0,0,0},
                      {1,-1,0},
                      {-1,0,0}};
        vp.pp1(tab,6,false);
        
        
        
    }//main

}//class
