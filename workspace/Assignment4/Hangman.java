/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.Random;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Hangman extends ConsoleProgram {
	
	
	private HangmanCanvas canvas;
	
	public void init() {
		   canvas = new HangmanCanvas();
		   add(canvas);
		   canvas.drawScaffold();
		}

    public void run() {
    	setSize(600, 700);
    	playHangman();
	}
    
    public void playHangman() {
    	
    	//get a word from HangmanLexicon class
    	HangmanLexicon lexicon = new HangmanLexicon();
    	String word = lexicon.getWord("/Users/IRudyak/Documents/workspace/Assignment4/ShorterLexicon.txt");
    	
    	println(word);
    	
    	//create an array to follow guessing process
    	char[] guessProcess = new char[word.length()];
    	for (int i = 0; i < guessProcess.length; i++)
    		guessProcess[i] = '-';
    	
    	
    	
    	//control structure
    	int lifeCount = 8;
    	int count = 0;
    	println("Welcome to Hangman");
    	canvas.drawScaffold();
    	
    	while (lifeCount > 0) {
    		
    		boolean flag = false;
    		
    		print("The word now looks like this: ");
    		for (int i = 0; i < guessProcess.length; i++)
        		print(guessProcess[i]);
    		println();
    		canvas.reset();
    		canvas.displayWord(guessProcess);
    		
    		//lifeCount printing
    		println("You have " + lifeCount + " guesses left.");
    		
    		//read a letter from keyboard (in Upper case)
        	char rc = readLetter();
        	
        	for (int i = 0; i < word.length(); i++) {
        		if (rc == word.charAt(i)) {
        			guessProcess[i] = rc;
        			println("That guess is correct.");
        			count++;
        			if (count == word.length()) {
        				println("You guessed the word: " + word);
        				println("You win.");
        				canvas.reset();
        	    		canvas.displayWord(guessProcess);
        				return;
        			}
        			flag = true;
        			
        		} 
        	}
        	
        	if (flag == false) {
        		println("There are no " + rc + "\'s in the word.");
        		lifeCount--;
        		canvas.noteIncorrectGuess(lifeCount);
        	}
    	}
    	canvas.noteIncorrectGuess(lifeCount);
    	println("You\'re completely hung.");
    	println("The word was: " + word);
    	println("You lose.");
    	
    	
    }
    
    //we read a string, check if its a single character and a letter, 
    //convert to Upper Case
	private char readLetter() {
		
		while (true) {
			String value = readLine("Your guess: ");
			if (!Character.isLetter(value.charAt(0)) || value.length() > 1) 
				println("Your guess: ");
			else return Character.toUpperCase(value.charAt(0));
			
		}
	}
}
