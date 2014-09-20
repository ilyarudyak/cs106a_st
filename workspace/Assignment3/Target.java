/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.Color;

public class Target extends GraphicsProgram {
	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 600;
	public static final int APPLICATION_HEIGHT = 400;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;
	
	
	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS_1 = 72;
	private static final int BALL_RADIUS_2 = (int) (72 * 0.65);
	private static final int BALL_RADIUS_3 = (int) (72 * 0.3);
	
	
	public void run() {
		drawTarget();
	}
	
	public void drawTarget() {
		
		setSize(WIDTH, HEIGHT);
		
		int w = WIDTH;
		int h = HEIGHT;
		
		int r1 = BALL_RADIUS_1;
		int r2 = BALL_RADIUS_2;
		int r3 = BALL_RADIUS_3;
		
		int x1 = w/2 - r1;
		int y1 = h/2 - r1;
		
		int x2 = x1 + (r1 - r2);
		int y2 = y1 + (r1 - r2);
		
		int x3 = x1 + (r1 - r3);
		int y3 = y1 + (r1 - r3);
		
		GOval oval1 = new GOval(x1, y1, 2 * r1, 2 * r1);
		oval1.setFilled(true);
		oval1.setColor(Color.RED);
		add(oval1);
		
		GOval oval2 = new GOval(x2, y2, 2 * r2, 2 * r2);
		oval2.setFilled(true);
		oval2.setColor(Color.WHITE);
		add(oval2);
		
		GOval oval3 = new GOval(x3, y3, 2 * r3, 2 * r3);
		oval3.setFilled(true);
		oval3.setColor(Color.RED);
		add(oval3);
	}
	

}
