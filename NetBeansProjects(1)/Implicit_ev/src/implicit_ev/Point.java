
package implicit_ev;


public class Point {
    
    private double x,y,z;
    private boolean val;
    
    public Point(){
       x=0;
       y=0;
       z=0;
       val=false;
    }//0
    
    public Point(double x0,double y0,double z0){
        x=x0;
        y=y0;
        z=z0;
        val=true;
    }//C-1
    
    public boolean valid(){
        return val;
    }//valid
    
    public void set(double x0,double y0,double z0){
        x=x0;
        y=y0;
        z=z0;
        val=true;
    }//set
    
    public double get_x(){
        return x;
    }//get_x
    
    public double get_y(){
        return y;
    }//get_x
    
    public double get_z(){
        return z;
    }//get_x
    
    public double[] get_point_xy(){
        double[] point={x,y};
        return point;
    }//point
    
    public double[] get_point_xyz(){
        double[] point={x,y,z};
        return point;
    }//point
    
    public String get_string_xy(){
        if(val){
        return (""+x+","+y);
        }//if
        
        return null;
    }//get_string
    
    public String get_string_xyz(){
        if(val){
        return (""+x+","+y+","+z);
        }//if
        
        return null;
    }//get_string
    
}//class
