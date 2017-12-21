package grapher.topology.dimension.shape;

import java.awt.Color;
import java.util.ArrayList;

import grapher.topology.dimension.Vector3D;

public class Line3D extends ArrayList<Vector3D> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Color color;

	public Line3D(){
	}//

        public Line3D(Color color){
            this.color= color;
	}//
        
	public Color getColor() {
		return color;
	}//

	public void setColor(Color color) {
		this.color = color;
	}//
	
}//class
