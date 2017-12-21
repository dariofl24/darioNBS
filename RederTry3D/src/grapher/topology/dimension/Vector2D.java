package grapher.topology.dimension;

public class Vector2D {
	protected double x;
	protected double y;
	
	private double relativeDeep;
	
	public Vector2D(double x,double y){
		this.x=x;
		this.y=y;
	}//
	
	public Vector2D(double x,double y,double relativeDeep){
		this.x=x;
		this.y=y;
		this.relativeDeep=relativeDeep; 
	}//
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Vector2D scalVector(double t){
		return new Vector2D(t*this.x,t*this.y);
	}//scalVector
	
	public double getNormsq(){
		return (x*x)+(y*y);
	}//getNorm
	
	public double getNorm(){
		return Math.sqrt( (x*x)+(y*y));
	}//getNorm

	@Override
	public String toString(){
		return x+","+y;
	}//

	public double getRelativeDeep() {
		return relativeDeep;
	}//

	public void setRelativeDeep(double relativeDeep) {
		this.relativeDeep = relativeDeep;
	}//
	
}//class
