package ca.utoronto.utm.paint.DrawingCommands;
import java.awt.*;

import ca.utoronto.utm.paint.PaintPanel;
/**
 * 
 * @author 
 * 
 * This class changes the background of the Paint Panel to a new given color without affecting any of the shape colors.
 *
 */

public class BackgroundChange implements DrawingCommand {
	
	private Color color;
	private PaintPanel paintPanel;
	/**
	 * 
	 * @param color selected from the Pop-Up JColorChooser in the main program
	 * @param paintPanel getting its background changed
	 */
	public BackgroundChange(Color color, PaintPanel paintPanel){
		this.color = color;
		this.paintPanel = paintPanel;
	}
	
	public Color getBackgroundColor() {
	    return color;
	}
	
	/**
	 * Method to apply the new background to the Paint Panel
	 */
	public void execute(Graphics2D g2d) {
		paintPanel.setBackground(color);
		g2d.setBackground(color);
	
	
}
	
}
