// 	Name: Hankun Yi
// 	USC NetID: hankunyi
// 	CSCI455 PA2
// 	Fall 2017

import java.util.ArrayList;
import java.util.Random;

/*
   	class SolitaireBoard
   	The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
   	by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
   	for CARD_TOTAL that result in a game that terminates.
   	(See comments below next to named constant declarations for more details on this.)
*/

public class SolitaireBoard {
   
	public static final int NUM_FINAL_PILES = 9;
	// number of piles in a final configuration
    // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
	
	public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
    // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
    // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
    // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

    // Note to students: you may not use an ArrayList -- see assgt description for details.
   
   
    /**
      Representation invariant:
      --int [] cardPile is a partially filled array to represent piles on the board
      --pileLength is the number of piles on the board
      --0 <= pileLength <=cardPile.length
      --if pileLength > 0, the number of cards in each pile are in cardPile[0] to cardPile[pileLength - 1]
      --the number of cards in each pile should always larger than 0
      --number of total card on the board should always equal to CARD_TOTAL

      <put rep. invar. comment here>

     */
   
    // <add instance variables here>
   
    private int[] cardPile = new int[CARD_TOTAL];	//partially filled array present piles on the board
    private int   pileLength = 0;					//numbers of piles currently on the board
  
 
   /**
     Creates a solitaire board with the configuration specified in piles.
     piles has the number of cards in the first pile, then the number of cards in the second pile, etc.
     PRE: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
   */
    public SolitaireBoard(ArrayList<Integer> piles) {
    	for(int i=0; i<piles.size(); i++) {
    		cardPile[i] = piles.get(i);
    	}
    	pileLength = piles.size();
    	assert isValidSolitaireBoard();   // sample assert statement (you will be adding more of these calls)
    }
 
   
   /**
      Creates a solitaire board with a random initial configuration.
   */
    public SolitaireBoard() {
    	Random generator = new Random();		// to generate random numbers of card in pile for a random initial configuration
    	int currentNum = 0;					// the numbers of card that should be allocated for current pile
    	int validNum = CARD_TOTAL;			// the numbers of card that still not be allocated
    	int index = 0;						// index of current pile
    	while (validNum > 0){
    		currentNum = generator.nextInt(validNum) + 1;
    		cardPile[index] = currentNum;
    		validNum -= currentNum;
    		index++;
    	}
    	pileLength = index;
    	assert isValidSolitaireBoard();
    }
  
   
   /**
      Plays one round of Bulgarian solitaire.  Updates the configuration according to the rules
      of Bulgarian solitaire: Takes one card from each pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
    */
    public void playRound() {
    	for(int i=0; i<pileLength; i++) {
    		cardPile[i] --;
    	}
    	int NewPile = pileLength;			// number of cards in new pile when playround
    	for(int i=0; i<pileLength; i++) {
    		if (cardPile[i] == 0) {
    			for(int j=i; j<pileLength-1; j++) {
    				cardPile[j] = cardPile[j+1];
    			}
    			i--;
    			pileLength --;
    		}
    	}
    	cardPile[pileLength] = NewPile;
    	pileLength ++;
    	assert isValidSolitaireBoard();	   
    }
   
    /**
      Returns true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
      piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
    */
   
    public boolean isDone() {
    	int PileSum=0;						//total numbers of card on the board
    	if(pileLength != NUM_FINAL_PILES) {
    		assert isValidSolitaireBoard();
    		return false;
    	}
	   
    	for (int i=0; i<pileLength; i++) {
    		PileSum += cardPile[i];
    	}
    	if(PileSum != CARD_TOTAL) {
    		System.out.println("false");
    		assert isValidSolitaireBoard();
    		return false;
    	}
	   
	   
    	for(int i=0; i<pileLength-1; i++) {
    		for(int j=i+1; j<pileLength; j++) {
    			if(cardPile[i]== cardPile[j]){
    				assert isValidSolitaireBoard();
    				return false;
    			}
    		}		   
    	}
	   
    	assert isValidSolitaireBoard();
    	return true; 
    }

   
   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
    */
    public String configString() {
    	String config="" + cardPile[0];			//represent current board configuration as a string
    	for(int i=1; i<pileLength; i++) {
    		config+=" "+cardPile[i];
    	}
    	assert isValidSolitaireBoard();
    	return config;  
    }
   
   
   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
    */
    private boolean isValidSolitaireBoard() {
    	int PileSum=0;							//total numbers of card on the board
    	for (int i=0; i<pileLength; i++) {
    		if (cardPile[i] <=0 || cardPile[i] > CARD_TOTAL) {
    			return false;
    		}
    		PileSum += cardPile[i];
    	}
    	if (PileSum != CARD_TOTAL) {
    		return false;
    	}
      
    	return true;  
    }	
   

    // <add any additional private methods here>

}
