package ca.utoronto.utm.paint.DrawingCommands;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
/**
 * Class used in Command design pattern for stroke thickness
 *
 */
public class StrokeChange implements DrawingCommand {
	int thickness;

	/**
	 * Changes thickness of the stroke
	 * @param thickness integer value to change the thickness 
	 */
	public StrokeChange(int thickness) {
		this.thickness = thickness;
	}

	  /**
	   * Draws the shape/line with this current thickness
	   */
	public void execute(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(thickness));

	}
	public int getCurrentThickness() {
	    return thickness;
	}

}
