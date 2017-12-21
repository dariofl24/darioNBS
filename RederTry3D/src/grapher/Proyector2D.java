package grapher;

import grapher.topology.util.VectorOperations;
import grapher.topology.dimension.shape.Line2D;
import grapher.topology.dimension.shape.Line3D;
import grapher.topology.dimension.Vector3D;
import grapher.topology.dimension.Vector2D;
import java.awt.Color;
import java.util.ArrayList;


public class Proyector2D {

	private double tt,pp,rad,focus;
	private final double RAY_ANGLE_LIM=0.001;
	private boolean vpSet= false;
	private Vector3D radVec,focusVec,Ux,Uy,Y;
	private double maxDeep;
        private double minDeep;
	
        double x0, y0;
        double lpp, px0, py0;
        int screenWidth, screenHeight;
        
	public void setVisionParams(double tt,double pp,double rad,double focus,
                double x0,double y0,double lpp,double px0,double py0,int screenWidth,int screenHeight){
		this.tt=tt;
		this.pp=pp;
		this.rad=rad;
		this.focus=focus;
		
		this.vpSet= true;
		
		Ux= this.getUx(); 
		Uy= this.getUy(); 
		radVec= this.getRad();
		focusVec= this.getFocus();
		
                // Screen params
                
                this.x0= x0;
                this.y0= y0;
                this.lpp= lpp;
                this.px0= px0;
                this.py0= py0;
                this.screenWidth= screenWidth;
                this.screenHeight= screenHeight;
                
                // Screen params
                
		this.maxDeep=0;
                this.minDeep=0;
	}//setVisionParams
	
	public ArrayList<Line2D> proyectLine(Line3D line3D){
		
		if(!this.vpSet) return null;
		
		Line2D rays= new Line2D();
		ArrayList<Line2D> ScreenVSet= new ArrayList<Line2D>();
		
		ArrayList<Double> deeps= new ArrayList<Double>();
		
		ScreenVSet.add(rays);
		
		double t,yPf,Ynorm;
		double fVecSNorm= focusVec.getNormsq();
		
		// Gets the raw rays
		for(Vector3D X:line3D){
			
			Y= VectorOperations.sustract(radVec,X);
			
			Ynorm= Y.getNorm();
			yPf=VectorOperations.scalarProduct(Y, focusVec);
			
			if(yPf > this.RAY_ANGLE_LIM){
				
				t = fVecSNorm/yPf;	
				deeps.add(Ynorm);
                                
				rays.add( this.get2DScreenVec(VectorOperations.sustract(Y.scalVector(t),focusVec),Ynorm));
				
				if(this.maxDeep < Ynorm) this.maxDeep= Ynorm;
                                if(this.minDeep > Ynorm) this.minDeep= Ynorm;
				
			}else{
				
				if(rays.size()>0){
					rays= new Line2D();
					ScreenVSet.add(rays);
				}//if
				
			}//if - else
			
		}//for
		
                
                
		return ScreenVSet;
	}//proyectLine
	
        private Vector2D get2DScreenVec(Vector3D pproy3d,double deep){
            
            double rx,ry;
            double px,py;
            
            rx=(-1.0)* VectorOperations.scalarProduct(pproy3d,Ux);
            ry=(-1.0)*VectorOperations.scalarProduct(pproy3d,Uy);
            
            px= ((rx-x0)/lpp) + px0;
            py= py0-((ry-y0)/lpp);
            
            return new Vector2D((int)px,(int)py,deep);
        }//
	
	private Vector3D getFocus(){
		double x,y,z;
		
		x= (0.5)*focus*( Math.sin(pp+tt) + Math.sin(pp-tt) );
		y= (0.5)*focus*( Math.cos(pp-tt) - Math.cos(pp+tt) );
		z= focus*Math.cos(pp);
		
		return new Vector3D(x,y,z);
	}//getFocus
	
	private Vector3D getRad(){
		double x,y,z;
		
		x= (0.5)*rad*( Math.sin(pp+tt) + Math.sin(pp-tt) );
		y= (0.5)*rad*( Math.cos(pp-tt) - Math.cos(pp+tt) );
		z= rad*Math.cos(pp);
		
		return new Vector3D(x,y,z);
	}//getRad
	
	private Vector3D getUx(){
		double x,y;
		
		x= (-1)*Math.sin(tt);
		y= Math.cos(tt);
		
		return new Vector3D(x,y,0);
	}//getUx
	
	private Vector3D getUy(){
		double x,y,z;
		
		x=(-0.5)*( Math.cos(pp+tt) + Math.cos(pp-tt) );
		y=(-0.5)*( Math.sin(tt+pp) + Math.sin(tt-pp) );
		z= Math.sin(pp);
		
		return new Vector3D(x,y,z);
	}//getUy

	public double getMaxDeep(){
		return maxDeep;
	}//
        
        public double getMinDeep(){
            return minDeep;
        }//
	
}//class
