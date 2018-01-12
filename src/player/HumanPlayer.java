package player;

/**
 * @author Ga Hyung Kim
 * @since 2017-04-08
 * This class represents the human player. The human player moves according 
 * to the key pressed by the user and when it moves toward the block that is 
 * occupied, it will die. 
 */
public class HumanPlayer extends Player {
	private KeyConfiguration keyInput;
  
  /**
   * Constructor takes 4 arguments and this invokes the constructor of the 
   * parent class.
   * @param aPlayerNumber is the number assigned to the player
   * @param aRowSize is the row size of the grid 
   * @param aColSize is the column size of the grid
   * @param aPlayerColor is the color of the player's trace on the grid
   */  
  public HumanPlayer(int aPlayerNumber, int aRowSize, int aColSize, String aPlayerColor) {
      super(aPlayerNumber,aRowSize,aColSize,aPlayerColor);
      keyInput = new KeyConfiguration(aPlayerNumber, super.previousMoveDir);
  }
  
  public KeyConfiguration getKeyInput() {
	  return keyInput;
  }
  
  /**
   * This method receives the user's key input and changes the direction of the
   * player. 
   * @param keyPressed is the key pressed by the user
   */
  public void decideDir() {
    switch (keyInput.getKeyPressed()) {
      case "UP":
      moveDir = MoveDir.UP;
      break;

      case "RIGHT":
      moveDir = MoveDir.RIGHT;
      break;

      case "DOWN":
      moveDir = MoveDir.DOWN;
      break;

      case "LEFT":
      moveDir = MoveDir.LEFT;
      break;
    }
  }
  
  /**
   * This method moves the player. First decide the direction where to move 
   * and moves to that direction if the player is still alive.
   * @param keyPressed 
   */
  public void movePlayer() {
    decideDir();
    if (!getPlayerDead()) {
      basicMove();
    }
  }
}