// Name: Hankun Yi
// USC loginid: hankunyi
// CS 455 PA3
// Fall 2017

import java.util.LinkedList;
import java.util.ListIterator;


/**
   Maze class

   Stores information about a maze and can find a path through the maze
   (if there is one).
   
   Assumptions about structure of the maze, as given in mazeData, startLoc, and endLoc
   (parameters to constructor), and the path:
     -- no outer walls given in mazeData -- search assumes there is a virtual 
        border around the maze (i.e., the maze path can't go outside of the maze
        boundaries)
     -- start location for a path is maze coordinate startLoc
     -- exit location is maze coordinate exitLoc
     -- mazeData input is a 2D array of booleans, where true means there is a wall
        at that location, and false means there isn't (see public FREE / WALL 
        constants below) 
     -- in mazeData the first index indicates the row. e.g., mazeData[row][col]
     -- only travel in 4 compass directions (no diagonal paths)
     -- can't travel through walls
     
	@param mazeValue the maze to search.
	@param locVisited the 2-dimensional array that store whether the location has been visited
   @param startPos the location in maze to start the search (not necessarily on an edge)
   @param exitPos the "exit" location of the maze (not necessarily on an edge)
   @param mazePath a linked list that store one path from entrance to exit of the maze
   PRE: 0 <= startPos.getRow() < mazeValue.length and 0 <= startPos.getCol() < mazeValue[0].length
   and 0 <= startPos.getRow() < mazeValue.length and 0 <= startPos.getCol() < mazeValue[0].length
	
 */

public class Maze {
   
   public static final boolean FREE = false;
   public static final boolean WALL = true;
   
   private boolean[][] mazeValue;	
   private boolean[][] locVisited;
   private MazeCoord startPos;
   private MazeCoord endPos;
   private LinkedList<MazeCoord> mazePath = new LinkedList<MazeCoord>();
   
  

   /**
      Constructs a maze.
      @param mazeData the maze to search.  See general Maze comments above for what
      goes in this array.
      @param startLoc the location in maze to start the search (not necessarily on an edge)
      @param exitLoc the "exit" location of the maze (not necessarily on an edge)
      PRE: 0 <= startLoc.getRow() < mazeData.length and 0 <= startLoc.getCol() < mazeData[0].length
         and 0 <= endLoc.getRow() < mazeData.length and 0 <= endLoc.getCol() < mazeData[0].length

    */
   public Maze(boolean[][] mazeData, MazeCoord startLoc, MazeCoord exitLoc) {
   	mazeValue = mazeData;
   	locVisited = new boolean[mazeData.length][mazeData[0].length];
   	startPos = startLoc;
   	endPos = exitLoc;
   }


   /**
      Returns the number of rows in the maze
      @return number of rows
   */
   public int numRows() {
      return mazeValue.length;
   }

   
   /**
      Returns the number of columns in the maze
      @return number of columns
   */   
   public int numCols() {
      return mazeValue[0].length;
   } 
 
   
   /**
      Returns true iff there is a wall at this location
      @param loc the location in maze coordinates
      @return whether there is a wall here
      PRE: 0 <= loc.getRow() < numRows() and 0 <= loc.getCol() < numCols()
   */
   public boolean hasWallAt(MazeCoord loc) {
      return mazeValue[loc.getRow()][loc.getCol()];
   }
   

   /**
      Returns the entry location of this maze.
    */
   public MazeCoord getEntryLoc() {
      return startPos;   // DUMMY CODE TO GET IT TO COMPILE
   }
   
   
   /**
     Returns the exit location of this maze.
   */
   public MazeCoord getExitLoc() {
      return endPos;   // DUMMY CODE TO GET IT TO COMPILE
   }

   
   /**
      Returns the path through the maze. First element is start location, and
      last element is exit location.  If there was not path, or if this is called
      before a call to search, returns empty list.

      @return the maze path
    */
   public LinkedList<MazeCoord> getPath() {
   	 		 return mazePath;
   	}
   	

   /**
      Find a path from start location to the exit location (see Maze
      constructor parameters, startLoc and exitLoc) if there is one.
      Client can access the path found via getPath method.

      @return whether a path was found.
    */
   public boolean search()  {    
   	searchPath(mazePath,startPos);
      return (!mazePath.isEmpty()); 
   }
   /**
   Maintain a linkedlist of Path, and to find the path of maze recursively. 
   if the current location is available, add it to list, and search for 
   the point around it, otherwise return false. 
   
   @return whether the location should be added to the list of path.
    */   
   private boolean searchPath(LinkedList<MazeCoord> currentPath, MazeCoord currentLoc){
   	int currentRow = currentLoc.getRow();
   	int currentCol = currentLoc.getCol();
   	if (!isValidLoc(currentLoc)) {
   		return false;
   	}
   	currentPath.addLast(currentLoc);
   	locVisited[currentRow][currentCol] = true;
   	if(currentRow == endPos.getRow() && currentCol == endPos.getCol()) {
   		return true;
   	}
   	else {
   		if (searchPath(currentPath, new MazeCoord(currentRow,currentCol+1))) {
   			return true;
   		}
   		if (searchPath(currentPath, new MazeCoord(currentRow+1,currentCol))) {
   			return true;
   		}
   		if (searchPath(currentPath, new MazeCoord(currentRow,currentCol-1))) {
   			return true;
   		}
   		if (searchPath(currentPath, new MazeCoord(currentRow-1,currentCol))) {
   			return true;
   		}
   	}
   	currentPath.removeLast();
   	locVisited[currentRow][currentCol] = false;
   	return false;
   }
   /**
   Judge whether the location is available to be visited. If the location is
	out of border, or has a wall on it, or has already been visited, than return false.
	
   @return whether a location is available for visit.
    */
   private boolean isValidLoc(MazeCoord currentLoc){
   	int currentRow = currentLoc.getRow();
   	int currentCol = currentLoc.getCol();
   	if( currentRow >= mazeValue.length || currentRow < 0 || currentCol >= mazeValue[0].length || currentCol < 0) {
   		return false;
   	}
   	else if (hasWallAt(currentLoc)) {
   		return false;
   	}
   	else if (locVisited[currentRow][currentCol]) {
   		return false;   		
   	}
   	else {
   		return true;
   	}
   }
}
