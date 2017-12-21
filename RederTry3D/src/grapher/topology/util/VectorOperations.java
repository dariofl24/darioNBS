package grapher.topology.util;

import grapher.topology.dimension.Vector3D;

public class VectorOperations {

	public static Vector3D add(Vector3D A,Vector3D B){
		
		return new Vector3D(A.getX()+B.getX(),A.getY()+B.getY(),A.getZ()+B.getZ());
	}//add
	
	/**
	 * Performs A - B operation
	 * @param A
	 * @param B
	 * @return
	 */
	public static Vector3D sustract(Vector3D A,Vector3D B){
		
		return new Vector3D(A.getX()-B.getX(),A.getY()-B.getY(),A.getZ()-B.getZ());
	}//add
	
	public static double scalarProduct(Vector3D A,Vector3D B){
		
		return (A.getX()*B.getX()) + (A.getY()*B.getY())+(A.getZ()*B.getZ());
	}//scalarProduct
	
	public static double getDistance(Vector3D A,Vector3D B){
		
		double x,y,z;
		
		x=A.getX()-B.getX();
		y=A.getY()-B.getY();
		z=A.getZ()-B.getZ();
		
		return Math.sqrt( (x*x)+(y*y)+(z*z)  );
	}//
	
}//class
