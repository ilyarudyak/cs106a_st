/*
 * File: Bricks.java
 * -------------------
 * 
 * This file will eventually implement the bricks pyramid.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.Color;

public class Bricks extends GraphicsProgram {
	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 600;
	public static final int APPLICATION_HEIGHT = 400;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;
	
	/** Width of a brick */
	private static final int BRICK_WIDTH = 30;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 12;
	
	/** Number of bricks in a base */
	private static final int NUMBER_BRICKS_IN_BASE = 14;
	
	
	
	public void run() {
		
		drawBricks();
	}
	
	public void drawBricks() {
		
		setSize(WIDTH, HEIGHT);
		
		int W = WIDTH;
		int H = HEIGHT;
		
		int w = BRICK_WIDTH;
		int h = BRICK_HEIGHT;
		int N = NUMBER_BRICKS_IN_BASE;
		
		for (int n = N; n > 0; n--) {
			
			int x0 = W/2 - (int) 7.5 * w + (N-n) * w/2;
			int y0 = H - h - (N-n) * h;
			
			for (int i = 0; i < n; i++) {
				
				GRect rect = new GRect(x0 + w * i, y0, w, h);
				add(rect);
			
			}
		}
	}
}
	
	


