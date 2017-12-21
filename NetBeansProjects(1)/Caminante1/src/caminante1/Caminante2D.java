

package caminante1;

/**
 *
 * @author DarioF
 */
public class Caminante2D {
    
    private int x,y,d=0,a=0;
    private double pdx,pay,k;
    
    /**
     * Construye un caminante
     * @param x0 Posicion inicial en x
     * @param y0 Posicion inicial en y
     * @param PD Probabilidad de dar un paso a la derecha
     * @param PA Probabilidad de dar un paso arriba
     */
    public Caminante2D(int x0,int y0,double PD,double PA){
        x=x0;
        y=y0;
        pdx=PD;
        pay=PA;
    }//
    
    public void camina(){
        
        k= Math.random();//Da un numeto k con P uniformr t.q. 0<k<1.
        
        if(k<pdx){
            x=x+1;
            d=d+1;
        }else{
           x=x-1; 
        }//if-else
        
        k= Math.random();
        
        if(k<pay){
            y=y+1;
            a=a+1;
        }else{
           y=y-1; 
        }//if-else
        
    }//camina
    
    public int posicionx(){
        return x;
    }//posicion
    
    public int posiciony(){
        return y;
    }//posicion
    
    public int totalD(){
        return d;
    }//totalD
    
    public int totalA(){
        return a;
    }//totalD
    
}//class
