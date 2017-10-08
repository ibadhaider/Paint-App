package ca.utoronto.utm.paint.Strategies;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.PaintPanel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.DrawingCommands.Oval;

public class OvalManipulatorStrategy implements ShapeManipulatorStrategy {

	PaintModel model;
	PaintPanel panel;
	Oval currentOval;

	public OvalManipulatorStrategy(PaintModel model,PaintPanel panel){
		this.model = model;
		this.panel = panel;
	}

	public void createShape(int x, int y) {
		Point centre = new Point(x, y);
		Oval oval = new Oval(centre,0, 0,panel.getFilled());
		model.addCommand(oval);
		currentOval=oval;

	}


	public void modifyShape(int x, int y) {
		// Finds the X distance starting from start to end
		int Xdistance = Math.abs((currentOval.getCentre().getX() - x));
		// Finds the Y distance starting from start to end
		int Ydistance = Math.abs((currentOval.getCentre().getY() - y));
		// Finds the length created by these two points (Radius)
		currentOval.setxRadius(Xdistance);
		currentOval.setyRadius(Ydistance);
		panel.repaint();
	}

}
