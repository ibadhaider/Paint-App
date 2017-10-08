package ca.utoronto.utm.paint.DrawingCommands;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import ca.utoronto.utm.paint.Point;


/**
 * This class contains the code required for drawing Polyline objects
 * in PaintPanel and storing their data in PaintModel.
 */

public class Polyline implements DrawingCommand {
	/**
	 * Constructs a Polyline object with a start point and end point.
	 * 
	 * @param StartPoint
	 *            The point where the polyline starts drawing from
	 * @param EndPoint
	 *            The point where the polyline draws up till

	 */
	private Point StartPoint;
	private Point EndPoint;

	public Polyline(Point StartPoint, Point EndPoint) {
		this.StartPoint = StartPoint;
		this.EndPoint = EndPoint;


	}

	/**
	 * A setter method to set the starting point of the polyline
	 * 
	 * @param StartPoint
	 *            represents the starting point of the polyline
	 */

	public void setStartPoint(Point StartPoint) {
		this.StartPoint = StartPoint;

	}
	/**
	 * A setter method to set the ending point of the polyline.
	 * 
	 * @param EndPoint
	 *            represents the ending point of the polyline
	 */
	public void setEndPoint(Point EndPoint){
		this.EndPoint = EndPoint;
	}
	/**
	 * A getter method to get the point where the polyline starts from.
	 * 
	 * @return the starting point of the polyline
	 */
	public Point getStartPoint() {
		return this.StartPoint;
	}

	/**
	 * A getter method to get the point where the polyline ends at.
	 * 
	 * @return the ending point of the polyline
	 */
	public Point getEndPoint() {
		return this.EndPoint;

	}


	/**
	   * Draws the Polyline on the PaintPanel canvas.
	   */
	public void execute(Graphics2D g2d) {
        // set style of shape
	
		g2d.drawLine(StartPoint.getX(), StartPoint.getY(), EndPoint.getX(), EndPoint.getY());
			
		
	}
	

}
