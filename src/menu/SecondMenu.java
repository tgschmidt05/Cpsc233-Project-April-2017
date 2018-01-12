package menu;

import javax.swing.*;

/**
 * @author: Qingyue Zhu
 * @graphic designer: JinMyoung Song, Qingyeu Zhu
 * this is the class which set the second menu for the whole menu
 */
public class SecondMenu extends Menu {
    
    //set panel for the second menu
    JPanel secondMenu = new JPanel();
    JButton multi = new JButton();
    JButton backButton = new JButton();
    JButton single = new JButton();
    
    //the default constructor for the second menu
    SecondMenu() {
        executeSecondMenu();
    }
    
    /*
     * this is the part which the second menu get executed
     * it set all the panel, and buttons
     * it set the button's images and position
     */
    public void executeSecondMenu() {
        super.setMenu(secondMenu);
        super.addButton(secondMenu, multi);
        super.addButton(secondMenu, backButton);
        super.addButton(secondMenu, single);
        super.setButton(single, "images/Single_MENU.png", "images/Single_MENU_PRESSED.png"); //set images
        super.setButton(backButton, "images/Back_MENU.png", "images/Back_MENU_PRESSED.png");
        super.setButton(multi, "images/Multi_MENU.png", "images/Multi_MENU_PRESSED.png");
        single.setBounds(BUTTON_X, (int)(BUTTON_Y - BUTTON_HEIGHT * 0.5), BUTTON_WIDTH, BUTTON_HEIGHT);   //set positions
        multi.setBounds(BUTTON_X, BUTTON_Y + (int) (0.55 * (BUTTON_HEIGHT)), BUTTON_WIDTH, BUTTON_HEIGHT);
        backButton.setBounds(BUTTON_X, BUTTON_Y + (int) (1.6 * (BUTTON_HEIGHT)), BUTTON_WIDTH, BUTTON_HEIGHT);
    }
}
