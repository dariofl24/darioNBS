package grapher.topology.dimension.shape;

import java.awt.Color;
import java.util.ArrayList;

import grapher.topology.dimension.Vector2D;

public class Line2D extends ArrayList<Vector2D> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Color color;
	
	public Line2D(){
	}//

	public Color getColor() {
		return color;
	}//

	public void setColor(Color color) {
		this.color = color;
	}//
	
}//class