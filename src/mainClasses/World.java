package mainClasses;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import player.HumanPlayer; //TEMP
import player.AI; //TEMP

/**
 * @authors: Anna Chaykovska and Tobias Schmidt
 *
 * This class contains our 2d grid world and our main game gui code.
 * It also has the most important methods for our main game, that keep the
 * players and world in check.
 * 
 */
public class World extends TimerTask {
	
	private int rowSize;
	private int colSize;
	private String[][] grid;
	private CountDownLatch latch;
	private HumanPlayer player1 = null;
	private HumanPlayer player2 = null;
	private AI player2AI = null;
  	private int frameSize;
  	private int labelSize;
  	private Boolean gameOver;
  	private Boolean player1Win;
  	private Boolean isGameOverPresent;

  	//Grid frame
  	private JFrame frame = new JFrame();
  	private JPanel gridPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
  	private JLabel[][] labelGrid;

  	//Game over frame 
  	private JFrame endFrame = new JFrame();
  	private JPanel endGamePanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0)); // gets rid of a white border that would be there otherwise
  	
	public static final String gridPlayer1Letter = "P";
	public static final String gridPlayer2Letter = "A";
	public static final int obstacleFrequency = 1;
	
	/**
	* This constructor adds all the necessary data into world and creates both the frame and the 2d grid. 
	* It then makes the frame visible.
	*/
	public World(int inputRowSize, int inputColSize, HumanPlayer inputPlayer1, HumanPlayer inputPlayer2, CountDownLatch aLatch) {
		Random ranNum = new Random();
		rowSize = inputRowSize;
		colSize = inputColSize;
		player1 = inputPlayer1;
		player2 = inputPlayer2;
		latch = aLatch;
				
		grid = new String[rowSize][colSize];
		for (int newRowNum = 0; newRowNum < rowSize; newRowNum++) {
			for (int newColumnNum = 0; newColumnNum < colSize; newColumnNum++) {
				if (ranNum.nextInt(100) < obstacleFrequency) {
					grid[newRowNum][newColumnNum] = "x";
				}
				else {
				grid[newRowNum][newColumnNum] = " ";
				}
			}
		}
		for (int colCount = 0; colCount < colSize; colCount++) {
			grid[rowSize/2][colCount] = " ";
		}
		grid[rowSize/2][colSize/4] = gridPlayer1Letter;
		grid[rowSize/2][colSize-(colSize/4)] = gridPlayer2Letter;
		
		frameSize = 750;
  		labelSize = frameSize / rowSize;
  		labelGrid = new JLabel[rowSize][colSize];
  		gameOver = false;
  		isGameOverPresent = false;

  		frame.setSize(frameSize, frameSize);
    	frame.setUndecorated(true);
	    frame.setResizable(false);

	    // Sets the frame location in the center of the screen
	    frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.drawGrid();
    	frame.add(gridPanel);
    	frame.addKeyListener(player1.getKeyInput());
    	frame.addKeyListener(player2.getKeyInput());

    	frame.pack();
    	frame.setVisible(true);
	}
	
	/**
	* This constructor adds all the necessary data into world and creates both the frame and the 2d grid. 
	* It then makes the frame visible. It is an overloaded version of the first one.
	*/
	public World(int inputRowSize, int inputColSize, HumanPlayer inputPlayer1, AI inputPlayer2, CountDownLatch aLatch) {
		Random ranNum = new Random();
		rowSize = inputRowSize;
		colSize = inputColSize;
		player1 = inputPlayer1;
		player2AI = inputPlayer2;
		latch = aLatch;
		
		grid = new String[rowSize][colSize];
		for (int newRowNum = 0; newRowNum < rowSize; newRowNum++) {
			for (int newColumnNum = 0; newColumnNum < colSize; newColumnNum++) {
				if (ranNum.nextInt(100) < obstacleFrequency) {
					grid[newRowNum][newColumnNum] = "x";
				}
				else {
				grid[newRowNum][newColumnNum] = " ";
				}
			}
		}
		for (int colCount = 0; colCount < colSize; colCount++) {
			grid[rowSize/2][colCount] = " ";
		}
		grid[rowSize/2][colSize/4] = gridPlayer2Letter;
		grid[rowSize/2][colSize-(colSize/4)] = gridPlayer1Letter;
		
		frameSize = 750;
  		labelSize = frameSize / rowSize;
  		labelGrid = new JLabel[rowSize][colSize];
  		gameOver = false;
  		isGameOverPresent = false;

  		frame.setSize(frameSize, frameSize);
    	frame.setUndecorated(true);
	    frame.setResizable(false);

	    // Sets the frame location in the center of the screen
	    frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.drawGrid();
    	frame.add(gridPanel);
    	frame.addKeyListener(player1.getKeyInput());
    
    	frame.pack();
    	frame.setVisible(true);
	}
	
		
	/**
	* This method prints out all the characters of the world array.
	* It also puts the world in a border of dashes.
	* The world is rectangular in shape because the characters are taller then they are wide.
	* If this is a problem, feel free to tell me what to change.
	* UNUSED IN THIS VERSION.
	*/
	public void printWorld() {
		System.out.print(" ");
		for (int i = 0; i <= colSize; i++){
			System.out.print("-");
		}
		System.out.println("");
		for (int newRowNum = 0; newRowNum <= rowSize; newRowNum++) {
			System.out.print("|");
			for (int newColumnNum = 0; newColumnNum <= colSize; newColumnNum++) {
				System.out.print(grid[newRowNum][newColumnNum]);
			}
			System.out.println("|");
		}
		System.out.print(" ");
		for (int i = 0; i <= colSize; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}
	
	/**
	 * Getter methods for the class.
	 */
	public String[][] getGrid() {
		return grid;
	}
	
	public boolean getPlayer1Win() {
		return player1Win;
	}
	
	/**
	* Getter methods for frame and label sizes
	*/
	  	public int getFrameSize() {
	  		return frameSize;
	  	}

	  	public int getLabelSize() {
	  		return labelSize;
	  	}

	/**
	* Initializes the grid and places a JLabel in every element of the grid
	* Only to be used from the constructor
	*/
	  	private void drawGrid() {
	  		gridPanel.setLayout(new GridLayout(rowSize, colSize));
	    	for (int counterOne = 0; counterOne < rowSize; counterOne++) {
	    		for (int counterTwo = 0; counterTwo < colSize; counterTwo++) {
	    			labelGrid[counterOne][counterTwo] = new JLabel();
	        		gridPanel.add(labelGrid[counterOne][counterTwo]);
	        		labelGrid[counterOne][counterTwo].setBackground(new Color(12,12,28));
			        labelGrid[counterOne][counterTwo].setPreferredSize(new Dimension(labelSize, labelSize));
	    		    labelGrid[counterOne][counterTwo].setOpaque(true);
	    		}
	  		}
	  	}

	/**
	* Resets the color of the visual grid to the background color
	*/
	  	private void resetGridColor() {
	  		for (int counterOne = 0; counterOne < rowSize; counterOne++) {
	    		for (int counterTwo = 0; counterTwo < colSize; counterTwo++) {
	        		labelGrid[counterOne][counterTwo].setBackground(new Color(12,12,28));
	        		labelGrid[counterOne][counterTwo].setText("");
	    		}
	    	}
	  	}

	/**
	* Updates the GUI grid to the correct colors based on a 2D world array
	* @param 2D array that contains the current positions of the players and their trails
	* The head of the bike is shown by a 1 or a 2
	* Font used: Verdana
	*/
	  	public void updateGUIGrid() {
	  		resetGridColor();
	  		for (int counterOne = 0; counterOne < rowSize; counterOne++) {
	  			for (int counterTwo = 0; counterTwo < colSize; counterTwo++) {
	  				if (grid[counterOne][counterTwo] == "P") {
	        			labelGrid[counterOne][counterTwo].setBackground(player1.getPlayerColor());
	        			labelGrid[counterOne][counterTwo].setText("1");
						labelGrid[counterOne][counterTwo].setForeground(Color.black);
						labelGrid[counterOne][counterTwo].setFont(new Font("Verdana",1 , 15)); //Modify the last integer for text size
	        		}

	        		else if (grid[counterOne][counterTwo] == "+") {
	            		labelGrid[counterOne][counterTwo].setBackground(player1.getPlayerColor());
	            	}

	        		else if ((grid[counterOne][counterTwo] == "A") && (player2AI == null)) {
	            		labelGrid[counterOne][counterTwo].setBackground(player2.getPlayerColor());
	            		labelGrid[counterOne][counterTwo].setText(" 2");
						labelGrid[counterOne][counterTwo].setForeground(Color.black);
						labelGrid[counterOne][counterTwo].setFont(new Font("Verdana",1 , 14));
	            	}
	  				
	        		else if ((grid[counterOne][counterTwo] == "A") && (player2AI != null)) {
	            		labelGrid[counterOne][counterTwo].setBackground(player2AI.getPlayerColor());
	            		labelGrid[counterOne][counterTwo].setText(" 2");
						labelGrid[counterOne][counterTwo].setForeground(Color.black);
						labelGrid[counterOne][counterTwo].setFont(new Font("Verdana",1 , 14));
	            	}

	        		else if ((grid[counterOne][counterTwo] == "-") && (player2AI == null)) {
	          			labelGrid[counterOne][counterTwo].setBackground(player2.getPlayerColor());
	        		}
	  				
	  				else if ((grid[counterOne][counterTwo] == "-") && (player2AI != null)) {
	          			labelGrid[counterOne][counterTwo].setBackground(player2AI.getPlayerColor());
	        		}
	     
	        		else if (grid[counterOne][counterTwo] == "x") {
	        			labelGrid[counterOne][counterTwo].setBackground(Color.white);
	        		}
	  			}
	  		}
	  	}

	/**
	* Hides the grid and allows the program to show other frames
	*/
	  	public void hideGrid() {
	  		frame.dispose();
	  		endFrame.dispose();
	  	}

	/**
	* Makes a separate "Game Over" window pop up in the corner of the game frame 
	* @param true state sets the game over window, false deletes it
	* Calls for a reset of the gameboard colors 
	* Font used: Verdana
	*/
	  	public void setGameOver() {
	  		if ((isGameOverPresent == false) && (gameOver == true)) {
		  		resetGridColor();
		  		endGamePanel.setLayout(new GridLayout(2, 1));

		  		//Sets the "Game Over" part of the pop-up
	 			JLabel gameOver = new JLabel();
	 			gameOver.setText("Game Over");
		  		gameOver.setForeground(Color.white);
		  		gameOver.setBackground(new Color(12,12,28));
		  		gameOver.setOpaque(true);
		  		gameOver.setFont(new Font("Verdana", 1, 121));

		  		//Sets the "return to menu" message part of the pop-up
		  		JLabel backToMenu = new JLabel();
		  		backToMenu.setText(" Will return to menu in 4 seconds");
		  		backToMenu.setForeground(Color.white);
		  		backToMenu.setBackground(new Color(12,12,28));
		  		backToMenu.setOpaque(true);
		  		backToMenu.setFont(new Font("Verdana", 1, 39));

		  		//Adds the labels to the GridLayout
		  		endGamePanel.add(gameOver);
		  		endGamePanel.add(backToMenu);

		  		//Optimizes and displays the frame
		  		endFrame.setUndecorated(true);
		  		endFrame.add(endGamePanel);
				endFrame.setSize(frameSize, frameSize);
			    endFrame.setResizable(false);
			    endFrame.setLocationRelativeTo(null);
		    	endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   	endFrame.pack();
			   	endFrame.setVisible(true);
			   	isGameOverPresent = true;
			}

			//Hides/closes the game over frame
			else if ((isGameOverPresent == true) && (gameOver == false)) {
				resetGridColor();
				endFrame.setVisible(false);
				isGameOverPresent = false;
			}
	  	}
	  	
	  	/**
	  	 * This updates the players throughout the runtime. It keeps track of who wins aswell.
	  	 */
	public void updatePlayers() {
		if (player2AI == null) {
			player1.movePlayer();
			player1.detectBounds();
			player1.detectWall(grid);
			if (player1.getPlayerDead()) {
				gameOver = true;
				player1Win = false;
			}
			else {
				grid[player1.getNewRow()][player1.getNewCol()] = "P";
				grid[player1.getCurRow()][player1.getCurCol()] = "+";
				player1.updatePosition();
			}
			player2.movePlayer();
			player2.detectBounds();
			player2.detectWall(grid);
			if (player2.getPlayerDead()) {
				gameOver = true;
				player1Win = true;
			}
			else {
				grid[player2.getNewRow()][player2.getNewCol()] = "A";
				grid[player2.getCurRow()][player2.getCurCol()] = "-";
				player2.updatePosition();
			}
		}
		if (player2AI != null) {
			player1.movePlayer();
			player1.detectBounds();
			player1.detectWall(grid);
			if (player1.getPlayerDead()) {
				gameOver = true;
				player1Win = false;
			}
			else {
				grid[player1.getNewRow()][player1.getNewCol()] = "P";
				grid[player1.getCurRow()][player1.getCurCol()] = "+";
				player1.updatePosition();
			}
			
			player2AI.moveAI(grid);
			player2AI.detectBounds();
			player2AI.detectWall(grid);
			if (player2AI.getPlayerDead()) {
				gameOver = true;
				player1Win = true;
			}
			else {
				grid[player2AI.getNewRow()][player2AI.getNewCol()] = "A";
				grid[player2AI.getCurRow()][player2AI.getCurCol()] = "-";
				player2AI.updatePosition();
			}
		}
	}
	
	/**
	 * This is the method that actually gets run in the thread.
	 */
	@Override
	public void run() {
		this.updatePlayers();
		this.setGameOver();
		if (!gameOver) {
			this.updateGUIGrid();
		}	
		if (gameOver) {
			latch.countDown();
		}
		
	}
}