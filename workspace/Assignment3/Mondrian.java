/*
 * File: Mondrian.java
 * -------------------
 * 
 * This file will eventually implement Mondrian sketch.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.Color;

public class Mondrian extends GraphicsProgram {
	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 600;
	public static final int APPLICATION_HEIGHT = 370;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;
	
	

	/** Width of a medium horiz rect height*/
	private static final int MEDIUM_RECT_HEIGHT = 15;
	
	/** Width of a thick vert rect width*/
	private static final int THICK_RECT_WIDTH = 30;
	
	/** Width of a thin  block */
	private static final int THIN_BLOCK = 50;
	
	/** Width of a thick  block */
	private static final int THICK_BLOCK = 100;
	
	
	
	public void run() {
		setSize(WIDTH, HEIGHT);
		drawHorizontalLines();
		drawHorizontalRect();
		drawVerticalRect();
	}
	
	public void drawHorizontalLines() {
		
		
		int W = WIDTH;
		int H = HEIGHT;
				
		int tnB = THIN_BLOCK;
		int tkB = THICK_BLOCK;
		
		int x0 = 0;
		int y0 = tnB + tkB;
		
		
		GLine line1 = new GLine(x0, y0, x0 + W, y0);
		add(line1);
		
		GLine line2 = new GLine(x0, y0 + tnB, x0 + W, y0 + tnB);
		add(line2);
	}
	
public void drawHorizontalRect() {
		
		
		int W = WIDTH;
		int H = HEIGHT;
				
		int tnB = THIN_BLOCK;
		int tkB = THICK_BLOCK;
		
		int hm = MEDIUM_RECT_HEIGHT;
		
		int x0 = 0;
		int y0 = tnB - hm - 2;
		
		int x1 = 0;
		int y1 = H - tkB + 7;	
		
		
		GRect rect1 = new GRect(x0, y0, W, hm);
		rect1.setFilled(true);
		rect1.setColor(Color.BLACK);
		add(rect1);
		
		GRect rect2 = new GRect(x1, y1, W, hm + 1);
		rect2.setFilled(true);
		rect2.setColor(Color.BLACK);
		add(rect2);
		
		GRect rect3 = new GRect(0, 0, 3 * THIN_BLOCK, y0);
		rect3.setFilled(true);
		rect3.setColor(Color.RED);
		add(rect3);
		
		GRect rect4 = new GRect(3 * THIN_BLOCK + THICK_RECT_WIDTH, y1 + hm, 3 * THIN_BLOCK - THICK_RECT_WIDTH, y1 + hm);
		rect4.setFilled(true);
		rect4.setColor(Color.YELLOW);
		add(rect4);
		
		int lx = x0;
		int ly = y0 - 2;
		GLabel label = new GLabel ("inspired by mondrian", lx, ly);
		label.setColor(Color.WHITE);
		add(label);
	}
	
public void drawVerticalRect() {
	
	
	int W = WIDTH;
	int H = HEIGHT;
			
	int vtnB = 3 * THIN_BLOCK;
	int vtkB = 6 * THIN_BLOCK;
	
	int htk = THICK_RECT_WIDTH;
	
	int x0 = vtnB;
	int y0 = 0;
	
	int x1 = 2* vtnB;
	int y1 = 0;	
	
	
	GRect rect1 = new GRect(x0, y0, htk, H);
	rect1.setFilled(true);
	rect1.setColor(Color.BLACK);
	add(rect1);
	
	GRect rect2 = new GRect(x1, y1, htk, H);
	rect2.setFilled(true);
	rect2.setColor(Color.BLACK);
	add(rect2);
	}

}
	
	



