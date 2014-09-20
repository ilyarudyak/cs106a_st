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

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = 300;
	private static final int HEIGHT = 450;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 50;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static final int LIFE = 5;
	
	/** Speed of paddle */
	private static final int SPEED = 30;
	
	/** Speed of ball */
	private static final double VELOCITY = 0.001;
	
	/** ## of bricks*/
	private static final int BRICKS_NUMBER = 100;
	

	/* Initialize the keyboard listeners */
	public void init() {
		addKeyListeners();
		addMouseListeners();
	}
	
	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
		
		setSize(WIDTH, HEIGHT);
		drawBricks();
		drawPaddle();
		drawBall();
	}
	
	private GObject getCollidingObject(double x, double y){
		int r = BALL_RADIUS;
		if (getElementAt(x, y) != null) return getElementAt(x, y);
		else if (getElementAt(x + 2*r, y) != null) return getElementAt(x + 2*r, y);
		else if (getElementAt(x, y + 2*r) != null) return getElementAt(x, y + 2*r);
		else if (getElementAt(x + 2*r, y + 2*r) != null) return getElementAt(x + 2*r, y + 2*r);
		else return null;
	}
	
	/* Called on mouse press to record the coordinates of the click */
	public void mousePressed(MouseEvent e) {
		last = new GPoint(e.getPoint());
		gobj = getElementAt(last);
	}
	
	public void keyPressed(KeyEvent e){
		
		
		
		if (paddle != null){
			switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT: {
				if (paddle.getX() - SPEED >= 0) {
					paddle.move(-SPEED,0); break;
				} else break;
			}
			case KeyEvent.VK_RIGHT: {
				if (paddle.getX() + SPEED - PADDLE_WIDTH <= 200) {
					paddle.move(+SPEED,0); break;
				} else break;
			}
			}
		}
	}
	
	void drawBall(){
		
		int W = WIDTH;
		int H = HEIGHT;
		int r = BALL_RADIUS;
		double v = VELOCITY;
		
		GOval oval = new GOval(W/2 - r, H/2 - r, 2*r, 2*r);
		oval.setFilled(true);
		add(oval);
		
		vx = rgen.nextDouble(v * 0.8, v);
		if (rgen.nextBoolean(0.5)) vx = -vx;
		
		vy = v;
		
		int count1 = BRICKS_NUMBER;
		int count2 = LIFE;
		while (true) {
			
			
			oval.move(vx, vy);
			if (oval.getX() <= 0 || oval.getX() + 2*r >= W) vx = -vx;
			if (oval.getY() <= 0) vy = -vy;
			if (oval.getY() + 2*r >= H) {
				vy = -vy;
				println(--count2);
			}
			
			
			
			GObject collider = getCollidingObject(oval.getX(), oval.getY());
			
			if (collider == paddle) vy = -vy;
			
			if (collider != paddle && collider != null) {
				remove(collider);
				vy = -vy;
				count1--;
			}
			
			if (count1 == 0 || count2 == 0) {
				println("game over");
				break;
			}
			
		}
		
		
	}
	
	void drawPaddle(){
		
		int w = PADDLE_WIDTH;
		int h = PADDLE_HEIGHT;
		int W = WIDTH;
		int H = HEIGHT;
			
		GRect rect = new GRect(W/2 - w/2, H - PADDLE_Y_OFFSET, w, h);
		rect.setFilled(true);
		paddle = rect;
		add(paddle);
	}
	
	void drawBricks(){
		
		int h = BRICK_HEIGHT;
		int d = BRICK_SEP;
		
		drawBricks(Color.RED, BRICK_Y_OFFSET);
		drawBricks(Color.ORANGE, BRICK_Y_OFFSET + 2 * h + 2 * d);
		drawBricks(Color.YELLOW, BRICK_Y_OFFSET + 4 * h + 4 * d);
		drawBricks(Color.GREEN, BRICK_Y_OFFSET + 6 * h + 6 * d);
		drawBricks(Color.CYAN, BRICK_Y_OFFSET + 8 * h + 8 * d);
	}
	
	void drawBricks(Color color, int y0) {
		
		int w = BRICK_WIDTH;
		int h = BRICK_HEIGHT;
		int d = BRICK_SEP;
		int x0 = d/2;
		int N = NBRICKS_PER_ROW;
		
		for (int n = 0; n < N; n++) {
			for (int i = 0; i < 2; i++){
				GRect rect = new GRect(x0 + w * n + d * n, y0 + h * i + d * i, w, h);
				rect.setFilled(true);
				rect.setColor(color);
				add(rect);
			}
		}
	}
	
	
	
	/* Private instance variables */
	private GObject gobj;           /* The object being dragged */
	private GPoint last;            /* The last mouse position  */	
	private GObject paddle; 
	
	private double vx;
	private double vy; // ball coordinates
	private RandomGenerator rgen = RandomGenerator.getInstance(); // random generator
	
	
	
}
