package ca.utoronto.utm.paint;

import javax.swing.*;

import ca.utoronto.utm.paint.Strategies.CircleManipulatorStrategy;
import ca.utoronto.utm.paint.Strategies.CurveManipulatorStrategy;
import ca.utoronto.utm.paint.Strategies.EraserManipulatorStrategy;
import ca.utoronto.utm.paint.Strategies.OvalManipulatorStrategy;
import ca.utoronto.utm.paint.Strategies.PolylineManipulatorStrategy;
import ca.utoronto.utm.paint.Strategies.RectangleManipulatorStrategy;
import ca.utoronto.utm.paint.Strategies.SquareManipulatorStrategy;
import ca.utoronto.utm.paint.Strategies.SquiggleManipulatorStrategy;
import ca.utoronto.utm.paint.Strategies.TextInputManipulatorStrategy;
import ca.utoronto.utm.paint.Strategies.TriangleManipulatorStrategy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/
/**
 * The Shape Chooser Panel is used by the user to select the desired shape to be
 * drawn. A user can choose between a Circle, Rectangle, Square, Squiggle, or
 * Straight Line by clicking on the appropriate icon
 * 
 * @author csc207 group
 *
 */
class ShapeFactoryPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of
						// the view
	private JButton currentMode;
	private PaintModel model;

	public ShapeFactoryPanel(View view, PaintModel model) {
		this.view = view;
		this.model = model;

		String[] buttonLabels = { "Circle", "Rectangle", "Square","Triangle", "Squiggle", "Polyline","Oval","Curve", "Eraser", "TextInput" };
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		// for each shape option, a Button is created with an appropriate icon
		// and it is added to the shape chooser panel
		for (String label : buttonLabels) {
			JButton button = new JButton();
			button.setPreferredSize(new Dimension(53,52));
			button.setActionCommand(label);
			button.setBackground(Color.WHITE);
			String imgPath = "/" + label + ".png"; // the name of the actual png
													// file containing the icon
			Image img = new ImageIcon(this.getClass().getResource(imgPath)).getImage();
			button.setIcon(new ImageIcon(img));
			this.add(button);
			button.addActionListener(this);

		}
	}

	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// sets the button pressed to enabled such that the user knows which
		// shape is currently selected
		if (e.getActionCommand()=="Circle"){
			
			view.getPaintPanel().setStrategy(new CircleManipulatorStrategy(model,view.getPaintPanel()));
			
		}else if(e.getActionCommand()=="Square"){
			
			view.getPaintPanel().setStrategy(new SquareManipulatorStrategy(model,view.getPaintPanel()));
			
		}else if(e.getActionCommand()=="Rectangle"){
			
			view.getPaintPanel().setStrategy(new RectangleManipulatorStrategy(model,view.getPaintPanel()));
			
		}else if(e.getActionCommand()=="Polyline"){
			
			view.getPaintPanel().setStrategy(new PolylineManipulatorStrategy(model,view.getPaintPanel()));
			
		}else if(e.getActionCommand()=="Squiggle"){
			
			view.getPaintPanel().setStrategy(new SquiggleManipulatorStrategy(model,view.getPaintPanel()));
			
		}else if (e.getActionCommand() == "Oval") {

			view.getPaintPanel().setStrategy(new OvalManipulatorStrategy(model, view.getPaintPanel()));

		}else if(e.getActionCommand()=="Curve"){
		  
		    view.getPaintPanel().setStrategy(new CurveManipulatorStrategy(model,view.getPaintPanel()));
		  
		}else if (e.getActionCommand() == "Triangle") {

			view.getPaintPanel().setStrategy(new TriangleManipulatorStrategy(model, view.getPaintPanel()));

		}else if(e.getActionCommand()=="Eraser"){
		  
		    view.getPaintPanel().setStrategy(new EraserManipulatorStrategy(model,view.getPaintPanel()));
		  
		}else if(e.getActionCommand()=="TextInput"){
			
			view.getPaintPanel().setStrategy(new TextInputManipulatorStrategy(model, view.getPaintPanel()));
			
		}
		
		if (currentMode != null) { // sets the previous mode to normal so user
									// can select it again
			currentMode.setEnabled(true);
		}
		
		currentMode = (JButton) e.getSource();
		
		currentMode.setEnabled(false);

	}

}