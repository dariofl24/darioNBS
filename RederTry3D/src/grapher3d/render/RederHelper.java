
package grapher3d.render;

import java.util.ArrayList;
import grapher.topology.dimension.shape.Line2D;
import grapher.topology.dimension.shape.Line3D;
import grapher.Proyector2D;
import grapher.topology.dimension.Vector2D;
import grapher.topology.dimension.shape.PixelLine;
import rederizer.entities.Pixel;


public class RederHelper {
    
    
    public static ArrayList<Line2D> get2Dprojection(double phi,double theta,
            double radius,double focus,double x0,double y0,double lpp,double px0,double py0,
            int screenWidth,int screenHeight,ArrayList<Line3D> lines3D){
        
        ArrayList<Line2D> raw2D= new ArrayList<Line2D>();
        Proyector2D proyector= new Proyector2D();
        
        
        //proyector.setVisionParams(theta,phi,radius,focus);
        
        for(Line3D line3d:lines3D){
            raw2D.addAll( proyector.proyectLine(line3d) );
        }//for
        
        ArrayList<Line2D> screenLines2D= new ArrayList<Line2D>();
        Line2D screenline2d;
        
        PixelLine pixelline;
        ArrayList<PixelLine> PixelLines= new ArrayList<PixelLine>();
        
        double px,py;
        
        
        for(Line2D line2d: raw2D){
            
            screenline2d= new Line2D();
            
            for(Vector2D v2d:line2d){
                
                px= ((v2d.getX()-x0)/lpp) + px0;
                py= py0-((v2d.getY()-y0)/lpp);
                
                screenline2d.add(new Vector2D((int)px,(int)py));
            }//for
            
            screenLines2D.add(screenline2d);
        }//for
        
        return screenLines2D;
    }//get2Dprojection
    
    
    
}//class
