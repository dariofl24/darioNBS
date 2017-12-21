
package implicit_ev;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Im_evaluator {
    
    Lista_dob<Point> points =new Lista_dob<Point>();
    Lista_dob<Point> aux =new Lista_dob<Point>();
    double tol =0.0001;
    double pass=0.001;
    double min_x=-10, max_x=10;
    double min_y=-10, max_y=10;
    
    public void evaluate(){
        
        double x,y,res;
        double[] paux= new double[3];
        boolean vp= false;
        
        x=min_x;
        
        while(x <= max_x){
 
            y=min_y;           
            
            while(y <= max_y){
                
                res= Math.abs( function(x,y) );
                
                if(res < tol){
                    
                    if(vp){
                        
                        if(res < paux[2]){
                            paux[1]=y;
                            paux[2]=res;
                        }//if
                        
                    }else{
                        paux[0]=x;
                        paux[1]=y;
                        paux[2]=res;
                        
                        vp=true;
                    }//if-vp
                    
                    
                }else{
                    
                    if(vp){
                        vp=false;
                        points.insertarUltimo( new Point(x,paux[1],paux[2]) );
                    }//if
                    
                }//if-else (res < tol)
                
                y+=pass;
            }//while_y
            
            if(vp){
                vp=false;
                points.insertarUltimo( new Point(x,paux[1],paux[2]) );
            }//if
            
            
            x+=pass;
        }//while_x
        
        
        
        System.out.println("Points: "+points.lenght);
        
        try{
            BufferedWriter writer= new BufferedWriter(new FileWriter("point.txt"));
            
            BufferedWriter wx= new BufferedWriter(new FileWriter("px.txt"));
            BufferedWriter wy= new BufferedWriter(new FileWriter("py.txt"));
            
            points.primero();
            
            for(int i=1;i<= points.lenght;i++){
                writer.write( points.elemento().get_string_xyz() );
                writer.newLine();
                
                wx.write(""+points.elemento().get_x());
                wy.write(""+points.elemento().get_y());
                wx.newLine();
                wy.newLine();
                
                points.avanza();
            }//for
            
            wx.close();
            wy.close();
            writer.close();
        }catch(IOException e){
            
        }//try-catch
        
        
        
    }//evaluate
    
    
    private double[] get_minP(){
        
        int i;
        double[] pa;
        double[] pb;
        
        aux.primero();
        pa= aux.elemento().get_point_xyz();
        
        i=2;
        
        while(i<=aux.lenght){
            aux.avanza();
            pb= aux.elemento().get_point_xyz();
            
            if( pb[2]<pa[2] ){
                pa[0]=pb[0];
                pa[1]=pb[1];
                pa[2]=pb[2];    
            }//if
            
            i=i+1;
        }//while
        
        //System.out.println(""+pa[0]+","+pa[1]+","+pa[2]+" *******************");
        
        return pa;
    }//get_minP
    
    private double function(double x0, double y0){
        
        double res;
        
        res= (x0*x0)+(y0*y0)-80;
        
        return res;
    }//function
    
   
}//class
