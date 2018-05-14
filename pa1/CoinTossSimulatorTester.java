// Name: Hankun Yi
// USC NetID: hankunyi
// CS 455 PA1
// Fall 2017

/**
 * class CoinTossSimulatorTester
 * 
 * To test the coinTossSimulator class
 * When run the program, the console will show the result and expected result.
 * The trials of coin toss simulator is defaulted.
 */

public class CoinTossSimulatorTester
{
	public static void main(String[] args)
	
	{
		boolean ans;
		CoinTossSimulator coin= new CoinTossSimulator();
		System.out.println("After constructor:");
		System.out.println("Number of trials [exp:0]: " + coin.getNumTrials());
		System.out.println("Two-head tosses: " + coin.getTwoHeads());
		System.out.println("Two-tail tosses: " + coin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coin.getHeadTails());
		ans = (coin.getNumTrials() == coin.getHeadTails()+coin.getTwoHeads()+coin.getTwoTails());
		System.out.println("Tosses add up correctly? " + ans);
		System.out.println();
		
		coin.run(1);
		System.out.println("After run(1):");
		System.out.println("Number of trials [exp:1]: " + coin.getNumTrials());
		System.out.println("Two-head tosses: " + coin.getTwoHeads());
		System.out.println("Two-tail tosses: " + coin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coin.getHeadTails());
		ans = (coin.getNumTrials() == coin.getHeadTails()+coin.getTwoHeads()+coin.getTwoTails());
		System.out.println("Tosses add up correctly? " + ans);
		System.out.println();
		
		coin.run(10);
		System.out.println("After run(10):");
		System.out.println("Number of trials [exp:11]: " + coin.getNumTrials());
		System.out.println("Two-head tosses: " + coin.getTwoHeads());
		System.out.println("Two-tail tosses: " + coin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coin.getHeadTails());
		ans = (coin.getNumTrials() == coin.getHeadTails()+coin.getTwoHeads()+coin.getTwoTails());
		System.out.println("Tosses add up correctly? " + ans);
		System.out.println();
		
		coin.run(100);
		System.out.println("After run(100):");
		System.out.println("Number of trials [exp:111]: " + coin.getNumTrials());
		System.out.println("Two-head tosses: " + coin.getTwoHeads());
		System.out.println("Two-tail tosses: " + coin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coin.getHeadTails());
		ans = (coin.getNumTrials() == coin.getHeadTails()+coin.getTwoHeads()+coin.getTwoTails());
		System.out.println("Tosses add up correctly? " + ans);
		System.out.println();
		
		coin.run(500);
		System.out.println("After run(500):");
		System.out.println("Number of trials [exp:611]: " + coin.getNumTrials());
		System.out.println("Two-head tosses: " + coin.getTwoHeads());
		System.out.println("Two-tail tosses: " + coin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coin.getHeadTails());
		ans = (coin.getNumTrials() == coin.getHeadTails()+coin.getTwoHeads()+coin.getTwoTails());
		System.out.println("Tosses add up correctly? " + ans);
		System.out.println();
		
		
		coin.reset();
		System.out.println("After reset:");
		System.out.println("Number of trials [exp:0]: " + coin.getNumTrials());
		System.out.println("Two-head tosses: " + coin.getTwoHeads());
		System.out.println("Two-tail tosses: " + coin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coin.getHeadTails());
		ans = (coin.getNumTrials() == coin.getHeadTails()+coin.getTwoHeads()+coin.getTwoTails());
		System.out.println("Tosses add up correctly? " + ans);
		System.out.println();
		
		coin.run(1000);
		System.out.println("After run(1000):");
		System.out.println("Number of trials [exp:1000]: " + coin.getNumTrials());
		System.out.println("Two-head tosses: " + coin.getTwoHeads());
		System.out.println("Two-tail tosses: " + coin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coin.getHeadTails());
		ans = (coin.getNumTrials() == coin.getHeadTails()+coin.getTwoHeads()+coin.getTwoTails());
		System.out.println("Tosses add up correctly? " + ans);
		System.out.println();
		
		coin.run(5000);
		System.out.println("After run(5000):");
		System.out.println("Number of trials [exp:6000]: " + coin.getNumTrials());
		System.out.println("Two-head tosses: " + coin.getTwoHeads());
		System.out.println("Two-tail tosses: " + coin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coin.getHeadTails());
		ans = (coin.getNumTrials() == coin.getHeadTails()+coin.getTwoHeads()+coin.getTwoTails());
		System.out.println("Tosses add up correctly? " + ans);
		System.out.println();
		
		coin.run(10000);
		System.out.println("After run(10000):");
		System.out.println("Number of trials [exp:16000]: " + coin.getNumTrials());
		System.out.println("Two-head tosses: " + coin.getTwoHeads());
		System.out.println("Two-tail tosses: " + coin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coin.getHeadTails());
		ans = (coin.getNumTrials() == coin.getHeadTails()+coin.getTwoHeads()+coin.getTwoTails());
		System.out.println("Tosses add up correctly? " + ans);
		System.out.println();
		

	}
}