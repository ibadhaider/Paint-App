package ca.utoronto.utm.paint.Strategies;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.PaintPanel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.DrawingCommands.Square;

public class SquareManipulatorStrategy implements ShapeManipulatorStrategy {
	PaintModel model;
	PaintPanel panel;
	Square currentSquare;
	
	public SquareManipulatorStrategy(PaintModel model,PaintPanel panel){
		this.model = model;
		this.panel = panel;
	}


	public void modifyShape(int x, int y) {
		
		currentSquare.setEndCorner(new Point(x,y));
		panel.repaint();

	
	}


	public void createShape(int x, int y) {
		Point corner = new Point(x,y);
		currentSquare = new Square(corner,corner,panel.getFilled());
		model.addCommand(currentSquare);
		
	}

}
