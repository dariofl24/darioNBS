
package grapher3d.functions.axis;

import topology.dimension.Vector3D;
import topology.function.FunctionParametric3D;

public class zplusaxis implements FunctionParametric3D{

    @Override
    public Vector3D evaluate(double p) {
        
        return new Vector3D(0,0,p);
    }//
    
}//class
