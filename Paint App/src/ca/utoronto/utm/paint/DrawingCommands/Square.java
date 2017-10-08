package ca.utoronto.utm.paint.DrawingCommands;

import java.awt.*;

import ca.utoronto.utm.paint.Point;
/**
 * The square class contains the code required for drawing square objects
 * in PaintPanel and storing their data in PaintModel.
 */
public class Square extends Rectangle implements DrawingCommand{

	/**
	 * Constructs a square object with the starting corner and ending corner
	 * 
	 * @param startCorner
	 *            represents the coordinates where the square starts drawing
	 *            from
	 * @param endCorner
	 *            represents the coordinates where the square draws to
	 * @param filled
	 *            a boolean that tells us if the square is filled or not
	 */
	public Square(Point startCorner, Point endCorner, boolean filled) {
		super(startCorner, endCorner, filled);

	}

	public void setEndCorner(Point p){
		
		Point startCorner = super.getStartCorner();
		
		int xDiff = Math.abs(p.getX()-startCorner.getX());
		int yDiff = Math.abs(p.getY()-startCorner.getY());
		int biggestDiff = Math.max(xDiff, yDiff);
		
		int x = startCorner.getX()>p.getX()?startCorner.getX()-biggestDiff:startCorner.getX()+biggestDiff;
		int y = startCorner.getY()>p.getY()?startCorner.getY()-biggestDiff:startCorner.getY()+biggestDiff;
		
		super.setEndCorner(new Point(x,y));
		
	}
	  /**
	   * Draws the Square on the PaintPanel canvas.
	   */
	public void execute(Graphics2D g2d){

		int x = super.getSmallestX();
		int y = super.getSmallestY();
		int length = getLength();
		
	    // set style of shape
		if(super.getFilled()){
			g2d.fillRect(x, y, length, length);
		}else{
			g2d.drawRect(x, y, length, length);
	}
	}
}
