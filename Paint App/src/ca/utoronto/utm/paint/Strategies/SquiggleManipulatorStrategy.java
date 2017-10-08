package ca.utoronto.utm.paint.Strategies;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.PaintPanel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.DrawingCommands.Squiggle;

public class SquiggleManipulatorStrategy implements ShapeManipulatorStrategy{
	PaintModel model;
	PaintPanel panel;
	Squiggle currentSquiggle;
	
	public SquiggleManipulatorStrategy(PaintModel model,PaintPanel panel){
		this.model = model;
		this.panel = panel;
	}


	public void modifyShape(int x, int y) {
		
		currentSquiggle.addPoint(new Point(x,y));
		panel.repaint();

	
	}


	public void createShape(int x, int y) {
		currentSquiggle = new Squiggle();
		currentSquiggle.addPoint(new Point(x,y));	 
		model.addCommand(currentSquiggle);
		
	}

}
