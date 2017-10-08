package ca.utoronto.utm.paint;

import javax.swing.*;

import ca.utoronto.utm.paint.DrawingCommands.DrawingCommand;
import ca.utoronto.utm.paint.Strategies.PolylineManipulatorStrategy;
import ca.utoronto.utm.paint.Strategies.ShapeManipulatorStrategy;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

public class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener {
	
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	private Color DEFAULTCOLOR = Color.black;
    private boolean filled;
	private ShapeManipulatorStrategy current; 

	public PaintPanel(PaintModel model, View view) {
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(300, 300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.filled = false;

		this.model = model;
		this.model.addObserver(this);

		this.view = view;
	}

	/**
	 * paints all the different shapes user has created thus far
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
        g2d.setBackground(Color.white);
		// setBackground (Color.blue); 
		// Origin is at the top left of the window 50 over, 75 down
		g2d.setColor(DEFAULTCOLOR);
		
		ArrayList<DrawingCommand> drawingCommands = model.getCommands();
		for (DrawingCommand command: drawingCommands){
			command.execute(g2d);
		}
		
		
		g2d.dispose();
	}
	

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	public void setFilled(boolean filled){
		this.filled = filled;
	}
	public boolean getFilled(){
		return this.filled;
	}

	public void setStrategy(ShapeManipulatorStrategy strategy){
		this.current = strategy;
		
		
	}
	public ShapeManipulatorStrategy getStrategy(ShapeManipulatorStrategy strategy){
		return strategy;
		
		
	}

	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	// gives feedback to user as user is creating different shapes
	public void mouseDragged(MouseEvent e) {
		if(current!=null){
			current.modifyShape(e.getX(), e.getY());
		}else{
			JOptionPane.showMessageDialog(this, "Please select a shape to draw first!");
		}
		
		}
	

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {
		

	}

	@Override
	// creates different shapes with their starting points
	public void mousePressed(MouseEvent e) {

			if(current!=null){
			
				if(SwingUtilities.isRightMouseButton(e) && current instanceof PolylineManipulatorStrategy){
						((PolylineManipulatorStrategy) current).cancelpolyline();
					
				}else{
					current.createShape(e.getX(), e.getY());
			}
				
			}else{
				JOptionPane.showMessageDialog(this, "Please select a shape to draw first!");
			}
		}
	

	@Override
	// creates the final version of the shape the user wants
	public void mouseReleased(MouseEvent e) {
		if(current!=null){
			current.modifyShape(e.getX(), e.getY());
		}else{
			JOptionPane.showMessageDialog(this, "Please select a shape to draw first!");
		}		
		}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	
}
