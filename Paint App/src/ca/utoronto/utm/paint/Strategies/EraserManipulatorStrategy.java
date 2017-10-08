package ca.utoronto.utm.paint.Strategies;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.PaintPanel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.DrawingCommands.Eraser;

public class EraserManipulatorStrategy implements ShapeManipulatorStrategy {
    PaintPanel panel;
    PaintModel model;
    Eraser currentEraser;
    
    public EraserManipulatorStrategy(PaintModel model, PaintPanel panel) {
      this.model = model;  
      this.panel = panel;
    }
  
    public void modifyShape(int x, int y) {
      currentEraser.addPoint(new Point(x, y));
      panel.repaint();
    }


    public void createShape(int x, int y) {
      currentEraser = new Eraser();
      currentEraser.addPoint(new Point(x, y));
      model.addCommand(currentEraser);
    }

}
