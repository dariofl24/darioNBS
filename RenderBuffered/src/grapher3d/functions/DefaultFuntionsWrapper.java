
package grapher3d.functions;

import java.util.ArrayList;
import topology.dimension.Vector3D;
import topology.function.FunctionParametric3D;


public class DefaultFuntionsWrapper {
    
    public ArrayList<FunctionParametric3D> getDefaultParametricF(){
        
        ArrayList<FunctionParametric3D> functions= new ArrayList<FunctionParametric3D>();
        
        FunctionParametric3D f1= new FunctionParametric3D() {
            @Override
            public Vector3D evaluate(double p) {
                return new Vector3D(p,1.0d,0);
            }//
        };
        
        FunctionParametric3D f2= new FunctionParametric3D() {
            @Override
            public Vector3D evaluate(double p) {
                return new Vector3D(p,2.0d,0);
            }//
        };
        
        FunctionParametric3D f3= new FunctionParametric3D() {
            @Override
            public Vector3D evaluate(double p) {
                return new Vector3D(p,3.0d,0);
            }//
        };
        
        FunctionParametric3D f4= new FunctionParametric3D() {
            @Override
            public Vector3D evaluate(double p) {
                return new Vector3D(p,4.0d,0);
            }//
        };
        
        functions.add(f1);
        functions.add(f2);
        functions.add(f3);
        functions.add(f4);
        
        return functions;
    }//getDefaultParametricF
    
}//class
