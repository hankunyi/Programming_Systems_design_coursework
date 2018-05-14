// Name:	Hankun Yi
// USC loginid: hankunyi
// CS 455 PA3
// Fall 2017

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JComponent;

/**
   MazeComponent class
   
   A component that displays the maze and path through it if one has been found.
*/
public class MazeComponent extends JComponent
{

   private static final int START_X = 10; // top left of corner of maze in frame
   private static final int START_Y = 10;
   private static final int BOX_WIDTH = 20;  // width and height of one maze "location"
   private static final int BOX_HEIGHT = 20;
   private static final int INSET = 2;  
                    // how much smaller on each side to make entry/exit inner box
   
   private boolean[][] mazeCode;	//2-dimension array that store maze data
   private int entryRow;	//row number of entrance
   private int entryCol;	//column number of entrance
   private int exitRow;		//row number of exit
   private int exitCol;		//column number of exit
   private LinkedList<MazeCoord> mazePath;	//the linklist that store the path of maze
   
   /**
      Constructs the component.
      @param maze   the maze to display
   */
   public MazeComponent(Maze maze) 
   {   
   	mazeCode = new boolean[maze.numRows()][maze.numCols()];
   	for(int i=0; i<maze.numRows();i++) {
   		for(int j=0; j<maze.numCols();j++) {
   				mazeCode[i][j] = maze.hasWallAt(new MazeCoord(i,j))?maze.WALL:maze.FREE;
   		}
   	}
      entryRow = maze.getEntryLoc().getRow();
      entryCol = maze.getEntryLoc().getCol();
      exitRow = maze.getExitLoc().getRow();
      exitCol = maze.getExitLoc().getCol();
      mazePath = maze.getPath();
   }

   
   /**
     Draws the current state of maze including the path through it if one has
     been found.
     @param g the graphics context
   */
   public void paintComponent(Graphics g)
   {
   	Graphics2D g2 = (Graphics2D) g;
   	for(int i=0; i<mazeCode.length; i++) {
   		for(int j=0; j<mazeCode[0].length; j++) {
   			//draw the wall
   			if(mazeCode[i][j]) {
   				g2.setColor(Color.BLACK);
   				Rectangle wallBlock = new Rectangle(START_X+j*BOX_WIDTH, START_Y+i*BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
   				g2.fill(wallBlock);
   			}
   			//draw free place
   			else {
   				g2.setColor(Color.WHITE);
   				Rectangle freeBlock = new Rectangle(START_X+j*BOX_WIDTH, START_Y+i*BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
   				g2.fill(freeBlock);
   			}
   		}
   	}
   	//draw entrance
   	g2.setColor(Color.YELLOW);
   	Rectangle entryBlock = new Rectangle(START_X+entryCol*BOX_WIDTH+INSET, START_Y+entryRow*BOX_HEIGHT+INSET, BOX_WIDTH-2*INSET, BOX_HEIGHT-2*INSET );
   	g2.fill(entryBlock);
   	//draw exit
   	g2.setColor(Color.GREEN);
   	Rectangle exitBlock = new Rectangle(START_X+exitCol*BOX_WIDTH+INSET, START_Y+exitRow*BOX_HEIGHT+INSET, BOX_WIDTH-2*INSET, BOX_HEIGHT-2*INSET );
   	g2.fill(exitBlock);
   	// draw Path
   	if(!mazePath.isEmpty()) {
   		ListIterator <MazeCoord> iterator = mazePath.listIterator();
   		while(iterator.hasNext()) {
   			MazeCoord currentLoc = iterator.next();
   			if(iterator.hasNext()) {
   			MazeCoord nextLoc = iterator.next();
   			Point2D.Double from = new Point2D.Double(START_X+currentLoc.getCol()*BOX_WIDTH+BOX_WIDTH/2, START_Y+currentLoc.getRow()*BOX_HEIGHT+BOX_HEIGHT/2);
   			Point2D.Double to = new Point2D.Double(START_X+nextLoc.getCol()*BOX_WIDTH+BOX_WIDTH/2, START_Y+nextLoc.getRow()*BOX_HEIGHT+BOX_HEIGHT/2);
   			Line2D.Double segment = new Line2D.Double(from,to);
   			g2.setColor(Color.BLUE);
   			g2.draw(segment);
   			iterator.previous();
   			}
   		}
   	}	
   }
}



