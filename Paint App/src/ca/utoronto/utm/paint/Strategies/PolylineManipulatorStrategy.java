package ca.utoronto.utm.paint.Strategies;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.PaintPanel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.DrawingCommands.Polyline;

public class PolylineManipulatorStrategy implements ShapeManipulatorStrategy{
	PaintModel model;
	PaintPanel panel;
	Polyline currentPolyline;
	private static Point endpoint;
	
	public PolylineManipulatorStrategy(PaintModel model,PaintPanel panel){
		this.model = model;
		this.panel = panel;
	}


	
	public void modifyShape(int x, int y) {
		if (currentPolyline != null || endpoint != null){
			endpoint= new Point(x,y);
			currentPolyline.setEndPoint(new Point(x,y));
			model.addCommand(currentPolyline);
			panel.repaint();
		}
		
	}


	
	public void cancelpolyline(){
		currentPolyline=null;
		endpoint=null;
		 
		
	}

	public void createShape(int x, int y) {
		if(endpoint==null){
		Polyline polyline= new Polyline(new Point(x,y),new Point(x,y));
		model.addCommand(polyline);
		currentPolyline=polyline;
	}
		else{
			currentPolyline= new Polyline(endpoint,endpoint);
			model.addCommand(currentPolyline);

		}
		}
}
