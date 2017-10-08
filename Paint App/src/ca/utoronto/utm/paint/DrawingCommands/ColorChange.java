package ca.utoronto.utm.paint.DrawingCommands;
import java.awt.*;
/**
 * 
 * @author 
 * 
 * This class changes the color of all subsequent shapes in the Paint Program.
 *
 */
public class ColorChange implements DrawingCommand {

	private Color color;
	/**
	 * 
	 * @param color chosen in the PopUp JColorChooser in the main Paint Panel.
	 */
	public ColorChange(Color color){
		this.color = color;
	}
	/**
	 * Method to apply the new chosen color to subsequent shapes
	 */
	public void execute(Graphics2D g2d) {
		g2d.setColor(color);
	}
    public Color getColor() {
        return color;
    }
}
