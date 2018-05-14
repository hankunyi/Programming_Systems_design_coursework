// Name: Hankun Yi
// USC NetID: hankunyi
// CS 455 PA4
// Fall 2017

/**
 * A ScoredTable give the information about how much each scrabble letter is worth.
 */

public class ScoreTable {
	private int [] scoreArray = new int [26];
	
	public ScoreTable() {
		scoreArray[0]=1;
		scoreArray[1]=3;
		scoreArray[2]=3;
		scoreArray[3]=2;
		scoreArray[4]=1;
		scoreArray[5]=4;
		scoreArray[6]=2;
		scoreArray[7]=4;
		scoreArray[8]=1;
		scoreArray[9]=8;
		scoreArray[10]=5;
		scoreArray[11]=1;
		scoreArray[12]=3;
		scoreArray[13]=1;
		scoreArray[14]=1;
		scoreArray[15]=3;
		scoreArray[16]=10;
		scoreArray[17]=1;
		scoreArray[18]=1;
		scoreArray[19]=1;
		scoreArray[20]=1;
		scoreArray[21]=4;
		scoreArray[22]=4;
		scoreArray[23]=8;
		scoreArray[24]=4;
		scoreArray[25]=10;
	}
	

	/*
	 * return the total score for srcabble words.
	 */
	public int getScore(String s) {
		String lowCase = s.toLowerCase();
		int sumScore=0;
		for(int i=0; i<lowCase.length();i++) {
			sumScore += scoreArray[lowCase.charAt(i)-'a'];
		}
		return sumScore;
	}
	
	
	
	
	
	
}