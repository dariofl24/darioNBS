package grapher.topology.dimension;

public class Vector3D extends Vector2D{
	
	protected double z;
	
	public Vector3D(double x,double y,double z){
		super(x,y);
		this.z=z;
	}//

	public double getZ() {
		return z;
	}
	
	@Override
	public Vector3D scalVector(double t){
		return new Vector3D(t*this.x,t*this.y,t*this.z);
	}//scalVector
	
	@Override
	public double getNormsq(){
		return (x*x)+(y*y)+(z*z);
	}//getNormsq
	
	@Override
	public double getNorm(){
		return Math.sqrt( (x*x)+(y*y)+(z*z)  );
	}//getNorm

	@Override
	public String toString(){
		return x+","+y+","+z;
	}

}//class
