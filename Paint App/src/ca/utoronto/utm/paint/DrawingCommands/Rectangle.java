package ca.utoronto.utm.paint.DrawingCommands;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import ca.utoronto.utm.paint.Point;

/**
 * The rectangle class contains the code required for drawing rectangle objects
 * in PaintPanel and storing their data in PaintModel.
 */

public class Rectangle implements DrawingCommand {
	private Point startCorner;
	private Point endCorner;
	private boolean filled;

	/**
	 * Constructs a Rectangle object with the starting corner and end corner.
	 * 
	 * @param startCorner
	 *            represents the coordinates where the rectangle starts drawing
	 *            from
	 * @param endCorner
	 *            represents the coordinates where the rectangle draws to
	 * @param color
	 *            colour of the rectangle
	 * @param filled
	 *            a boolean that tells us if the rectangle is filled or not
	 * @param thickness
	 *            a int which tells use how thick the shape outline is
	 */
	public Rectangle(Point startCorner, Point endCorner, boolean filled) {
		this.startCorner = startCorner;
		this.endCorner = endCorner;

		this.filled = filled;

	}

	/**
	 * A getter method to check if the rectangle is filled in or not
	 * 
	 * @return a boolean that tells us if the rectangle is filled in or not
	 */
	public boolean getFilled() {
		return this.filled;
	}

	/**
	 * A getter method to get the corner where the rectangle draws from.
	 * 
	 * @return the point of the starting corner
	 */
	public Point getStartCorner() {
		return startCorner;
	}

	/**
	 * A setter method to set the coordinates where the rectangle starts drawing
	 * from.
	 * 
	 * @param startCorner
	 *            A point where the rectangle starts drawing from
	 */
	public void setStartCorner(Point startCorner) {
		this.startCorner = startCorner;
	}

	/**
	 * A getter method to get the coordinates where the rectangle draws to.
	 * 
	 * @return the point of the ending corner
	 */
	public Point getEndCorner() {
		return endCorner;
	}

	/**
	 * A setter method to set the coordinates where the rectangle ends drawing
	 * to.
	 * 
	 * @param endCorner
	 *            A point where the rectangle draws to.
	 */
	public void setEndCorner(Point endCorner) {
		this.endCorner = endCorner;
	}

	/**
	 * A getter method to get the smallest X value between the starting corner
	 * and ending corner.
	 * 
	 * @return the smallest x value between start and end corner
	 */
	public int getSmallestX() {
		return Math.min(startCorner.getX(), endCorner.getX());
	}

	/**
	 * A getter method to get the smallest Y value between the starting corner
	 * and ending corner.
	 * 
	 * @return the smallest y value between start and end corner
	 */
	public int getSmallestY() {
		return Math.min(startCorner.getY(), endCorner.getY());
	}

	/**
	 * A getter method to get the height of the rectangle
	 * 
	 * @return the height of the rectangle
	 */
	public int getHeight() {
		return Math.abs(endCorner.getY() - startCorner.getY());
	}

	/**
	 * A getter method to get the length of the rectangle
	 * 
	 * @return the length of the rectangle
	 */
	public int getLength() {
		return Math.abs(endCorner.getX() - startCorner.getX());
	}

	/**
	 * Draws the Rectangle on the PaintPanel canvas.
	 */
	public void execute(Graphics2D g2d) {
		int x = getSmallestX();
		int y = getSmallestY();
		int length = getLength();
		int height = getHeight();

		if (filled) {
			g2d.fillRect(x, y, length, height);
		} else {
			g2d.drawRect(x, y, length, height);

		}

	}

}
