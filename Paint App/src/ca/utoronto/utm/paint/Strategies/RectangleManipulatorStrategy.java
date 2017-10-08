package ca.utoronto.utm.paint.Strategies;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.PaintPanel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.DrawingCommands.Rectangle;

public class RectangleManipulatorStrategy implements ShapeManipulatorStrategy {

	
	PaintModel model;
	PaintPanel panel;
	Rectangle currentRectangle;
	
	public RectangleManipulatorStrategy(PaintModel model,PaintPanel panel){
		this.model = model;
		this.panel = panel;
	}

	
	public void createShape(int x, int y) {
		Point corner = new Point(x,y);
		currentRectangle = new Rectangle(corner,corner,panel.getFilled());
		model.addCommand(currentRectangle);
		
	}

	public void modifyShape(int x, int y) {
	
		currentRectangle.setEndCorner(new Point(x,y));
		panel.repaint();

	
	}






}
