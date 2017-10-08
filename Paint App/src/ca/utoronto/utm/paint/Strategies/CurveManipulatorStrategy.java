package ca.utoronto.utm.paint.Strategies;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.PaintPanel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.DrawingCommands.Curve;

/**
 * CurveManipulatorStrategy provides the logic for creating and modifying Curve
 * objects on the PaintPanel and storing their updated data in PaintModel as 
 * the user clicks and drags around the canvas.
 */
public class CurveManipulatorStrategy implements ShapeManipulatorStrategy {
  PaintPanel panel;
  PaintModel model;
  Curve currentCurve;
  
  public CurveManipulatorStrategy(PaintModel model, PaintPanel panel) {
    this.model = model;
    this.panel = panel;
  }
  
  public void modifyShape(int x, int y) {
    currentCurve.setEndPoint(new Point(x,y));
    panel.repaint();
  }

  public void createShape(int x, int y) {
    Point start = new Point(x,y);
    currentCurve = new Curve(start, start);
    model.addCommand(currentCurve);
  }

}
