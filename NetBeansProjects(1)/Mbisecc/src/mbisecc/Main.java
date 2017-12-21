

package mbisecc;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        double a=0.1,b=1.5;
        double lim=2*Double.MIN_VALUE;
        double m;
        
        if(a>b){
            System.out.println("1");
            return;
        }//if
        
        if(fun(a)*fun(b)>=0){
            System.out.println("2");
            System.out.println(fun(a));
            System.out.println(fun(b));
            return;
        }//if
        
        m=(a+b)/2;
        
        System.out.println(fun(a));
        System.out.println(fun(b));
        System.out.println("fun= "+fun(m));
        
        while( Math.abs(fun(m)) >lim ){
            
            if( (fun(a)*fun(m))<0 ){
                b=m;
                System.out.println("b= "+b);
            }else{
                
                if( (fun(m)*fun(b))<0 ){
                    a=m;
                    System.out.println("a= "+a);
                }//if
                    
            }//if-else
            
            m=(a+b)/2.0;
            System.out.println("fun= "+fun(m)+" ; m= "+m);
        }//while
        
        System.out.println("------------------------------------------------");
        System.out.println("\n"+"Raiz: m= "+m );
        System.out.println("fun= "+fun(m));
        
        
    }//main
    
    public static double fun(double x){
        
        double a=0,b=0.8,t=0.025;
        
        
        return Math.tanh( (1/t)*(a+ (b*x) ) ) - x;
    }//fun

}//class
