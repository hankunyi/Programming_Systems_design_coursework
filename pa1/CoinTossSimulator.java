// Name: Hankun Yi
// USC NetID: hankunyi
// CS 455 PA1
// Fall 2017

import java.util.Random;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {
	private int Trials_num;
	private int TwoHeads_num;
	private int TwoTails_num;
	private int HeadTails_num;
	private Random generator;


   /**
      Creates a coin toss simulator with no trials done yet.
    */
   public CoinTossSimulator() {
	   Trials_num = 0;
	   TwoHeads_num = 0;
	   TwoTails_num = 0;
	   HeadTails_num = 0;
	   generator = new Random();
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
	   if (numTrials >= 1) {
		   int ran1,ran2;
		   for (int i=0; i<numTrials; i++) {
			   ran1=generator.nextInt(2);
			   ran2=generator.nextInt(2);
			   if(ran1==0 && ran2==0) {TwoHeads_num ++;}
			   else if(ran1==1 && ran2==1) {TwoTails_num++;}
			   else {HeadTails_num++;}
			   Trials_num++;
		  		   
		   }
 
	   }
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return Trials_num; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return TwoHeads_num; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return TwoTails_num; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return HeadTails_num; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
	   Trials_num = 0;
	   TwoHeads_num = 0;
	   TwoTails_num = 0;
	   HeadTails_num = 0;

   }

}
