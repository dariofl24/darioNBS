
package grapher3d.functions.axis;

import topology.dimension.Vector3D;
import topology.function.FunctionParametric3D;

public class xminusaxis implements FunctionParametric3D{

    @Override
    public Vector3D evaluate(double p) {
        
        return new Vector3D((-1.0*p),0,0);
    }//
    
    
    
}//class
