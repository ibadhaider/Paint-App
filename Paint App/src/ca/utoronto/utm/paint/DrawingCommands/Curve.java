package ca.utoronto.utm.paint.DrawingCommands;

import java.awt.Graphics2D;

import ca.utoronto.utm.paint.Point;

/**
 * The Curve class supplies the data required for drawing Curve objects on the
 * PaintPanel and storing their data in PaintModel.
 */
public class Curve implements DrawingCommand {
  private Point initialPoint;
  private Point endPoint;
  private int x; // the x value of the origin of the enclosing rectangle
  private int y; // the y value of the origin of the enclosing rectangle
  private int width; // the width of the enclosing rectangle
  private int height; // the height of the enclosing rectangle
  private int startAngle; // the initial departure angle of the curve
  private final int arcAngle = 90; // the extent of the curve that is drawn
  
  
  /**
   * Initializes a new Curve  object, with its associated list of points.
   */
  public Curve(Point initialPoint, Point endPoint) {
    this.initialPoint = initialPoint;
    this.endPoint = endPoint;
  }
  
  /**
   * A setter method to get the initial point of the curve
   * @param initialPoint A Point representing the coordinates of the initial point 
   */
  public void setInitialPoint(Point initialPoint) {
    this.initialPoint = initialPoint;
  }
  
  /**
   *  A getter method to get the initial point of the curve
   * @return The Point representing the initial point
   */
  public Point getInitialPoint() {
    return initialPoint;
  }
  
  /**
   * A setter method to get the end point of the curve
   * @param initialPoint A Point representing the coordinates of the end point 
   */
  public void setEndPoint(Point endPoint) {
    this.endPoint = endPoint;
  }
  
  /**
   *  A getter method to get the end point of the curve
   * @return The Point representing the end point
   */
  public Point getEndPoint() {
    return endPoint;
  }
  
  @Override
  /**
   * Draws the curve on the PaintPanel canvas.
   */
  public void execute(Graphics2D g2d) {
    startAngle = this.getStartAngle();
    x = this.getOriginXValue(startAngle);
    y = this.getOriginYValue(startAngle);
    width = Math.abs(initialPoint.getX() - endPoint.getX()) * 2;
    height = Math.abs(initialPoint.getY() - endPoint.getY()) * 2;
    g2d.drawArc(x, y, width, height, startAngle, arcAngle);
  }

  /**
   * Determines the width of the curve's enclosing rectangle, to be used as a 
   * parameter value in execute() above.
   * @param startAngle the initial angle of the curve
   * @return the x value of the rectangle's origin
   */
  public int getOriginXValue(int startAngle) {
    int result;
    if(startAngle == 0) { result = 2*initialPoint.getX() - endPoint.getX(); } 
    else if(startAngle == 90) { result = initialPoint.getX(); } 
    else if(startAngle == 180) { result = endPoint.getX(); } 
    else { result = 2*endPoint.getX() - initialPoint.getX(); }
    return result;
  }
  
  /**
   * Determines the width of the curve's enclosing rectangle, to be used as a 
   * parameter value in execute() above.
   * @param startAngle the initial angle of the curve
   * @return the y value of the rectangle's origin
   */
  public int getOriginYValue(int startAngle) {
    int result;
    if(startAngle == 0) { result = initialPoint.getY(); } 
    else if(startAngle == 90) { result = endPoint.getY(); } 
    else if(startAngle == 180) { result = 2*endPoint.getY() - initialPoint.getY(); } 
    else { result = 2*initialPoint.getY() - endPoint.getY(); }
    return result;
  }
  
  /**
   * Determines the departure angle of the curve from the initial point, which
   * depends on the relative X and Y coordinate positions of initialPoint and
   * endPoint. This information is then also used to determine the values of
   * parameters x and y for drawArc() in the execute() method above.
   * @return the starting angle of this curve
   */
  public int getStartAngle() {
    int result;
    if(initialPoint.getX() <= endPoint.getX()) {
      result = (initialPoint.getY() <= endPoint.getY()) ? 0 : 90;
    } else {
      result = (initialPoint.getY() <= endPoint.getY()) ? 270 : 180;
    }
    return result;
  }
  
}
