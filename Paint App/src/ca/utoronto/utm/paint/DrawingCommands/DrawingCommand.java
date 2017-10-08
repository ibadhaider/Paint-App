package ca.utoronto.utm.paint.DrawingCommands;

import java.awt.Graphics2D;
/**
 * An interface for Command design pattern.
 */
public interface DrawingCommand {
	public void execute(Graphics2D g2d);
}
