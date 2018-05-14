// Name: Hankun Yi
// USC NetID: hankunyi
// CS 455 PA4
// Fall 2017

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * A dictionary of all anagram sets. 
 * Note: the processing is case-sensitive; so if the dictionary has all lower
 * case words, you will likely want any string you test to have all lower case
 * letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
	private Map<String, ArrayList<String>> angramMap = new HashMap<String,ArrayList<String>>();

   


   /**
    * Create an anagram dictionary from the list of words given in the file
    * indicated by fileName.  
    * PRE: The strings in the file are unique.
    * @param fileName  the name of the file to read from
    * @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
   	String originWord;
   	char[] originArray;
   	String sortedWord;
   	File inFile = new File(fileName);
   	Scanner in = new Scanner (inFile);
   	while(in.hasNextLine()) {
   		originWord = in.nextLine();
   		if(originWord.length()!=0) {
	   		originArray = originWord.toCharArray();
	   		Arrays.sort(originArray);
	   		sortedWord = new String(originArray);
	
	   		// add the entry set of the map, key is the sorted word and value is arraylist of original word
	   		if(angramMap.containsKey(sortedWord)) {
	   			angramMap.get(sortedWord).add(originWord);
	   		}
	   		else {
	   			ArrayList<String> valueList = new ArrayList<String>();
	   			valueList.add(originWord);
	   			angramMap.put(sortedWord,valueList);
	   		}	
   		}
   	}

   }
   

   /**
    * Get all anagrams of the given string. This method is case-sensitive.
    * E.g. "CARE" and "race" would not be recognized as anagrams.
    * @param s string to process
    * @return a list of the anagrams of s
    * 
    */
   public ArrayList<String> getAnagramsOf(String s) {
   	char[] inputArray;
   	String sortedString;
   	inputArray = s.toCharArray();
   	Arrays.sort(inputArray);
   	sortedString = new String(inputArray);
   	if(angramMap.containsKey(sortedString)) {
   		return new ArrayList<String>(angramMap.get(sortedString));	
   	}
   	else {
   		return new ArrayList<String>(); 
   	}
   }
   
   
}
