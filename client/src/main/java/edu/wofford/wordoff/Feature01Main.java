package edu.wofford.wordoff;
import java.util.*;

/**
* Feature 01
* This program implements an application that
* takes either a string or integer from the command line
* and prints out either all the anagrams of the string
* or a randomly chosen word with a number of anagrams equal to the passed integer
*/

public class Feature01Main {
    /**
    * Feature 01 Main
    * This is the main method that creates a new hashmap called anagrams
    * and calls proper functions if command line argument is string or integer
    * @param args the command line argument given: either string or integer
    */
    public static void main(String[] args) {
    	Anagrams anagrams;
    	if (args.length > 1) {
    		long random_seed = Long.parseLong(args[1]);
            Random random = new Random(random_seed);
    		anagrams = new Anagrams(random);
    	} else {
    		anagrams = new Anagrams();
    	}
    	try{
        	int numOfAnagrams = Integer.parseInt(args[0]);
        	List<String> anagramsOfWord = anagrams.getNumberOfAnagrams(numOfAnagrams);
        	if(anagramsOfWord != null) {
          		for(int i = 0; i < anagramsOfWord.size(); i++){
            		System.out.println(anagramsOfWord.get(i));
          		}
        	}
    	}
    	catch(NumberFormatException e){
        	String word = args[0];
        	List<String> anagrams_of_word = anagrams.getAnagramsOfWord(word);
        	if(anagrams_of_word != null){
            	for(int i = 0; i < anagrams_of_word.size(); i++){
              		System.out.println(anagrams_of_word.get(i));
            	}
        	}
    	}
    }
}
