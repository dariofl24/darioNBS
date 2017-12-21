package grapher.topology.function.impl;

import grapher.topology.dimension.Vector3D;
import grapher.topology.function.FunctionSurface;

public class Surface1 implements FunctionSurface {

	@Override
	public Vector3D evaluate(double x, double y) {
		
		double z;
		
		//z= Math.cos( Math.sqrt( (x*x)+(y*y) ) )*Math.exp( Math.sqrt( (x*x)+(y*y) )/10.0 );
		
		z= Math.sin(x+y);
		
		return new Vector3D(x,y,z);
	}//

}//class
