package player;
import java.awt.Color;
/**
 * @author Ga Hyung Kim
 * @since 2017-04-08
 * This class manages the movement of the player.
 * When the user presses the key, this class checks if the wall in front of the
 * player is occupied or not and if it is not occupied, player moves to the
 * direction where the user wants it to be. If the wall is occupied,
 * player is dead.
 */
public class Player {

  /**
   * Enumeration for the direction of move.
   * This makes sure player only moves to 4 directions which are
   * up, right, down, left.
   */
  public enum MoveDir {
    UP, RIGHT, DOWN, LEFT
  }

  private int curRow;
  private int curCol;
  private int newRow;
  private int newCol;
  private int rowSize;
  private int colSize;
  private int playerNumber;
  private String playerChar;
  private String trailChar;
  private Color playerColor;
  private boolean playerDead;
  protected String previousMoveDir;
  MoveDir moveDir;
  protected String[][] grid;

  /**
   * Constructor that takes 4 parameters 
   * @param aPlayerNumber is the number assigned to the player
   * @param aRowSize is the row size of the grid 
   * @param aColSize is the column size of the grid
   * @param aPlayerColor is the color of the player's trace on the grid
   */
  public Player(int aPlayerNumber, int aRowSize, int aColSize, String aPlayerColor) {

	rowSize = aRowSize;
	colSize = aColSize;
    playerNumber = aPlayerNumber;
    playerDead = false;
      
    if (aPlayerColor.equals("pink")) {
		playerColor = Color.PINK;
	}
	else if (aPlayerColor.equals("blue")) {
		playerColor = Color.BLUE;
	}
	else if (aPlayerColor.equals("magenta")) {
		playerColor = Color.MAGENTA;
	}
	else if (aPlayerColor.equals("orange")) {
		playerColor = Color.ORANGE;
	}
	else if (aPlayerColor.equals("red")) {
		playerColor = Color.RED;
	}
	else if (aPlayerColor.equals("cyan")) {
		playerColor = Color.CYAN;
	}
	else if (aPlayerColor.equals("green")) {
		playerColor = Color.GREEN;
	}
	else if (aPlayerColor.equals("gray")) {
		playerColor = Color.GRAY;
	}
	else if (aPlayerColor.equals("white")) {
		playerColor = Color.WHITE;
	}
   setInitialState();
  }

  /**
   * This method sets the initial state of the player.
   * For the player one, initial position is (rowSize/2,colSize/4) on the grid
   * and it will move to the right at the beginning. Player one will leave the 
   * trace of string "+" and the head character will be "P".
   * for the player two, initial position is (rowSize/2,colSize-colSize/4)
   * on the grid and it will move to the left at the beginning. Player two will 
   * leave "-" as a trace and the head character will be "A".
   */
  public void setInitialState() {
    //both players start at the middle of the grid
    curRow = rowSize/2;
    newRow = curRow;
    
    if (playerNumber == 1) {
      curCol = (colSize-(colSize/4));
      newCol = curCol;
      moveDir = MoveDir.LEFT;
      previousMoveDir = "LEFT";
      playerChar = "P";
      trailChar = "+";
    } else {
      curCol = colSize/4;
      newCol = curCol;
      moveDir = MoveDir.RIGHT;
      previousMoveDir = "RIGHT";
      playerChar = "A";
      trailChar = "-";
    }
  } 
  
  /**
   * getter method
   * @return current row of the player
   */
  public int getCurRow() {
    return curRow;
  }

  /**
   * getter method
   * @return current column of the player
   */
  public int getCurCol() {
    return curCol;
  }

  /**
   * getter method
   * @return new row of the player (after the movement)
   */
  public int getNewRow() {
    return newRow;
  }

  /**
   * getter method
   * @return new column of the player (after the movement)
   */
  public int getNewCol() {
    return newCol;
  }

  /**
   * getter method
   * @return state of the player (dead or not dead)
   */
  public boolean getPlayerDead() {
    return playerDead;
  }

  /**
   * getter method
   * @return the character that will represent the player and leave the trail
   */
  public String getPlayerChar() {
    return playerChar;
  }

  /**
   * getter method
   * @return trail character that will be the trace of the player's movement
   */
  public String getTrailChar() {
    return trailChar;
  }
  
  /**
   * getter method
   * @return the color of the player which is the color of the player's trail
   */
  public Color getPlayerColor() {
      return playerColor;
  }

  /**
   * This method copies the grid from the grid class. 
   * @param aGrid is a string grid where the players are moving
   */
  public void copyGrid(String[][] aGrid) {
    grid = new String[rowSize][colSize];
    for (int countOne = 0; countOne < rowSize; countOne++) {
      for (int countTwo = 0; countTwo < colSize; countTwo++) {
        grid[countOne][countTwo] = aGrid[countOne][countTwo];
      }
    }
  }

  /**
   * This method changes the coordinate of the player on the grid.
   */
  public void basicMove() {
    switch (moveDir) {
      case UP:
      newRow = curRow - 1;
      newCol = curCol;
      break;

      case RIGHT:
      newRow = curRow;
      newCol = curCol + 1;
      break;

      case DOWN:
      newRow = curRow + 1;
      newCol = curCol;
      break;

      case LEFT:
      newRow = curRow;
      newCol = newCol - 1;
      break;
    }
  }

  /**
   * This method updates the coordinate of the player.
   * When player moves, player's current position becomes new position.
   */
  public void updatePosition() {
    curRow = getNewRow();
    curCol = getNewCol();
  }

  /**
   * This method detects the wall in front of the player. It will first copy
   * the grid where the players are actually moving. 
   * If the wall in front of the player is occupied, player is dead.
   * @param aGrid is the grid where the players are moving
   */
  public void detectWall(String[][] aGrid) {
    copyGrid(aGrid);
    
    if (!playerDead) {
    	if (grid[newRow][newCol] != " ") {
    		playerDead = true;
    	}
    }
  }
  
  public void detectBounds() {
	  if ((newRow + 1 > rowSize) || (newRow < 0)) {
		  playerDead = true;
	  }
	  else if ((newCol + 1 > colSize) || (newCol < 0)) {
		  playerDead = true;
	  }
  }
  
}
