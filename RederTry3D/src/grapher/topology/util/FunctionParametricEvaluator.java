package grapher.topology.util;


import grapher.topology.function.FunctionParametric3D;
import grapher.topology.dimension.shape.Line3D;

public class FunctionParametricEvaluator {

	private FunctionParametric3D function;
	
	public FunctionParametricEvaluator(FunctionParametric3D function){
		this.function=function;
	}//
	
	public Line3D getValues(double pi,double pf,double dp){
		
		Line3D values = new Line3D();
		double p=pi;
		
		while(p<=pf){
			values.add( this.function.evaluate(p) );
			p+=dp;
		}//while
		
		return values;
	}//

	
}//class
