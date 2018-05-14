// Name: Hankun Yi
// USC NetID: hankunyi
// CS 455 PA1
// Fall 2017

import java.util.Scanner;
import javax.swing.JFrame;
/**
 * class CoinSimViewer
 * 
 * Show the outcomes of coin toss simulator with given trials by bar graph
 * 
 * When run this program, it will prompt for the number of trials to simulate.
 * Please enter a positive integer as the trial times.
 * 
 * The label of the bars will show how many trials had the specified outcome.
 */
public class CoinSimViewer{
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(800, 500);
		frame.setTitle("CoinSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.print("Enter number of trials: ");
		Scanner in = new Scanner(System.in);
		int trial = in.nextInt();
		while(trial <= 0) {
			System.out.println("ERROR: Number entered must be greater than 0.");
			System.out.print("Enter number of trials: ");
			trial = in.nextInt();
		}
		CoinSimComponent component = new CoinSimComponent(trial);
		frame.add(component);
		frame.setVisible(true);
	}
}