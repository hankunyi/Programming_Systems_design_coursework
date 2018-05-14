// Name: Hankun Yi
// USC NetID: hankunyi
// CS 455 PA1
// Fall 2017

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

/**
 * A component that draw three bars and their labels.
 * The bars are to represent the outcomes of the coin toss simulator
 * 
 */

public class CoinSimComponent extends JComponent
{
	private static final int BAR_WIDTH = 50;
	private static final int VERTICAL_BUFFER = 50;
	private int width_buffer;
	private double scale;
	private String label_TwoHeads,label_TwoTails,label_HeadTail;
	private int bottom;
	private CoinTossSimulator coin;
	private int numTwoHeads, numTwoTails, numHeadTail, numTrials;
	private int TwoHeads_scale, TwoTails_scale, HeadTail_scale;   //The proportion of each outcome
	private int heightOfLabel;
	
	
	/**
	 * Create a CoinSimComponent with a coin toss simulator with specified trials done
	 *
	 * @param trial numbers of trial already done by toss simulator
	 */
	public CoinSimComponent(int trial) {
		coin= new CoinTossSimulator();
		coin.run(trial);
		numTrials = coin.getNumTrials();
		numTwoHeads = coin.getTwoHeads();
		numTwoTails = coin.getTwoTails();
		numHeadTail = coin.getHeadTails();
		TwoHeads_scale = (int)Math.round(((double)(numTwoHeads) / (double)(numTrials) * 100));
		TwoTails_scale = (int)Math.round(((double)(numTwoTails) / (double)(numTrials) * 100));
		HeadTail_scale = (int)Math.round(((double)(numHeadTail) / (double)(numTrials) * 100));
	}
	public void paintComponent(Graphics g)
	{
		//Recover Graphics 2D
		Graphics2D g2 = (Graphics2D) g;
		
		label_TwoHeads = "Two Heads: " + numTwoHeads + " (" + TwoHeads_scale + "%)";
		label_TwoTails = "Two Tails: " + numTwoTails + " (" + TwoTails_scale + "%)";
		label_HeadTail = "A Head and a Tail: " + numHeadTail + " (" + HeadTail_scale + "%)";
		
		//Get features of label
		Font font = g2.getFont();
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D labelBounds = font.getStringBounds(label_TwoHeads, context);
		heightOfLabel = (int)Math.round(labelBounds.getHeight());
		//Get parameters of Bar
		width_buffer=(int)(getWidth() - 3*BAR_WIDTH)/4;
		if (width_buffer <=0) {width_buffer = 0;}
		scale=((double)(getHeight() - 2*VERTICAL_BUFFER)-heightOfLabel)/numTrials;
		bottom=(int)(getHeight()-VERTICAL_BUFFER);
		
		//Construct the Bar
		Bar bar1 = new Bar (bottom, width_buffer,BAR_WIDTH, numTwoHeads,scale, Color.RED, label_TwoHeads);
		Bar bar2 = new Bar (bottom, width_buffer*2+BAR_WIDTH,BAR_WIDTH, numHeadTail,scale, Color.GREEN, label_HeadTail);
		Bar bar3 = new Bar (bottom, width_buffer*3+2*BAR_WIDTH,BAR_WIDTH, numTwoTails, scale, Color.BLUE, label_TwoTails);
		// Draw the Bar
		bar1.draw(g2);
		bar2.draw(g2);
		bar3.draw(g2);
		

	}
}