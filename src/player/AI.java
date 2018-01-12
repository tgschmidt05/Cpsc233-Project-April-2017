package player;

/**
 * @author     Jin Myoung Song <song.jaywalker@gmail.com>
 * @version    1.1
 * @since      2017-04-08
 */
public class AI extends Player {

  private boolean isOccupied;
  private boolean isLeftOccupied;
  private boolean isRightOccupied;


  /**
   * Constructor that takes 3 parameters
   * @param aRowSize is the row size of the grid for purposes player positioning
   * @param aColSize is the column size of the grid for the purposes of player positioning
   * @param aPlayerColor is the String that determines the player's color
   */
  public AI(int aPlayerNumber, int aRowSize, int aColSize, String aPlayerColor) {
    super(aPlayerNumber, aRowSize, aColSize, aPlayerColor);
  }

  /**
   * Checks for obstacle in direction of head
   * @return isOccupied (boolean)
   */
  private boolean checkFront() {

    switch(moveDir) {
      case UP:
      if ((super.getCurRow() == 0) || (grid[super.getCurRow() - 1][super.getCurCol()] != " ")) {
        isOccupied = true;
      } else {
        isOccupied = false;
      }
      break;

      case RIGHT:
      if ((super.getCurCol() == grid.length - 1) || (grid[super.getCurRow()][super.getCurCol() + 1] != " ")) {
        isOccupied = true;
      } else {
        isOccupied = false;
      }
      break;

      case DOWN:
      if ((super.getCurRow() == grid.length - 1) || (grid[super.getCurRow() + 1][super.getCurCol()] != " ")) {
        isOccupied = true;
      } else {
        isOccupied = false;
      }
      break;

      case LEFT:
      if ((super.getCurCol() == 0) || (grid[super.getCurRow()][super.getCurCol() - 1] != " ")) {
        isOccupied = true;
      } else {
        isOccupied = false;
      }
      break;
    }
    return isOccupied;
  }

  /**
   * Checks for obstacle in direction LEFT of head
   * @return isLeftOccupied (boolean)
   */
  private boolean checkLeft() {
    switch(moveDir) {
      case UP:
      if ((super.getCurCol() == 0) || (grid[super.getCurRow()][super.getCurCol() - 1] != " ")) {
        isLeftOccupied = true;
      } else {
        isLeftOccupied = false;
      }
      break;

      case RIGHT:
      if ((super.getCurRow() == 0) || (grid[super.getCurRow() - 1][super.getCurCol()] != " ")) {
        isLeftOccupied = true;
      } else {
        isLeftOccupied = false;
      }
      break;

      case DOWN:
      if ((super.getCurCol() == grid.length - 1) || (grid[super.getCurRow()][super.getCurCol() + 1] != " ")){
        isLeftOccupied = true;
      } else {
        isLeftOccupied = false;
      }
      break;

      case LEFT:
      if ((super.getCurRow() == grid.length - 1) || (grid[super.getCurRow() + 1][super.getCurCol()] != " ")) {
        isLeftOccupied = true;
      } else {
        isLeftOccupied = false;
      }
      break;
    }
    return isLeftOccupied;
  }

  /**
   * Checks for obstacle in direction RIGHT of head
   * @return isRightOccupied (boolean)
   */
  private boolean checkRight() {
    switch(moveDir) {
      case UP:
      if ((super.getCurCol() == grid.length - 1) || (grid[super.getCurRow()][super.getCurCol() + 1] != " ")) {
        isRightOccupied = true;
      } else {
        isRightOccupied = false;
      }
      break;

      case RIGHT:
      if ((super.getCurRow() == grid.length - 1) || (grid[super.getCurRow() + 1][super.getCurCol()] != " ")) {
        isRightOccupied = true;
      } else {
        isRightOccupied = false;
      }
      break;

      case DOWN:
      if ((super.getCurCol() == 0) || (grid[super.getCurRow()][super.getCurCol() - 1] != " ")) {
        isRightOccupied = true;
      } else {
        isRightOccupied = false;
      }
      break;

      case LEFT:
      if ((super.getCurRow() == 0) || (grid[super.getCurRow() - 1][super.getCurCol()] != " ")) {
        isRightOccupied = true;
      } else {
        isRightOccupied = false;
      }
      break;
    }
    return isRightOccupied;
  }

