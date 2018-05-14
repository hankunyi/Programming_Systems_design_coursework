import java.util.ArrayList;
import java.util.Scanner;

// Name: Hankun
// USC NetID: hankunyi
// CSCI455 PA2
// Fall 2017


/**
   <add main program comment here>
   class BulgarianSolitaireSimulator
   To model the game Bulgarian Solitaire. 
   The program will be able to run in a few different modes. User may supply one or both of the argument, or neither
   -u: Prompts for the initial configuration from the user, instead of generating a random configuration.
   -s: Stops between every round of the game. The game only continues when the user hits enter  
 */

public class BulgarianSolitaireSimulator {
	
	public static void main(String[] args) {
		boolean singleStep = false;  	// to detect users argument -u
		boolean userConfig = false;		// to detect users argument -s
		
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-u")) {
				userConfig = true;
			}
			else if (args[i].equals("-s")) {
				singleStep = true;
			}
		}
                  
      
		// <add code here>            
		ArrayList<Integer> inputArr = new ArrayList<Integer> (); // Array to load user's input
		SolitaireBoard inputBoard = new SolitaireBoard();		 // Creates a solitaire board with a random initial configuration.
		int roundTime = 0;										 // the number of rounds have been played
		if(userConfig == true) {
			inputArr = configRead();
			inputBoard = new SolitaireBoard(inputArr);
		}
		System.out.println("Initial configuration: " + inputBoard.configString());
		while(!inputBoard.isDone()){
			inputBoard.playRound();
			roundTime ++;
			System.out.println("[" + roundTime + "] Current configuration: " + inputBoard.configString());
				if(singleStep == true) {
					System.out.print("<Type return to continue>");
					Scanner in = new Scanner(System.in);
						while(!in.hasNextLine()) {
						}
				}
			}
		System.out.println("Done!");   
	}
      
      // <add private static methods here>

	// do the prompt part to read configuration when user input -u as the argument
	private static ArrayList<Integer> configRead() {
		ArrayList<Integer> userArr = new ArrayList<Integer>();	// to record user's input
		boolean isValidInput = false;						// judge whether user's input is valid
		System.out.println("Number of total cards is " + SolitaireBoard.CARD_TOTAL);
		System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
		while(!isValidInput) {
			userArr = new ArrayList<Integer> ();
			System.out.println("Please enter a space-separated list of positive integers followed by newline:");
			Scanner in = new Scanner(System.in);
			String line = in.nextLine();
			Scanner lineScanner = new Scanner(line);
			while(lineScanner.hasNextInt()) {
				int n=lineScanner.nextInt();	//read user input one by one
				userArr.add(n);
			}  		  
			if (userArr.size() > 0 && userArr.size() <= SolitaireBoard.CARD_TOTAL) {
				int InputSum = 0;		//sums of user's input
				for(int i=0; i<userArr.size();i++) {
					if(userArr.get(i) > 0 && userArr.get(i) <= SolitaireBoard.CARD_TOTAL) {
						isValidInput = true;
						InputSum += userArr.get(i);
					}
					else {
						isValidInput = false;
						break;
					}
				}
				if(InputSum != SolitaireBoard.CARD_TOTAL || !isValidInput) {
					isValidInput = false;
				}
				if (lineScanner.hasNext()) {
					isValidInput = false;
				}
			}
			if(!isValidInput) {
				System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be " + SolitaireBoard.CARD_TOTAL);
			}
		}
		return userArr;
	}
}
