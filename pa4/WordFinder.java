// Name: Hankun Yi
// USC NetID: hankunyi
// CS 455 PA4
// Fall 2017


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * class WordFinderViewer
 * 
 * Finds all possible words that can be made from a rack of Scrabble tiles
 * 
 * When run this program, it will prompt for the rack of Scrabble tiles
 * Enter '.' to exit the program
 * You can enter the dictionary name in the argument when running program, the default dictionary is sowpods.txt
 * 
 * The program will show all the possible words and their score based on ScoreTable.
 * 
 * 
 */

public class WordFinder{
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);		
		System.out.println("Type . to quit.");
		System.out.print("Rack? ");
		String userInput= in.nextLine();
		String filename= (args.length==0) ? "sowpods.txt" : args[0];
		while(!userInput.equals(".")) {
			try {
				int wordNum = 0;
				Rack inputRack = new Rack();
				ScoreTable inputScore = new ScoreTable();
				AnagramDictionary angramdic = new AnagramDictionary(filename);
				ArrayList<String> allSubset = inputRack.getSubsets(userInput); // get all subset for the input
				Map<String, Integer> resultMap= new TreeMap<String, Integer>();// This map is to store the possible words and their score
				for(int i=0; i<allSubset.size();i++) {
					ArrayList<String> angramList = angramdic.getAnagramsOf(allSubset.get(i)); // get the angramList of each subset
					if(angramList.size()!=0) {
						for(int j=0; j<angramList.size();j++) {
						resultMap.put(angramList.get(j), inputScore.getScore(angramList.get(j))); // store words and its score in result map
						wordNum ++;
						}
					}
				}
				System.out.println("We can make " + wordNum + " words from \"" + sortString(userInput) + "\""  );
				if(wordNum!=0) {
					System.out.println("All of the words with their scores (sorted by score):");
					printSortMap(resultMap); // print the result
				}
			}	
			catch (FileNotFoundException exception)
         {
            System.out.println("File not found.");
         }			
			System.out.print("Rack? ");
			userInput = in.nextLine();		
		}		
	}
		
	/**
   Sorted result Map and print it out.
   
   The map is sorted by score in decreasing order. 
   If two words have same score, show it in increasing order alphabetically
	*/
	private static void printSortMap(Map<String, Integer> originMap) {	
		
		// Construct a comparator for sort the Map
		Comparator<Map.Entry<String, Integer>> scoreComparator = new Comparator<Map.Entry<String,Integer>>() {
	      public int compare(Map.Entry<String, Integer> entry1,Map.Entry<String, Integer> entry2) {
	      	if(entry1.getValue()!= entry2.getValue()) {
	      		return entry2.getValue()-entry1.getValue();
	      	}
	      	else {
	      		return entry1.getKey().compareTo(entry2.getKey());
	      	}
	      }
	  };
	  
	  //Sort map and print it out
	  List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String,Integer>>(originMap.entrySet());
	  Collections.sort(sortedList, scoreComparator);
	  for (Map.Entry<String, Integer> curr : sortedList) {
			 System.out.println(curr.getValue()+ ": " + curr.getKey());
	  }				 
	}
	

	// a helper function to sort a string in alphabetically order.
	private static String sortString(String originStr) {
		char[] originArray;
   	originArray = originStr.toCharArray();
   	Arrays.sort(originArray);
   	return new String(originArray);
	}
		
}