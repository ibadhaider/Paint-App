package ca.utoronto.utm.paint.Strategies;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.PaintPanel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.DrawingCommands.Circle;

public class CircleManipulatorStrategy implements ShapeManipulatorStrategy {
	PaintModel model;
	PaintPanel panel;
	Circle currentCircle;
	
	public CircleManipulatorStrategy(PaintModel model,PaintPanel panel){
		this.model = model;
		this.panel = panel;
	}


	public void modifyShape(int x, int y) {
		
		// Finds the X distance starting from start to end
		double Xdistance = Math.abs((currentCircle.getCentre().getX() - x));
		// Finds the Y distance starting from start to end
		double Ydistance = Math.abs((currentCircle.getCentre().getY() - y));
		// Finds the length created by these two points (Radius)
		int radius = (int) Math.sqrt((Xdistance * Xdistance) + (Ydistance * Ydistance));
		currentCircle.setRadius(radius);
		panel.repaint();

	
	}


	public void createShape(int x, int y) {
		Point centre = new Point(x, y);
		Circle circle = new Circle(centre, 0,panel.getFilled());
		model.addCommand(circle);
		currentCircle = circle;
		
	}


	

}
