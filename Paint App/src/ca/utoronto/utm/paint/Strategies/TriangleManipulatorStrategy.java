package ca.utoronto.utm.paint.Strategies;

import java.util.ArrayList;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.PaintPanel;
import ca.utoronto.utm.paint.DrawingCommands.Triangle;

public class TriangleManipulatorStrategy implements ShapeManipulatorStrategy {
	
	PaintModel model;
	PaintPanel panel;
	Triangle currentTriangle;

	
	public TriangleManipulatorStrategy(PaintModel model,PaintPanel panel){
		this.model = model;
		this.panel = panel;
	}

	
	public void createShape(int x, int y) {
		int[] xList = new int[3];
		int[] yList = new int[3];
		xList[0] = x;
		yList[0] = y;
		
	
		currentTriangle = new Triangle(xList,yList,panel.getFilled());
		model.addCommand(currentTriangle);
		
	}

	@Override
	public void modifyShape(int x, int y) {
		int x1 = currentTriangle.getStartCorner().getX();
		int y1 = currentTriangle.getStartCorner().getY();
		
		int xDiff = x-x1;
		int yDiff = y-y1;

		currentTriangle.addPoint(x,y);
		currentTriangle.addPoint(x1-xDiff,y1+yDiff);

		panel.repaint();
}

}