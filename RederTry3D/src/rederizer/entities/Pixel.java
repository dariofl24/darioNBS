
package rederizer.entities;

import java.awt.Color;


public class Pixel {
   
    private Color color;
    private int px;
    private int py;
    private double relativeDeep;
    
    public Pixel(Color color,int px,int py){
       this.color= color;
       this.px=px;
       this.py=py;
    }//

    public Color getColor() {
        return color;
    }

    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }

    public double getRelativeDeep() {
        return relativeDeep;
    }

    public void setRelativeDeep(double relativeDeep) {
        this.relativeDeep = relativeDeep;
    }
    
    public boolean equals(Pixel pixel){
        
        if(pixel.px != this.px) return false;
        
        if(pixel.py != this.py) return false;
        
        if(pixel.getColor().getBlue()!=this.color.getBlue()) return false;
        
        if(pixel.getColor().getGreen()!=this.color.getGreen()) return false;
        
        if(pixel.getColor().getRed()!=this.color.getRed()) return false;
        
        
        return true;
    }//
    
}//class
