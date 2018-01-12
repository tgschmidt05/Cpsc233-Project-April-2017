package mainClasses;
import menu.MainMenu;
import player.AI;
import player.HumanPlayer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/**
 * @author: Tobias Schmidt
 *
 * This class runs the entire program. It contains the main game loop
 * and initiates our threads and countdownlatches.
 * 
 */

public class LightCyclesV4 {
	
	/**
	 * These constants are used throughout the program.
	 */
	
	public static final int rowSize = 50;
	public static final int colSize = 50;
	public static final int player1num = 1;
	public static final int player2num = 2;
	
	public static void main (String[] args) {
		
		/*
		 * This is where some of our objects are created
		 */
		TimerTask endGameTask;
		Timer timer = new Timer();
		Thread mainFunction;
		SaveLoad fileIO = new SaveLoad();
		World gameWorld;
		String AIColor = null;
		String player2Color = null;
		
		/*
		 * This is our main loop. It is infinite because our program is
		 * ended by a button in our main menu.
		 */
		while (true) {
			
			/*
			 * These objects have to be re-created new each time the loop restarts.
			 */
			CountDownLatch mainLatch = new CountDownLatch(1);
			CountDownLatch menuLatch = new CountDownLatch(1);	
			MainMenu gameMenu = new MainMenu(menuLatch);
			Thread menuThread = new Thread(gameMenu);
			
			/*
			 * our menu thread and latch starts here.
			 */
			menuThread.start();
			try {
				menuLatch.await();
			}
			catch (InterruptedException e) {
				System.out.println("Menu latch thread interupted. Closing program...");
				System.exit(0);
			}
		
			boolean singlePlayer = gameMenu.getIsSinglePlayer();
			String player1Color = gameMenu.getColorP1();
			if (singlePlayer) {
				AIColor = gameMenu.getAiColor();
			}
			else {
				player2Color = gameMenu.getColorP2();
			}
			
			
		
			/*
			 * singlePlayer is received from the menu. It decides how the program operates this loop.
			 */
			if (singlePlayer) {
				HumanPlayer player1 = new HumanPlayer (player1num, rowSize, colSize, player1Color);
				AI player2 = new AI (player2num, rowSize, colSize, AIColor);
				gameWorld = new World(rowSize, colSize, player1, player2, mainLatch);
			}
			else {
				HumanPlayer player1 = new HumanPlayer (player1num, rowSize, colSize, player1Color);
				HumanPlayer player2 = new HumanPlayer (player2num, rowSize, colSize, player2Color);
				gameWorld = new World(rowSize, colSize, player1, player2, mainLatch);
			}
		
			/*
			 * our main game thread and latch starts here.
			 */
			mainFunction = new Thread (gameWorld);
			timer.scheduleAtFixedRate(gameWorld, 100, 125);
			mainFunction.start();
		
			try {
				mainLatch.await();
			}
			catch (InterruptedException e) {
				System.out.println("World latch thread interupted. Closing program...");
				System.exit(0);
			}
		
			/*
			 * Our world had to be final here because it is a requirement for the created run() just below.
			 */
			final World tempGameWorld = gameWorld;
			endGameTask = new TimerTask() {
				public void run() {
					tempGameWorld.hideGrid();
					}
				};
				timer.schedule(endGameTask, 4500);
		
				/*
				 * this decides how to save the player's name into the file. It is only
				 * saved if they are a winner.
				 */
				if (singlePlayer) {
					if (gameWorld.getPlayer1Win()) {
						fileIO.saveSingleScore(gameMenu.getName1());
					}
				}
				else {
					if (gameWorld.getPlayer1Win()) {
						fileIO.saveMultiScore(gameMenu.getName1());
					}
					else {
						fileIO.saveMultiScore(gameMenu.getName2());
					}
				}
			}
		}
	}