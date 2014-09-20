/*
 * File: DragObjects1.java
 * ----------------------
 * This program displays two objects -- a red rectangle and
 * a green oval -- and then allows the user to drag those
 * objects using the mouse.  Clicking on an object moves it
 * to the front.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;

/** This class displays a mouse-draggable rectangle and oval */
public class DragObjects1 extends GraphicsProgram {

/* Initializes the program */
	public void init() {
		setSize(500, 300);
		
		// draw red rectangle
		GRect rect = new GRect(100, 100, 150, 100);
		rect.setFilled(true);
		rect.setColor(Color.RED);
		add(rect);
		
		//add listeners
		addMouseListeners();
		addKeyListeners();
	}

/* Called on mouse press to record the coordinates of the click */
	public void mouseClicked(MouseEvent e) {
		
		last = new GPoint(e.getX(), e.getY());
		gobj = getElementAt(last);
	}

	public void mouseDragged(MouseEvent e) {
		
		gobj.move(e.getX() - last.getX(), e.getY() - last.getY());
		last = new GPoint(e.getPoint());
		//gobj.setLocation(e.getX() - 75, e.getY() - 50);
		
	}
	
	
	


/* Private instance variables */
	private GObject gobj;           /* The object being dragged */
	private GPoint first;           /* The first mouse position  */
	private GPoint last;            /* The last mouse position  */

}
