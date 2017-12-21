package grapher.topology.function.impl;

import grapher.topology.function.FunctionParametric3D;
import grapher.topology.dimension.Vector3D;

public class Function1 implements FunctionParametric3D{

	@Override
	public Vector3D evaluate(double p) {
		
		double x,y,z;
		double R=3,r=1,a=8,m;
		
		m=R+(r*Math.cos(a*p));
		
		x=m*Math.cos(p);
		y=m*Math.sin(p);
		z=r*Math.sin(a*p);
		
		return new Vector3D(x,y,z);
	}//evaluate

	

}//class
