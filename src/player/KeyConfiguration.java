package player;
import java.awt.event.*;
/**
 * @author Ga Hyung Kim, JinMyoung Song
 * @since 2017-04-09
 * This class receives the key input of the user and decides the moving 
 * direction of the player.
 */
public class KeyConfiguration implements KeyListener {
    
    private String keyPressed;
    private int playerNumber;
    private String previousMoveDir;
    
    public KeyConfiguration (int aPlayerNumber, String initialKey) {
    	playerNumber = aPlayerNumber;
    	previousMoveDir = initialKey;
    	keyPressed = initialKey;
    }
    
    /**
     * getter method
     * @return the key pressed by the user ("UP","RIGHT","DOWN" or "LEFT")
     */
    public String getKeyPressed() {
        return keyPressed;
    }
    
    /**
     * This method gets the key code of the key user presses. And it changes 
     * the variable that will change the moving direction of the player.
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
    	if (playerNumber == 1) {
    		if (e.getKeyCode() == KeyEvent.VK_UP) {
    			keyPressed = "UP";
    			previousMoveDir = "UP";
    		} 
    		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
    			keyPressed = "RIGHT";
    			previousMoveDir = "RIGHT";
    		}
    		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
    			keyPressed = "DOWN";
    			previousMoveDir = "DOWN";
    		}
    		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
    			keyPressed = "LEFT";
    			previousMoveDir = "LEFT";
    		}
    		else {
    			keyPressed = previousMoveDir;
    		}
    	}
    	else {
    		if (e.getKeyCode() == KeyEvent.VK_A) {
    			keyPressed = "LEFT";
    			previousMoveDir = "LEFT";
    		}
    		if (e.getKeyCode() == KeyEvent.VK_D) {
    			keyPressed = "RIGHT";
    			previousMoveDir = "RIGHT";
    		}
    		if (e.getKeyCode() == KeyEvent.VK_S) {
    			keyPressed = "DOWN";
    			previousMoveDir = "DOWN";
    		}
    		if (e.getKeyCode() == KeyEvent.VK_W) {
    			keyPressed = "UP";
    			previousMoveDir = "UP";
    		}
    		else {
    			keyPressed = previousMoveDir;
    		}
    	}
    }
    
    @Override
    public void keyTyped(KeyEvent e) {    
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }   
}
