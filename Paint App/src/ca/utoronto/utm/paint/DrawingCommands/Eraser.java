package ca.utoronto.utm.paint.DrawingCommands;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import ca.utoronto.utm.paint.Point;

/**
 * The Eraser class contains the code required for erasing objects from the
 * PaintPanel canvas and storing the data of the eraser objects themselves.
 */
public class Eraser extends Squiggle implements DrawingCommand {

  // The list of points that make up this Eraser object.
  private ArrayList<Point> points;
  
  /**
   * Initializes a new Eraser object, with its associated list of points.
   */
  public Eraser() {
    points = new ArrayList<Point>();
  }
  
  /**
   * Add a point to the list of points associated with this Eraser instance.
   * @param p the point that will be added
   */
  public void addPoint(Point p) {
    points.add(p);
  }
  
  /**
   * Returns the list of points associated with this Eraser instance.
   * @return this eraser's list of points
   */
  public ArrayList<Point> getPoints() {
    return points;
  }
  
  /**
   * Draws the Eraser on the PaintPanel canvas.
   */
  public void execute(Graphics2D g2d) {
    for(int i=0; i<points.size()-1; i++) {
      Point p1 = points.get(i);
      Point p2 = points.get(i+1);
      
      final Color currentColor = g2d.getColor();
      g2d.setColor(g2d.getBackground()); // sets drawing color to color of canvas background
      g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
      g2d.setColor(currentColor); // resets drawing color to what it was before
    }
    
  }

}
