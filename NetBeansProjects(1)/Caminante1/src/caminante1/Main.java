

package caminante1;

/**
 *
 * @author DarioF
 */
public class Main {

    
    public static void main(String[] args) {
        
        Caminante1D[] cam1= new Caminante1D[10000];//Arreglo de 1000 caminantes
        
        
        for(int i=0;i<10000;++i){
            cam1[i]=new Caminante1D(0,0.5); // caminantes con igual probabilidad 
            
        }//for
        
        for(int t=1;t<=10000;++t){
            
            for(int i=0;i<10000;++i){
                cam1[i].camina();
            }//for
            
            if(t==10000){
                histograma(cam1);
            }//if
            
        }//for
        
    }//main
    
    
    public static double PosicionPromx(Caminante1D[] cam){
        
        double sum=0;
        double prom;
        
        for(int i=0;i<cam.length;++i){
            sum=sum+cam[i].posicionx();
        }//for
        
        prom= sum/cam.length;
        
        return prom;
    }//PosicionPromx
    
   
    
    public static double Varianzax(Caminante1D[] cam){
        double sum=0;
        double prom=PosicionPromx(cam),var;
        
        for(int i=0;i<cam.length;++i){
            sum=sum+((cam[i].posicionx()-prom)*(cam[i].posicionx()-prom));
        }//for
        
        var= sum/cam.length;
        
        return var;
    }//varianzax
    
    public static void histograma(Caminante1D[] cam){
        
        int min=cam[0].posicionx(),max=cam[0].posicionx(),sum=0;
        int[] hist;
        
        for(int i=1;i<cam.length;++i){
            
            if(cam[i].posicionx() < min) min=cam[i].posicionx();
            if(max < cam[i].posicionx()) max=cam[i].posicionx();
            
        }//for
        
        hist= new int[max-min+1];
        
        for(int j=0;j<cam.length;++j){
            hist[cam[j].posicionx()-min]+=1;
        }//for
        
        System.out.println("min: "+min);
        System.out.println("max: "+max);
        
        for(int k=0;k<hist.length;++k)
            sum=sum+hist[k];
        
        System.out.println("sum: "+sum);
        
        for(int k=0;k<hist.length;++k){
            System.out.println( 100*((double)hist[k]/(double)sum) );
        }//for
        
    }//histograma
    

}//class
