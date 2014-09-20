/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	
	public void drawScaffold() {
		int w = getWidth();
		int h = getHeight()/4;
		
		GLine line1 = new GLine(w/2, h/2 - HEAD_RADIUS - ROPE_LENGTH,
				w/2, h/2 - HEAD_RADIUS);
		
		GLine line2 = new GLine(w/2, h/2 - HEAD_RADIUS - ROPE_LENGTH,
				w/2 - BEAM_LENGTH, h/2 - HEAD_RADIUS - ROPE_LENGTH);
		
		GLine line3 = new GLine(w/2 - BEAM_LENGTH, h/2 - HEAD_RADIUS - ROPE_LENGTH,
				w/2 - BEAM_LENGTH, h/2 - HEAD_RADIUS - ROPE_LENGTH + SCAFFOLD_HEIGHT);
		add(line1);
		add(line2);
		add(line3);
		
	}
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		GObject lab = getElementAt(50, 500);
		if (lab != null) remove(lab);
		
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(char[] guessProcess) {
		String word = "";
		for (int i = 0; i < guessProcess.length; i++) 
    		word += guessProcess[i];
		
		
		GLabel label = new GLabel(word, 50, 500);
		add(label);
		
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(int lifeCount) {
		
		int w = getWidth();
		int h = getHeight()/4;
		
		if (lifeCount == 7) {
				
			GOval oval = new GOval(w/2 - HEAD_RADIUS, h/2 - HEAD_RADIUS, HEAD_RADIUS * 2, HEAD_RADIUS * 2);
			add(oval);
		} else if (lifeCount == 6) {
			GLine l6 = new GLine(w/2, h/2 + HEAD_RADIUS, w/2, h/2 + HEAD_RADIUS + BODY_LENGTH);
			add(l6);
		} else if (lifeCount == 5) {
			int x0_5 = w/2; 
			int y0_5 = h/2 + HEAD_RADIUS + ARM_OFFSET_FROM_HEAD;
			int x1_5 = x0_5 - UPPER_ARM_LENGTH;
			int y1_5 = y0_5;
			
			GLine l5 = new GLine(x0_5, y0_5, x1_5, y1_5);
			add(l5);
			GLine l5_1 = new GLine(x1_5, y1_5, x1_5, y1_5 + LOWER_ARM_LENGTH);
			add(l5_1);
			
			
			
		} else if (lifeCount == 4) {
			int x0_4 = w/2; 
			int y0_4 = h/2 + HEAD_RADIUS + ARM_OFFSET_FROM_HEAD;
			int x1_4 = x0_4 + UPPER_ARM_LENGTH;
			int y1_4 = y0_4;
			
			GLine l4 = new GLine(x0_4, y0_4, x1_4, y1_4);
			add(l4);
			GLine l4_1 = new GLine(x1_4, y1_4, x1_4, y1_4 + LOWER_ARM_LENGTH);
			add(l4_1);
			
		} else if (lifeCount == 3) {
			int x0_3 = w/2; 
			int y0_3 = h/2 + HEAD_RADIUS + BODY_LENGTH;
			int x1_3 = x0_3 - HIP_WIDTH;
			int y1_3 = y0_3;
			
			GLine l3 = new GLine(x0_3, y0_3, x1_3, y1_3);
			add(l3);
			GLine l3_1 = new GLine(x1_3, y1_3, x1_3, y1_3 + LEG_LENGTH);
			add(l3_1);
		} else if (lifeCount == 2) {
			int x0_2 = w/2; 
			int y0_2 = h/2 + HEAD_RADIUS + BODY_LENGTH;
			int x1_2 = x0_2 + HIP_WIDTH;
			int y1_2 = y0_2;
			
			GLine l2 = new GLine(x0_2, y0_2, x1_2, y1_2);
			add(l2);
			GLine l2_1 = new GLine(x1_2, y1_2, x1_2, y1_2 + LEG_LENGTH);
			add(l2_1);
		} else if (lifeCount == 1) {
			
			GLine l1 = new GLine(w/2 - HIP_WIDTH, h/2 + HEAD_RADIUS+ BODY_LENGTH + LEG_LENGTH, 
					w/2 - HIP_WIDTH - FOOT_LENGTH, h/2 + HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
			add(l1);
		} else if (lifeCount == 0) {
			GLine l0 = new GLine(w/2 + HIP_WIDTH, h/2 + HEAD_RADIUS +BODY_LENGTH + LEG_LENGTH,
					w/2 + HIP_WIDTH + FOOT_LENGTH, h/2 + HEAD_RADIUS +BODY_LENGTH + LEG_LENGTH);
			add(l0);
		}
	}

/* Constants for the simple version;
 *  of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
