/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class HangmanLexicon {

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return 10;
	}
	
	
	public  String getWord(String filename) {
		
		
        
        ArrayList<String> arr = new ArrayList<String>();
        
        try {
        	FileReader fileReader = new FileReader(filename);
            BufferedReader in = new BufferedReader(fileReader);
        	
	        while (true) {
	        	String s = in.readLine();
	            if (s == null) break;
	            else arr.add(s);
	        
	        }
        } catch (IOException ex) {
        	throw new ErrorException(ex);
        } 
        
        int s = arr.size();
        Random random = new Random();
        
        String word = arr.get(random.nextInt(s));
			return word;
		
	}
/** Returns the word at the specified index. */
	public String getWord(int index) {
		switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");
		}
	};
}
