package menu;

import javax.swing.*;

/**
 * @author: Ga Hyung Kim, Qingyue Zhu
 * @graphic designer: JinMyoung Song
 * this is the class which set the first menu for the whole menu
 */
public class FirstMenu extends Menu {

    JPanel firstMenu = new JPanel();
    JButton startButton = new JButton();
    JButton exitButton = new JButton();
    JButton search = new JButton();
    JLabel title = new JLabel();
    
    //the default constructor for the first menu
    FirstMenu() {
        executeFirstMenu();
    }
    
    /*
     * this is the part which the first menu get executed
     * it set all the panel, and buttons
     * it set the button's images and position
     */
    public void executeFirstMenu() {
        super.setMenu(firstMenu);
        super.addButton(firstMenu, startButton);
        super.addButton(firstMenu, exitButton);
        super.addButton(firstMenu, search);
        super.addLabel(firstMenu, title);
        super.setButton(startButton, "images/Start_MENU.png", "images/Start_MENU_PRESSED.png"); //set images
        super.setButton(exitButton, "images/Exit_MENU.png", "images/Exit_MENU_PRESSED.png");
        super.setButton(search, "images/Scores_MENU.png", "images/Scores_MENU_PRESSED.png");
        super.setTitle(title,"images/TITLE.png");
        startButton.setBounds(BUTTON_X, (int)(BUTTON_Y - BUTTON_HEIGHT * 0.5) + 100, BUTTON_WIDTH, BUTTON_HEIGHT); //set locations
        search.setBounds(BUTTON_X, BUTTON_Y + (int) (0.55 * (BUTTON_HEIGHT)) + 100, BUTTON_WIDTH, BUTTON_HEIGHT);
        exitButton.setBounds(BUTTON_X, BUTTON_Y + (int) (1.6 * (BUTTON_HEIGHT)) + 100, BUTTON_WIDTH, BUTTON_HEIGHT);
        title.setBounds(BUTTON_X - BUTTON_WIDTH , BUTTON_Y - BUTTON_HEIGHT - 150, BUTTON_WIDTH * 3, BUTTON_HEIGHT * 3);
    }
    
}
