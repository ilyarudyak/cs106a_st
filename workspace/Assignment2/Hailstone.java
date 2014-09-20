/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		playHailstone();
	}
	
	public void playHailstone() {
		
		int n = readPositiveInt();
		
		int count = 0;
		while (true) {
			int tmp = n;
			if (n % 2 == 0) {
				n = n/2;
				println(tmp + " is even, so I take half: " + n );
			}
			else {
				n = 3 * n + 1;
				println(tmp + " is odd, so I make 3n+1: " + n);
			}
			count++;
			if (n == 1) {
				println("The process took " + count + " steps to reach 1");
				break;
			}
		}
	}
	
	private int readPositiveInt() {
		/* Get an initial value. */
		
		
		/* If the value was nonpositive, reprompt the user. */
		while (true) {
			int value = readInt("Enter a positive integer: ");
			if (value <=0) 
				println("Please enter a positive integer.");
			else return value;
			
		}
	}
}

