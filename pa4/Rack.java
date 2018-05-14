// Name: Hankun Yi
// USC NetID: hankunyi
// CS 455 PA4
// Fall 2017

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A Rack of Scrabble tiles
 */

public class Rack {
	
	/*
	 * Find all subsets for a string.
	 * 
	 */
	public ArrayList<String> getSubsets(String input){
		StringBuffer letterInput= new StringBuffer(); // buffer to only store letter in the input
		char[] inputArray;
		String uniqueInput=""; 
		int[] multiArray;
		//remove all non-letter character in the string
		for (int i = 0; i < input.length() ; i++) {
	        if (input.charAt(i)>='A' && input.charAt(i)<='z') {
	            letterInput.append(input.charAt(i));
	        }
	    }
		inputArray = letterInput.toString().toCharArray();
		Arrays.sort(inputArray);
		multiArray = new int[inputArray.length];
		int startpos=0;
		int arrayIndex = 0;
		//change the string to unique and record the multipilicy of each char
		for(int i=0; i<inputArray.length-1; i++) {
			if(inputArray[i] != inputArray[i+1]) {
				uniqueInput += inputArray[i];
				multiArray[arrayIndex] = i+1-startpos;
				arrayIndex++;
				//System.out.println(inputArray[i] + " :" + (i-startpos+1));
				startpos=i+1;
			}
			if(i==inputArray.length-2) {
				//System.out.println(inputArray[i+1] + " :" + (i-startpos+2));
				uniqueInput += inputArray[i+1];
				multiArray[arrayIndex] = i+2-startpos;
			}
		}
		return allSubsets(uniqueInput, multiArray, 0);	
	}
   



   /**
    * Finds all subsets of the multiset starting at position k in unique and mult.
    * unique and mult describe a multiset such that mult[i] is the multiplicity of the char
    *      unique.charAt(i).
    * PRE: mult.length must be at least as big as unique.length()
    *      0 <= k <= unique.length()
    * @param unique a string of unique letters
    * @param mult the multiplicity of each letter from unique.  
    * @param k the smallest index of unique and mult to consider.
    * @return all subsets of the indicated multiset
    * @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

   
}
