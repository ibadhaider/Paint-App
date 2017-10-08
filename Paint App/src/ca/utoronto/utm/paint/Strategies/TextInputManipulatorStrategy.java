package ca.utoronto.utm.paint.Strategies;

import javax.swing.JOptionPane;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.PaintPanel;
import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.DrawingCommands.TextInput;

public class TextInputManipulatorStrategy implements ShapeManipulatorStrategy{
	PaintModel model;
	PaintPanel panel;
	TextInput currentTextInput;
	
	public TextInputManipulatorStrategy(PaintModel model,PaintPanel panel){
		this.model = model;
		this.panel = panel;
	}


	public void modifyShape(int x, int y) {
		
		currentTextInput.setBeginning(new Point(x,y));
		panel.repaint();
	}


	public void createShape(int x, int y) {
		Point start = new Point(x,y);
		String strInput = (String)JOptionPane.showInputDialog(panel,"Enter Text");
		currentTextInput = new TextInput(start,panel,strInput);
		model.addCommand(currentTextInput);
	}
}

