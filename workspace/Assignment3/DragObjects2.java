/*
 * File: DragObjects.java
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
public class DragObjects2 extends GraphicsProgram {

/* Initializes the program */
	public void init() {
		setSize(500, 300);
		
		// add rect
		GRect rect = new GRect(100, 100, 150, 100);
		
		rect.setFilled(true);
		rect.setColor(Color.RED);
		
		add(rect);
		
		last = new GPoint(150, 150);
		gobj = getElementAt(last);
		
		// add listeners
		addMouseListeners();
		addKeyListeners();
	}

/* Called on mouse press to record the coordinates of the click */
	public void mouseClicked(MouseEvent e) {
		
		//gobj = getElementAt(e.getX(), e.getY());
	}



	
	public void keyPressed(KeyEvent e){
		
		
		
		
			switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT: gobj.move(-30,0); break;
			case KeyEvent.VK_RIGHT: gobj.move(+30,0); break;
			
		}
	}

/* Private instance variables */
	private GObject gobj;           /* The object being dragged */
	private GPoint first;           /* The first mouse position  */
	private GPoint last;            /* The last mouse position  */

}
