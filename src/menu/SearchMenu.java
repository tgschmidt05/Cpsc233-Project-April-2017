package menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import mainClasses.SaveLoad;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Qingyue Zhu
 * @graphic_design JinMyoung Song, Qingyue Zhu
 * This is the class which conatins the search menu for the whole menu
 *
 */
public class SearchMenu extends Menu implements ActionListener {
    JPanel searchMenu = new JPanel();
    JTextField search = new JTextField();
    JLabel name = new JLabel("name");
    JLabel result1 = new JLabel("result1");
    JLabel result2 = new JLabel("result2");
    JLabel maxSingle = new JLabel("maxSingle");
    JLabel maxMulti = new JLabel("maxMulti");
    JLabel noMaxSingle = new JLabel("noMaxSingle");
    JLabel noMaxMulti = new JLabel("noMaxMulti");
    JButton searchButton = new JButton("searchButton");
    JButton backButton = new JButton("backButton");
    
    SaveLoad fileIO = new SaveLoad();
    private String single = null;
    private String multi = null;
    private int count3 = 0;
    private int count4 = 0;
    
    // This method is the default constructor for the set all the staffs in the
    // search menu
    public SearchMenu() {
        this.setSingleOrMulti();
        setSearchMenu();
        searchMenu.setVisible(true);
    }
    
    // set buttons, labels and text field for the search menu
    public void setSearchMenu() {
        setMenu(searchMenu);
        setButtons();
        setLabels();
        super.setTextField(search);
        search.setBounds(BUTTON_X + BUTTON_WIDTH, 15, BUTTON_WIDTH, BUTTON_HEIGHT);
        searchMenu.add(search);
        
    }
    
    // set all the buttons and set images and set positions
    // those magic numbers to set the location for the button has been
    // calculated for the graphic design purpose
    public void setButtons() {
        super.setButton(searchButton, "images/Search_MENU.png", "images/Search_MENU_PRESSED.png");
        searchButton.setBounds(275, 120, BUTTON_WIDTH, BUTTON_HEIGHT);
        searchButton.addActionListener(this);
        super.setButton(backButton, "images/Back_MENU.png", "images/Back_MENU_PRESSED.png");
        backButton.setBounds(275, 225, BUTTON_WIDTH, BUTTON_HEIGHT);
    }
    
    // set all the labels and set positions
    // those magic numbers to set the location for the label has been
    // calculated for the graphic design purpose
    public void setLabels() {
        super.setLabel(name, "images/Name_MENU.png");
        name.setBounds(BUTTON_X - BUTTON_WIDTH, 15, BUTTON_WIDTH, BUTTON_HEIGHT);
        result2.setBounds(BUTTON_X - BUTTON_WIDTH, 540, BUTTON_WIDTH * 4, BUTTON_HEIGHT);
        result2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        result2.setForeground(Color.decode("#00afff"));
        result1.setForeground(Color.decode("#00afff"));
        result1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        result1.setBounds(BUTTON_X-BUTTON_WIDTH, 330, BUTTON_WIDTH * 4, BUTTON_HEIGHT);
        maxSingle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        maxSingle.setForeground(Color.decode("#00afff"));
        maxMulti.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        maxMulti.setForeground(Color.decode("#00afff"));
        noMaxSingle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        noMaxSingle.setForeground(Color.decode("#00afff"));
        noMaxMulti.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        noMaxMulti.setForeground(Color.decode("#00afff"));
        maxSingle.setBounds(75, 435, 500, 90);
        maxMulti.setBounds(75, 645, 500, 90);
        noMaxSingle.setBounds(25, 435, 500, 90);
        noMaxMulti.setBounds(25, 645, 500, 90);
        
        maxSingle.setText(single + " " + "IS THE LEADER IN SOLO!");
        maxMulti.setText(multi + " " + "IS THE LEADER IN MULTI!");
        noMaxMulti.setText("THERE IS NO LEADER IN MULTI!");
        noMaxSingle.setText("THERE IS NO LEADER IN SOLO!");
        
        searchMenu.add(name);
        searchMenu.add(searchButton);
        searchMenu.add(backButton);
        searchMenu.add(result1);
        searchMenu.add(result2);
        searchMenu.add(maxMulti);
        searchMenu.add(maxSingle);
        searchMenu.add(noMaxMulti);
        searchMenu.add(noMaxSingle);
        
        // set the result be false before the user input their name and press search
        result1.setVisible(false);
        result2.setVisible(false);
        maxSingle.setVisible(false);
        maxMulti.setVisible(false);
        noMaxSingle.setVisible(false);
        noMaxMulti.setVisible(false);
        name.setVisible(true);
    }
    
