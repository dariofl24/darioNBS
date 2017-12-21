
package javaapplication1;

/**
 *
 * @author Dario
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String s1;
        String[] ss= new String[10];
        
        s1="0123456789";
        
        System.out.println( s1 );
        System.out.println( s1.substring(2) );
        System.out.println( s1.substring(2,7) );
        
        System.out.println( s1.indexOf("3") );
        System.out.println( s1.indexOf(" ") );
        
        System.out.println( s1.charAt(0) );
        System.out.println( s1.charAt(4) );
        System.out.println( s1.charAt(9) );
        
        System.out.println( ss[1] );
        
        String c= "v#'alido";
        
        System.out.println( c );
        c=c.replace("#'a","á");
        System.out.println( c );
                
                
        
    }//main
}//class