  /**
   * Counts number of obstacles in each side of head; if right is greater, returns true
   * @return True/False
   */
  private boolean decideDirection() {
    int leftObstacleCount = 0;
    int rightObstacleCount = 0;
    for (int rowCount = 0; rowCount < grid.length; rowCount++) {
      for (int colCount = 0; colCount < grid.length; colCount++) {
        switch (moveDir) {
          case UP:
          if ((colCount < super.getCurCol()) && (grid[rowCount][colCount] != " ")) {
            leftObstacleCount++;
          } else if ((colCount > super.getCurCol()) && (grid[rowCount][colCount] != " ")) {
            rightObstacleCount++;
          }
          break;

          case RIGHT:
          if ((rowCount < super.getCurRow()) && (grid[rowCount][colCount] != " ")) {
            leftObstacleCount++;
          } else if ((rowCount > super.getCurRow()) && (grid[rowCount][colCount] != " ")) {
            rightObstacleCount++;
          }
          break;

          case DOWN:
          if ((colCount > super.getCurCol()) && (grid[rowCount][colCount] != " ")) {
            leftObstacleCount++;
          } else if ((colCount < super.getCurCol()) && (grid[rowCount][colCount] != " ")) {
            rightObstacleCount++;
          }
          break;

          case LEFT:
          if ((rowCount > super.getCurRow()) && (grid[rowCount][colCount] != " ")) {
            leftObstacleCount++;
          } else if ((rowCount < super.getCurRow()) && (grid[rowCount][colCount] != " ")) {
            rightObstacleCount++;
          }
          break;
        }
      }
    }
    return rightObstacleCount >= leftObstacleCount;
  }

  /**
   * Changes the value of moveDir according to state of occupancy
   * @param occupiedLeft (boolean), occupiedRight (boolean)
   * @return moveDir
   */
  private MoveDir switchMoveDir(boolean occupiedLeft, boolean occupiedRight) {

    if ((occupiedLeft) &&(!occupiedRight)) {
      if (moveDir == MoveDir.LEFT) {
        moveDir = MoveDir.UP;
      } else if (moveDir == MoveDir.UP) {
        moveDir = MoveDir.RIGHT;
      } else if (moveDir == MoveDir.RIGHT) {
        moveDir = MoveDir.DOWN;
      } else if (moveDir == MoveDir.DOWN) {
        moveDir = MoveDir.LEFT;
      }

    } else if ((!occupiedLeft) && (occupiedRight)) {
      if (moveDir == MoveDir.LEFT) {
        moveDir = MoveDir.DOWN;
      } else if (moveDir == MoveDir.DOWN) {
        moveDir = MoveDir.RIGHT;
      } else if (moveDir == MoveDir.RIGHT) {
        moveDir = MoveDir.UP;
      } else if (moveDir == MoveDir.UP) {
        moveDir = MoveDir.LEFT;
      }
    }
    return moveDir;
  }

  /**
   * Changes the value of moveDir according number of occupied blocks in each side
   * @param sideComparison (boolean)
   * @return moveDir
   */
  private MoveDir switchMoveDir(boolean sideComparison) {
    if (sideComparison) {
      moveDir = this.switchMoveDir(false, true);
    } else {
      moveDir = this.switchMoveDir(true, false);
    }
    return moveDir;
  }

  /**
   * <<<Call this method only>>>
   * @param aGrid refers to the string grid which the players move on
   * @return void
   */
  public void moveAI(String[][] aGrid) {
    super.copyGrid(aGrid);
    
    isOccupied = this.checkFront();

    if (isOccupied) {
      isOccupied = this.checkLeft();
      isRightOccupied = this.checkRight();

      super.moveDir = switchMoveDir(isLeftOccupied, isRightOccupied);

      if ((!isLeftOccupied) && (!isRightOccupied)) {
    	  super.moveDir = switchMoveDir(this.decideDirection());
        
      }
    }
    super.basicMove();
  }
}