    // this is the method to set the name of the player who win the most in the single
    // and multi type
    public void setSingleOrMulti() {
        single = showWinMostSingle(fileIO.loadSingleScore());
        multi = showWinMostMulti(fileIO.loadMultiScore());
    }
    
    /*
     * this is the method that contains the action listener for the search
     * button and it will set the result and make those label visible
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("searchButton")) {
            String name = search.getText().toLowerCase();
            readSingle(name);
            readMulti(name);
            if (count3 == 0) {
                noMaxSingle.setVisible(true); // if two people have the same
                // amount time wining for the
                // game
            } else { // the label says no leader for that type of game will be
                // visible
                maxSingle.setVisible(true);
                
            }
            if (count4 == 0) {
                noMaxMulti.setVisible(true);
            } else {
                maxMulti.setVisible(true);
            }
        }
    }
    
    /*
     * @Parameter: String
     * This is the method that count how many times a person wins for the solo type
     */
    public void readSingle(String name) {
        int count = 0;
        int loopCount;
        String[] singleArray = fileIO.loadSingleScore();
        for (loopCount = 0; loopCount < singleArray.length; loopCount++) {
            if (singleArray[loopCount].equals(name)) {
                count++;
            }
        }
        if (count == 0) {
            result1.setText("You did not win any game in singleplayer.");
        } else {
            result1.setText("You won " + count + " times in singleplayer.");
        }
        result1.setVisible(true);
    }
    
    /*
     * @Parameter: String
     * this method is count how many times a person win in multi type
     */
    public void readMulti(String name) {
        int count = 0;
        int loopCount;
        String[] singleArray = fileIO.loadMultiScore();
        for (loopCount = 0; loopCount < singleArray.length; loopCount++) {
            if (singleArray[loopCount].equals(name)) {
                count++;
            }
        }
        if (count == 0) {
            result2.setText("You did not win any game in multiplayer.");
        } else {
            result2.setText("You won " + count + " times in multiplayer.");
        }
        result2.setVisible(true);
    }
    
    //this is the method that shows the person win the most in the Single type
    public String showWinMostSingle(String[] name) {
        int count1 = 0;
        int count2 = 0;
        count3 = 0;
        String max = null;
        for (int index = 0; index < name.length; index++) {
            for (int index2 = index + 1; index2 < name.length; index2++) {
                if (name[index].equals(name[index2])) {
                    count1++;
                }
            }
            if (count1 > count2) {
                count2 = count1;
                count3 = count2;
                max = name[index];
            } else if (count1 == count2) {    //if highest two people has same amount the count3 will be 0
                count3 = 0;                  // and that will not show any leader
            }
            count1 = 0;
        }
        if (max != null) {
        	max.toUpperCase();
        }
        return max;
    }
    
    
    
    //this is the method that shows the person win the most in the Multi type
    public String showWinMostMulti(String[] name) {
        int count1 = 0;
        int count2 = 0;
        count4 = 0;
        String max = null;
        for (int index = 0; index < name.length; index++) {
            for (int index2 = index + 1; index2 < name.length; index2++) {
                if (name[index].equals(name[index2])) {
                    count1++;
                }
            }
            if (count1 > count2) {
                count2 = count1;
                count4 = count2;
                max = name[index];
            } else if (count1 == count2) {  //if highest two people has same amount the count4 will be 0
                count4 = 0;               // and that will not show any leader
            }
            count1 = 0;
        }
        if (max != null) {
        	max.toUpperCase();
        }
        return max;
    }
}
