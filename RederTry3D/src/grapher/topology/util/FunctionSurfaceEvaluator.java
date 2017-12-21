package grapher.topology.util;

import java.util.ArrayList;

import grapher.topology.dimension.shape.Line3D;
import grapher.topology.function.FunctionSurface;
import grapher.topology.dimension.Vector3D;

public class FunctionSurfaceEvaluator {

	FunctionSurface function;
	
	public FunctionSurfaceEvaluator(FunctionSurface function){
		this.function= function;
	}//
	
	public ArrayList<Line3D> getValues(double xmin,double ymin,double xmax,double ymax,double dx,double dy){
		
		int nx,ny,ix=0,iy=0;
		
		nx=(int) Math.ceil( (xmax-xmin)/dx );
		ny=(int) Math.ceil( (ymax-ymin)/dy );
		
		System.out.println(nx+" ; "+ny);
		
		if(nx <= 0 || ny <= 0) return null;
		
		Vector3D[][] matz= new Vector3D[nx+2][ny+2]; 
		
		Vector3D res;
		
		double x,y;
		
		x= xmin;
		
		while(x <= xmax){
			
			y= ymin;
			iy=0;
			
			while(y <= ymax){
				
				res= this.function.evaluate(x, y);
				System.out.println(ix+","+iy);
				matz[ix][iy]=res;
				
				y+=dy;
				iy+=1;
			}//while
			
			x+=dx;
			ix+=1;
		}//while
		
		ArrayList<Line3D> setRes= new ArrayList<Line3D>();
		Line3D line;
		
		for(int i=0;i<ix;i++){
			
			line= new Line3D();
			
			for(int j=0;j<iy;j++){
				if(matz[i][j]!=null)
				line.add(matz[i][j]);
			}//for
			
			setRes.add(line);
		}//for
		
		
		for(int j=0;j<iy;j++){
			
			line= new Line3D();
			
			for(int i=0;i<ix;i++){
				if(matz[i][j]!=null)
				line.add(matz[i][j]);
			}//for
			setRes.add(line);
		}//for
		
		return setRes;
	}//getValues
	
}//class
