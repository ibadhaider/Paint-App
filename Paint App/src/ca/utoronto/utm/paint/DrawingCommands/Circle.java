package ca.utoronto.utm.paint.DrawingCommands;

import java.awt.*;

import ca.utoronto.utm.paint.Point;

/**
 * This class contains the code required for drawing Circle objects
 * in PaintPanel and storing their data in PaintModel.
 */
 
public class Circle implements DrawingCommand {

	
	private Point centre;
	private int radius;
	private boolean filled;

	/**
	 * Constructs a circle with the centre point, radius, colour and filled.
	 * 
	 * @param centre
	 *            Point representing the starting point of the circle
	 * @param radius
	 *            Integer representing the current radius of the circle
	 * @param color
	 *            of the circle
	 * @param filled
	 *            a boolean that tells us if the circle is filled or not
	 * @param thickness
	 * 			  a int which tells use how thick the shape outline is
	 */
	
	public Circle(Point centre, int radius, boolean filled) {
		this.centre = centre;
		this.radius = radius;
		this.filled = filled;
	}



	/**
	 * A getter method to get the centre
	 * 
	 * @return A Point where the centre starts from
	 */
	public Point getCentre() {

		return centre;
	}

	/**
	 * A Setter method to set the centre
	 * 
	 * @param centre
	 *            The point where the centre starts from
	 */

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	/**
	 * A getter method to get the radius
	 * 
	 * @return An integer represent the radius of the circle
	 */

	public int getRadius() {
		return radius;
	}
	
	/**
	 * A setter method to set the radius of the circle
	 * 
	 * @param radius
	 *            An integer value representing the radius
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	   * Draws the Circle on the PaintPanel canvas.
	   */
	public void execute(Graphics2D g2d) {
		// Multiply the diameter by 2 so the outline of the circle is where
		// out mouse pointer is.
		int diameter = radius*2;

		// Since the Oval is inside a rectangle, to get (x,y) coordinates to
		// be in the middle of the circle we have to displace the starting
		// positions by half the width and length of the rectangle
		int x = centre.getX() - (diameter / 2);
		int y = centre.getY() - (diameter / 2);

		if(filled){
			g2d.fillOval(x,y,diameter,diameter);
		}else{

		g2d.drawOval(x, y, diameter, diameter);

		
	}
	
	}
}
