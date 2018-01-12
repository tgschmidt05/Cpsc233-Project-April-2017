package menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author: Ga Hyung Kim, Qingyue Zhu
 * @graphic designer: JinMyoung Song, Qingyue Zhu
 * 
 *          This class run the whole menu part of our program, it has two pages
 *          one is the main menu and second one is the setting part which is the
 *          color menu in another class
 * 
 */

public class MainMenu extends Thread{

	public static final int FRAME_SIZE = 750;
	public static final int BUTTON_WIDTH = 200;
	public static final int BUTTON_HEIGHT = 90;
	public static final int BUTTON_BORDER = (FRAME_SIZE - BUTTON_WIDTH) / 2;
	public static final int BUTTON_X = BUTTON_BORDER;
	public static final int BUTTON_Y = 300;

	JFrame frame = new JFrame(); // create a frame window for the menu
	JPanel menu = new JPanel(); // create the menu panel in the frame
	CardLayout card = new CardLayout(); // set the layout for the menu

	FirstMenu firstMenu = new FirstMenu();
	SecondMenu secondMenu = new SecondMenu();
	ColorMenuSingle colorMenuSingle = new ColorMenuSingle();
	ColorMenuMulti colorMenuMulti = new ColorMenuMulti();
	SearchMenu searchMenu = new SearchMenu();

	private CountDownLatch latch;
	private boolean isSinglePlayer;

	/*
	 * constructor that adds the latch so, its thread can wait.
	 */
	public MainMenu(CountDownLatch aLatch) {
		latch = aLatch;
	}

	/*
	 * set the basic information for the menu and frame and add the two part of
	 * the menu into the menu
	 */
	public void setBoard() {

		frame.setSize(FRAME_SIZE, FRAME_SIZE);
		frame.setUndecorated(true);
		frame.setResizable(false);
		
		menu.setPreferredSize(new Dimension(FRAME_SIZE, FRAME_SIZE));
		menu.setLayout(card);
		menu.add(firstMenu.firstMenu, "1");
		menu.add(secondMenu.secondMenu, "2");
		menu.add(colorMenuSingle.colorMenuSingle, "3");
		menu.add(colorMenuMulti.colorMenuMulti,"4");
		menu.add(searchMenu.searchMenu, "5");
		card.show(menu, "1");
	}

    /*
     * the main part of the menu part, set several action listener to each
     * button which need to switch the pages in the menu
     * using card layout to change between each menu panel
     */
    public void executeBoard() {
        
        setBoard();
        //the start button lead player to the second menu to choose the type of the game
        firstMenu.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                card.show(menu, "2");
            }
        });
        //the exitButton for exit the whole game
        firstMenu.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        //the start button for start the game
        colorMenuSingle.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                latch.countDown();
                frame.dispose();
            }
        });
        //back button back to the previous page
        colorMenuSingle.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                card.show(menu, "2");
            }
        });
        //the start button for start the game
        colorMenuMulti.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                latch.countDown();
                frame.dispose();
            }
        });
        //back button back to the previous page
        colorMenuMulti.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                card.show(menu, "2");
            }
        });
        //back button back to the previous page
        secondMenu.backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(menu, "1");
                
            }
        });
        //the multi button lead user to the multi color page to choose color for player1 and player2
        secondMenu.multi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                isSinglePlayer = false;
                card.show(menu, "4");
                
            }
        });
        //the single button lead user to the single color page to choose color
        secondMenu.single.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                isSinglePlayer = true;
                card.show(menu, "3");
            }
        });
        //back button back to the previous page
        searchMenu.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                card.show(menu, "1");
            }
        });
        //search button for the first menu lead user to the search page
        firstMenu.search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                card.show(menu, "5");
            }
        });
        
        
        
        // add the menu panel to the main frame
        frame.add(menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// display the window
		frame.pack();
		frame.setVisible(true);

	}

	/*
	 * return the color for player 1 for other class to use the color as the
	 * line in the game
	 */
	public String getColorP1() {
		String output;
		if (isSinglePlayer) {
			output = colorMenuSingle.getColor1();
		}
		else {
			output = colorMenuMulti.getColor1();
		}
		return output;
	}

	/*
	 * return the color for player 2 for other class to use the color as the
	 * line in the game
	 */
	public String getColorP2() {
		String output = colorMenuMulti.getColor2();
		return output;
	}

	/*
	 * return the random color for AI player for the other class to use the
	 * color as the line in the game
	 */
	public String getAiColor() {
		String output = colorMenuSingle.aiColor();
		return output;
	}
	
    //return the name for the single player
	public String getName1() {
		String output;
		if (isSinglePlayer) {
			output = colorMenuSingle.getName1();
		}
		else {
			output = colorMenuMulti.getName1();
		}
		return output;
	}
	
    //return the name for the player2 in the multi type
	public String getName2() {
		String output = colorMenuMulti.getName2();
		return output;
	}
	
    //return is the user choose single or not
	public boolean getIsSinglePlayer() {
		return isSinglePlayer;
	}

	public void run() {
		executeBoard(); // run the whole menu
		}
	}

