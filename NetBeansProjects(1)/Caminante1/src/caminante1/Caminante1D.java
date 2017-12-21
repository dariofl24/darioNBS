

package caminante1;

/**
 *
 * @author DarioF
 */
public class Caminante1D {
    
    private int x,d=0;
    private double pd,k;
    
    /**
     * Construye un caminante
     * @param x0 Posicion inicial.
     * @param PD Probabilidad de un paso a la derecha.
     */
    public Caminante1D(int x0,double PD){
        x=x0;
        pd=PD;
    }//
    
    public void camina(){
        
        k= Math.random();//Da un numeto k con P uniformr t.q. 0<k<1.
        
        if(k<pd){
            x=x+1;
            d=d+1;
        }else{
           x=x-1; 
        }//if-else
        
    }//camina
    
    public int posicionx(){
        return x;
    }//posicion
    
    public double probder(){
        return pd;
    }//probder
    
    public int totalD(){
        return d;
    }//totalD
    
   
    
}//class
