package ca.utoronto.utm.paint.DrawingCommands;
import javax.swing.*;

import ca.utoronto.utm.paint.PaintPanel;
import ca.utoronto.utm.paint.Point;

import java.awt.*;
import java.awt.Graphics2D;
/**
 * Class used in Command design pattern to have text input
 *
 */
public class TextInput implements DrawingCommand{
	private Point beginning;
	private PaintPanel panel;
	private String str;
	
	
	  /**
	   * Initializes a new TextInput object, with its associated list of points.
	   */
	public TextInput(Point beginning,PaintPanel panel,String str){
		this.beginning = beginning;
		this.panel=panel;
		if (str==null){
			this.str="";
		}else{
		this.str=str;
		}
	}
	
	/**
	 * A getter method to get the beginning point of the text
	 * @return a Point representing the beginning coordinates of the text.
	 */
	public Point getBeginning(){
		return beginning;
	}
	
	/**
	 * A setter method to set the beginning of where the text input starts
	 * @param beginning A Point where the text starts writing.
	 */
	public void setBeginning(Point beginning){
		this.beginning = beginning;
	}
	
	 /**
	   * Draws the Text input on the PaintPanel canvas.
	   */
	public void execute(Graphics2D g2d){
		int x = beginning.getX();
		int y = beginning.getY();
		g2d.drawString(str, x, y);
	
	}
	
	
}
