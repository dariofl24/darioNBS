
package grapher3d.functions.axis;

import topology.dimension.Vector3D;
import topology.function.FunctionParametric3D;

public class zminusaxis implements FunctionParametric3D{

    @Override
    public Vector3D evaluate(double p) {
        
       return new Vector3D(0,0,(-1.0*p)); 
    }//
    
}//class
