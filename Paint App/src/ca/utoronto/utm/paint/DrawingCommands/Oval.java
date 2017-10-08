package ca.utoronto.utm.paint.DrawingCommands;

import java.awt.Graphics2D;

import ca.utoronto.utm.paint.Point;
/**
 * This class contains the code required for drawing Oval objects
 * in PaintPanel and storing their data in PaintModel.
 */
 
public class Oval implements DrawingCommand{
	
	private Point centre;
	private int xradius;
	private int yradius;
	private boolean filled;
	
	
	public Oval(Point centre, int xradius,int yradius, boolean filled) {
		this.centre = centre;
		this.xradius = xradius;
		this.yradius = yradius;
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
	 * A getter method to get the x radius
	 * 
	 * @return An integer represent the radius of the circle
	 */

	public int getxRadius() {
		return xradius;
	}
	
	/**
	 * A setter method to set the x radius of the circle
	 * 
	 * @param radius
	 *            An integer value representing the radius
	 */
	public void setxRadius(int xradius) {
		this.xradius = xradius;
	}
	/**
	 * A getter method to get the  y radius
	 * 
	 * @return An integer represent the radius of the circle
	 */

	public int getyRadius() {
		return yradius;
	}
	
	/**
	 * A setter method to set the y radius of the circle
	 * 
	 * @param radius
	 *            An integer value representing the radius
	 */
	public void setyRadius(int yradius) {
		this.yradius = yradius;
	}

	/**
	   * Draws the Oval on the PaintPanel canvas.
	   */
	@Override
	public void execute(Graphics2D g2d) {
		// Multiply the diameter by 2 so the outline of the circle is where
		// out mouse pointer is.
		int xdiameter = xradius*2;
		int ydiameter = yradius*2;

		// Since the Oval is inside a rectangle, to get (x,y) coordinates to
		// be in the middle of the circle we have to displace the starting
		// positions by half the width and length of the rectangle
		int x = centre.getX() - (xdiameter / 2);
		int y = centre.getY() - (ydiameter / 2);

		if(filled){
			g2d.fillOval(x,y,xdiameter,ydiameter);
		}else{

		g2d.drawOval(x, y, xdiameter, ydiameter);

		
	}
}
}
