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
public class DragObjects extends GraphicsProgram {

/* Initializes the program */
	public void init() {
		setSize(500, 300);
		/*GRect rect = new GRect(100, 100, 150, 100);
		rect.setFilled(true);
		rect.setColor(Color.RED);
		add(rect);
		GOval oval = new GOval(300, 115, 100, 70);
		oval.setFilled(true);
		oval.setColor(Color.GREEN);
		add(oval);*/
		addMouseListeners();
		addKeyListeners();
	}

/* Called on mouse press to record the coordinates of the click */
	public void mousePressed(MouseEvent e) {
		first = new GPoint(e.getPoint());
		gline = new GLine(first.getX(), first.getY(), e.getX(), e.getY());
		add(gline);
		//gobj = getElementAt(e.getX(), e.getY());
	}

	public void mouseDragged(MouseEvent e) {
		
		gline.setEndPoint(e.getX(), e.getY());
		
		
	}
	
	
	
/* Called on mouse click to move this object to the front 
	public void mouseClicked(MouseEvent e) {
		if (gobj != null) gobj.sendToFront();
	}*/
	
	public void keyPressed(KeyEvent e){
		
		
		
		if (gobj != null){
			switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT: gobj.move(-30,0); break;
			case KeyEvent.VK_RIGHT: gobj.move(+30,0); break;
			}
		}
	}

/* Private instance variables */
	private GObject gobj;           /* The object being dragged */
	private GLine gline;
	private GPoint first;           /* The first mouse position  */
	private GPoint last;            /* The last mouse position  */

	
	
	
	
	
	/* Called on mouse drag to reposition the object
	public void mouseDragged(MouseEvent e) {
		if (gobj != null) {
			gobj.move(e.getX() - last.getX(), e.getY() - last.getY());
			last = new GPoint(e.getPoint());
		}
	}*/	
}
