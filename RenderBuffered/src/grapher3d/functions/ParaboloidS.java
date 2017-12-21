
package grapher3d.functions;

import topology.dimension.Vector3D;
import topology.function.FunctionSurface;

/**
 *
 * @author Dario
 */
public class ParaboloidS implements FunctionSurface{

    @Override
    public Vector3D evaluate(double x, double y) {
        
        double z;
        
        z= Math.pow((x/5),2.0) - Math.pow((y/5),2.0);
        
        return new Vector3D(x,y,z);
    }//
    
}//class
