package ca.utoronto.utm.paint.DrawingCommands;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;

import ca.utoronto.utm.paint.Point;
;

/**
 * This class contains the code required for drawing Triangle objects
 * in PaintPanel and storing their data in PaintModel.
 */
 
public class Triangle implements DrawingCommand {

	private int[] xPoints;
	private int[] yPoints;
	private boolean filled;
	Polygon P;
	int i=1;
	
	
	/**
	 * A getter method to get the start corner of the triangle
	 * @return Point representing the start corner
	 */
	public Point getStartCorner(){
		return new Point(xPoints[0],yPoints[0]);
	}
	
	  /**
	   * Initializes a new Triangle object, with its associated list of points.
	   */
	public Triangle(int[] x, int[] y, boolean filled) {
		this.xPoints = x;
		this.yPoints = y;
		this.filled = filled;
	}
	
	/**
	 * A getter method to see if the shape is filled or not
	 * @return A boolean to see if the shape is filled or not
	 */
	public boolean getFilled() {
		return this.filled;
	}
	
	
	/**
	 * Adds point to the list of points to create the triangles
	 * @param x double representing the current x value
	 * @param y double representing the current y value
	 */
	public void addPoint(double x, double y) {
		xPoints[i]=(int) x;
		yPoints[i]=(int) y;
		i++;
		if (i>2){
			i=1;
		}
	}


	

	 /**
	   * Draws the Triangle on the PaintPanel canvas.
	   */
	public void execute(Graphics2D g2d) {

		if (filled) {

		} else {
			//converting the arraylist into a list since polygon takes in a list of int.
			
			g2d.drawPolygon(xPoints,yPoints, 3);

		}

	}

}
