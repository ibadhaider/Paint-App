package ca.utoronto.utm.paint;

/**
 * The Point class contains the code required to get the x and y coordinate used
 * in other classes
 * 
 */
public class Point {
	int x, y;

	/**
	 * Constructs a Point object with integer x & y values
	 * 
	 * @param x
	 *            An integer value representing the x coordinate of the point
	 * @param y
	 *            An integer value representing the y coordinate of the point
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * A getter method to get the X coordinate
	 * 
	 * @return An integer representing the X coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * A setter method to set the X coordinate to "x"
	 * 
	 * @param x
	 *            An integer value where we want to sent the X coordinate to.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * A getter method to get the Y coordinate
	 * 
	 * @return An integer representing the Y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * A setter method to set the Y coordinate to "y"
	 * 
	 * @param y
	 *            An integer value where we want to set the Y coordinate to.
	 */
	public void setY(int y) {
		this.y = y;
	}

}
