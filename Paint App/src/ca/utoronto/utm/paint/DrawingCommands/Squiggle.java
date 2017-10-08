package ca.utoronto.utm.paint.DrawingCommands;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import ca.utoronto.utm.paint.Point;
/**
 * The Squiggle class contains the code required for drawing squiggle objects
 * in PaintPanel and storing their data in PaintModel.
 */
 
public class Squiggle implements DrawingCommand {

  // The list of points that make up this Squiggle object.
  private ArrayList<Point> points;
  
  public Squiggle() {
    this.points  = new ArrayList<Point>();

  }
  /**
   * Adds a point to the list of points for this Squiggle instance.
   */
  public void addPoint(Point p) {
    this.points.add(p);
  }
  
  /**
   * Returns the list of points for this Squiggle instance.
   * @return list of points for this Squiggle
   */
  public ArrayList<Point> getPoints() {
    return points;
  }

  /**
   * Draws the squiggle on the PaintPanel canvas.
   */
	public void execute(Graphics2D g2d) {  
		    for(int i=0;i<points.size()-1; i++){
	          Point p1=points.get(i);
	          Point p2=points.get(i+1);
	         
	          g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		
	}
	}
  
}
