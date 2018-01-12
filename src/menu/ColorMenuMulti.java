package menu;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Qingyue Zhu
 * @graphic_design JinMyoung Song, Qingyue Zhu
 *
 */
public class ColorMenuMulti extends Menu implements ActionListener {

	public static final int COLOR_BUTTON_SIZE = 100;

	private String chosenColor = "orange";
	private String chosenColor2 = "blue2";

	JPanel colorMenuMulti = new JPanel();

	JLayeredPane singleColor = new JLayeredPane();
	JLayeredPane multiColor = new JLayeredPane();

	JButton backButton = new JButton("back");
	JButton startButton = new JButton("start");

	JLabel player = new JLabel("player");
	JLabel player1 = new JLabel("player1");
	JLabel player2 = new JLabel("player2");
	JLabel noResult = new JLabel("noResult");

	JTextField name1 = new JTextField("Your name");
	JTextField name2 = new JTextField("Your name");

	JButton pink = new JButton("pink");
	JButton magenta = new JButton("magenta");
	JButton orange = new JButton("orange");
	JButton red = new JButton("red");
	JButton blue = new JButton("blue");
	JButton cyan = new JButton("cyan");
	JButton green = new JButton("green");
	JButton gray = new JButton("gray");
	JButton white = new JButton("white");

	JButton pink2 = new JButton("pink2");
	JButton magenta2 = new JButton("magenta2");
	JButton orange2 = new JButton("orange2");
	JButton red2 = new JButton("red2");
	JButton blue2 = new JButton("blue2");
	JButton cyan2 = new JButton("cyan2");
	JButton green2 = new JButton("green2");
	JButton gray2 = new JButton("gray2");
	JButton white2 = new JButton("white2");

	JButton pink3 = new JButton("pink3");
	JButton magenta3 = new JButton("magenta3");
	JButton orange3 = new JButton("orange3");
	JButton red3 = new JButton("red3");
	JButton blue3 = new JButton("blue3");
	JButton cyan3 = new JButton("cyan3");
	JButton green3 = new JButton("green3");
	JButton gray3 = new JButton("gray3");
	JButton white3 = new JButton("white3");


    // default constructor
    public ColorMenuMulti() {
        setter();
    }
    
    // set basic staff for this menu part
    public void setter() {
        setOthers();
        setButtons();
        addActionListener();
        multiMenu();
    }
    
    /*
     * No parameter No return this method set all the buttons for the menu part
     */
    public void setButtons() {
        // add images for all the buttons
        super.setButton(backButton, "images/Back_MENU.png", "images/Back_MENU_PRESSED.png");
        super.setButton(startButton, "images/Start_MENU.png", "images/Start_MENU_PRESSED.png");
        
        this.setButton(pink, "images/PINK.png", "images/PINK2.png");
        this.setButton(blue, "images/BLUE.png", "images/BLUE2.png");
        this.setButton(cyan, "images/CYAN.png", "images/CYAN2.png");
        this.setButton(magenta, "images/MAGENTA.png", "images/MAGENTA2.png");
        this.setButton(orange, "images/ORANGE.png", "images/ORANGE2.png");
        this.setButton(green, "images/GREEN.png", "images/GREEN2.png");
        this.setButton(red, "images/RED.png", "images/RED2.png");
        this.setButton(white, "images/WHITE.png", "images/WHITE2.png");
        this.setButton(gray, "images/GRAY.png", "images/GRAY2.png");
        
        this.setButton(pink2, "images/PINK.png", "images/PINK2.png");
        this.setButton(blue2, "images/BLUE.png", "images/BLUE2.png");
        this.setButton(cyan2, "images/CYAN.png", "images/CYAN2.png");
        this.setButton(magenta2, "images/MAGENTA.png", "images/MAGENTA2.png");
        this.setButton(orange2, "images/ORANGE.png", "images/ORANGE2.png");
        this.setButton(green2, "images/GREEN.png", "images/GREEN2.png");
        this.setButton(red2, "images/RED.png", "images/RED2.png");
        this.setButton(white2, "images/WHITE.png", "images/WHITE2.png");
        this.setButton(gray2, "images/GRAY.png", "images/GRAY2.png");
        
        this.setButton(pink3, "images/PINK3.png", "images/PINK4.png");
        this.setButton(blue3, "images/BLUE3.png", "images/BLUE4.png");
        this.setButton(cyan3, "images/CYAN3.png", "images/CYAN4.png");
        this.setButton(magenta3, "images/MAGENTA3.png", "images/MAGENTA4.png");
        this.setButton(orange3, "images/ORANGE3.png", "images/ORANGE4.png");
        this.setButton(green3, "images/GREEN3.png", "images/GREEN4.png");
        this.setButton(red3, "images/RED3.png", "images/RED4.png");
        this.setButton(white3, "images/WHITE3.png", "images/WHITE4.png");
        this.setButton(gray3, "images/GRAY3.png", "images/GRAY4.png");
    }
    
    
    // this method set all the other things like panel, label and text fields
    public void setOthers() {
        super.setMenu(colorMenuMulti);
        super.setLabel(player1, "images/Player1_MENU.png");
        super.setTextField(name1); //this is ask the player1's name
        super.setLabel(player2, "images/Player2_MENU.png");
        super.setTextField(name2); // this is ask the player2's name
    }
    
    // this method add action listener for all the color buttons
    public void addActionListener() {
        pink.addActionListener(this);
        blue.addActionListener(this);
        white.addActionListener(this);
        red.addActionListener(this);
        magenta.addActionListener(this);
        orange.addActionListener(this);
        cyan.addActionListener(this);
        green.addActionListener(this);
        gray.addActionListener(this);
        
        pink2.addActionListener(this);
        blue2.addActionListener(this);
        white2.addActionListener(this);
        red2.addActionListener(this);
        magenta2.addActionListener(this);
        orange2.addActionListener(this);
        cyan2.addActionListener(this);
        green2.addActionListener(this);
        gray2.addActionListener(this);
    }
    
    // call the two method to set the whole part
    public void multiMenu() {
        addMultiMenu();
        setMultiMenu();
        
    }
    /*
     * add two layered panel for the graphic design purpose and it will change
     * due to the user's choice
     */
    public void addMultiMenu() {
        super.addButton(colorMenuMulti, backButton);
        super.addButton(colorMenuMulti, startButton);
        
        // two layered Panel
        colorMenuMulti.add(singleColor);
        colorMenuMulti.add(multiColor);
        
        // add buttons to the two layered panel
        addSingleColor();
        addMultiColor();
        
        // add label
        super.addLabel(colorMenuMulti, player1);
        super.addLabel(colorMenuMulti, player2);
        super.addLabel(colorMenuMulti, noResult);
        super.addTextField(colorMenuMulti, name1);
        super.addTextField(colorMenuMulti, name2);
    }
    
    // add color buttons for the player1 to choose
    public void addSingleColor() {
        singleColor.add(pink);
        singleColor.add(magenta);
        singleColor.add(orange);
        singleColor.add(red);
        singleColor.add(blue);
        singleColor.add(green);
        singleColor.add(gray);
        singleColor.add(cyan);
        singleColor.add(white);
    }
    
    // add color buttons for the player2 to choose
    public void addMultiColor() {
        multiColor.add(pink2);
        multiColor.add(magenta2);
        multiColor.add(orange2);
        multiColor.add(red2);
        multiColor.add(blue2);
        multiColor.add(green2);
        multiColor.add(gray2);
        multiColor.add(cyan2);
        multiColor.add(white2);
        
        // other 9 color buttons will show when the user some color for player1
        // they cannot choose the same color for player 2
        multiColor.add(pink3);
        multiColor.add(magenta3);
        multiColor.add(orange3);
        multiColor.add(red3);
        multiColor.add(blue3);
        multiColor.add(green3);
        multiColor.add(gray3);
        multiColor.add(cyan3);
        multiColor.add(white3);
    }
    
    /*
     * this method set all the positions of the buttons those magic numbers has
     * been calculated for the graphic design purpose
     */
    public void setMultiMenu() {
        player1.setBounds(BUTTON_X - BUTTON_WIDTH, 20, BUTTON_WIDTH, BUTTON_HEIGHT);
        name1.setBounds(BUTTON_X - BUTTON_WIDTH, 125, BUTTON_WIDTH, BUTTON_HEIGHT);
        player2.setBounds(BUTTON_X + BUTTON_WIDTH, 20, BUTTON_WIDTH, BUTTON_HEIGHT);
        name2.setBounds(BUTTON_X + BUTTON_WIDTH, 125, BUTTON_WIDTH, BUTTON_HEIGHT);
        startButton.setBounds(275, 560, BUTTON_WIDTH, BUTTON_HEIGHT);
        backButton.setBounds(275, 630, BUTTON_WIDTH, BUTTON_HEIGHT);
        
        singleColor.setBounds(0, 230, 375, 330);
        setSingleColor();
        multiColor.setBounds(375, 230, 375, 330);
        setMultiColor();
        
    }
    
    /*
     * no parameter and no return set positions for one of the layered panel and
     * all the magic numbers has been calculated and designed for the graphic
     * design purpose
     */
    public void setSingleColor() {
        white.setBounds(38, 14, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        green.setBounds(138, 14, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        magenta.setBounds(238, 14, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        cyan.setBounds(38, 114, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        pink.setBounds(138, 114, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        orange.setBounds(238, 114, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        red.setBounds(38, 214, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        blue.setBounds(138, 214, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        gray.setBounds(238, 214, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
    }
    
    /*
     * no parameter and no return set positions for the other layered panel and
     * all the magic numbers has been calculated and designed for the graphic
     * design purpose
     */
    public void setMultiColor() {
        white2.setBounds(37, 14, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        green2.setBounds(137, 14, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        magenta2.setBounds(237, 14, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        cyan2.setBounds(37, 114, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        pink2.setBounds(137, 114, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        orange2.setBounds(237, 114, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        red2.setBounds(37, 214, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        blue2.setBounds(137, 214, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        gray2.setBounds(237, 214, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        
        // set positions for the sign buttons to let the user notice that this
        // color has been chosen by the player1 and player2 cannot choose the
        // same color. and all the positions are used to cover the original
        // color buttons that let the player2 to choose
        white3.setBounds(37, 14, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        green3.setBounds(137, 14, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        magenta3.setBounds(237, 14, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        cyan3.setBounds(37, 114, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        pink3.setBounds(137, 114, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        orange3.setBounds(237, 114, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        red3.setBounds(37, 214, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        blue3.setBounds(137, 214, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        gray3.setBounds(237, 214, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
        
        // set all the sign color buttons to invisible except the one which set
        // default for the player1, player2 cannot choose that one
        pink3.setVisible(false);
        magenta3.setVisible(false);
        orange2.setVisible(false);
        orange3.setVisible(true);
        red3.setVisible(false);
        blue3.setVisible(false);
        green3.setVisible(false);
        gray3.setVisible(false);
        cyan3.setVisible(false);
        white3.setVisible(false);
    }
    
    // when the player1 choose white, palyer2's white button will become sign
    // color button and set other buttons to the original color buttons which
    // can be chose
    public void chosenWHITE() {
        white3.setVisible(true);
        pink3.setVisible(false);
        magenta3.setVisible(false);
        orange3.setVisible(false);
        red3.setVisible(false);
        blue3.setVisible(false);
        green3.setVisible(false);
        gray3.setVisible(false);
        cyan3.setVisible(false);
        
        white2.setVisible(false);
        pink2.setVisible(true);
        magenta2.setVisible(true);
        orange2.setVisible(true);
        red2.setVisible(true);
        blue2.setVisible(true);
        green2.setVisible(true);
        gray2.setVisible(true);
        cyan2.setVisible(true);
        
    }
    
    // when the player1 choose pink, palyer2's white button will become sign
    // color button and set other buttons to the original color buttons which
    // can be chose
    public void chosenPINK() {
        white3.setVisible(false);
        pink3.setVisible(true);
        magenta3.setVisible(false);
        orange3.setVisible(false);
        red3.setVisible(false);
        blue3.setVisible(false);
        green3.setVisible(false);
        gray3.setVisible(false);
        cyan3.setVisible(false);
        
        white2.setVisible(true);
        pink2.setVisible(false);
        magenta2.setVisible(true);
        orange2.setVisible(true);
        red2.setVisible(true);
        blue2.setVisible(true);
        green2.setVisible(true);
        gray2.setVisible(true);
        cyan2.setVisible(true);
        
    }
    // when the player1 choose magenta, palyer2's white button will become sign
    // color button and set other buttons to the original color buttons which
    // can be chose
    public void chosenMAGENTA() {
        white3.setVisible(false);
        pink3.setVisible(false);
        magenta3.setVisible(true);
        orange3.setVisible(false);
        red3.setVisible(false);
        blue3.setVisible(false);
        green3.setVisible(false);
        gray3.setVisible(false);
        cyan3.setVisible(false);
        
        white2.setVisible(true);
        pink2.setVisible(true);
        magenta2.setVisible(false);
        orange2.setVisible(true);
        red2.setVisible(true);
        blue2.setVisible(true);
        green2.setVisible(true);
        gray2.setVisible(true);
        cyan2.setVisible(true);
        
    }
    // when the player1 choose orange, palyer2's white button will become sign
    // color button and set other buttons to the original color buttons which
    // can be chose
    public void chosenORANGE() {
        white3.setVisible(false);
        pink3.setVisible(false);
        magenta3.setVisible(false);
        orange3.setVisible(true);
        red3.setVisible(false);
        blue3.setVisible(false);
        green3.setVisible(false);
        gray3.setVisible(false);
        cyan3.setVisible(false);
        
        white2.setVisible(true);
        pink2.setVisible(true);
        magenta2.setVisible(true);
        orange2.setVisible(false);
        red2.setVisible(true);
        blue2.setVisible(true);
        green2.setVisible(true);
        gray2.setVisible(true);
        cyan2.setVisible(true);
        
    }
    
    // when the player1 choose red, palyer2's white button will become sign
    // color button and set other buttons to the original color buttons which
    // can be chose
    public void chosenRED() {
        white3.setVisible(false);
        pink3.setVisible(false);
        magenta3.setVisible(false);
        orange3.setVisible(false);
        red3.setVisible(true);
        blue3.setVisible(false);
        green3.setVisible(false);
        gray3.setVisible(false);
        cyan3.setVisible(false);
        
        white2.setVisible(true);
        pink2.setVisible(true);
        magenta2.setVisible(true);
        orange2.setVisible(true);
        red2.setVisible(false);
        blue2.setVisible(true);
        green2.setVisible(true);
        gray2.setVisible(true);
        cyan2.setVisible(true);
        
    }
    
    // when the player1 choose blue, palyer2's white button will become sign
    // color button and set other buttons to the original color buttons which
    // can be chose
    public void chosenBLUE() {
        white3.setVisible(false);
        pink3.setVisible(false);
        magenta3.setVisible(false);
        orange3.setVisible(false);
        red3.setVisible(false);
        blue3.setVisible(true);
        green3.setVisible(false);
        gray3.setVisible(false);
        cyan3.setVisible(false);
        
        white2.setVisible(true);
        pink2.setVisible(true);
        magenta2.setVisible(true);
        orange2.setVisible(true);
        red2.setVisible(true);
        blue2.setVisible(false);
        green2.setVisible(true);
        gray2.setVisible(true);
        cyan2.setVisible(true);
        
    }
    
    // when the player1 choose green, palyer2's white button will become sign
    // color button and set other buttons to the original color buttons which
    // can be chose
    public void chosenGREEN() {
        white3.setVisible(false);
        pink3.setVisible(false);
        magenta3.setVisible(false);
        orange3.setVisible(false);
        red3.setVisible(false);
        blue3.setVisible(false);
        green3.setVisible(true);
        gray3.setVisible(false);
        cyan3.setVisible(false);
        
        white2.setVisible(true);
        pink2.setVisible(true);
        magenta2.setVisible(true);
        orange2.setVisible(true);
        red2.setVisible(true);
        blue2.setVisible(true);
        green2.setVisible(false);
        gray2.setVisible(true);
        cyan2.setVisible(true);
        
    }
    // when the player1 choose gray, palyer2's white button will become sign
    // color button and set other buttons to the original color buttons which
    // can be chose
    public void chosenGRAY() {
        white3.setVisible(false);
        pink3.setVisible(false);
        magenta3.setVisible(false);
        orange3.setVisible(false);
        red3.setVisible(false);
        blue3.setVisible(false);
        green3.setVisible(false);
        gray3.setVisible(true);
        cyan3.setVisible(false);
        
        white2.setVisible(true);
        pink2.setVisible(true);
        magenta2.setVisible(true);
        orange2.setVisible(true);
        red2.setVisible(true);
        blue2.setVisible(true);
        green2.setVisible(true);
        gray2.setVisible(false);
        cyan2.setVisible(true);
        
    }
    
    // when the player1 choose cyan, palyer2's white button will become sign
    // color button and set other buttons to the original color buttons which
    // can be chose
    public void chosenCYAN() {
        white3.setVisible(false);
        pink3.setVisible(false);
        magenta3.setVisible(false);
        orange3.setVisible(false);
        red3.setVisible(false);
        blue3.setVisible(false);
        green3.setVisible(false);
        gray3.setVisible(false);
        cyan3.setVisible(true);
        
        white2.setVisible(true);
        pink2.setVisible(true);
        magenta2.setVisible(true);
        orange2.setVisible(true);
        red2.setVisible(true);
        blue2.setVisible(true);
        green2.setVisible(true);
        gray2.setVisible(true);
        cyan2.setVisible(false);
        
    }
    
    /*
     * @parameter JButton, String, String
     * @see LightCyclesV3.Menu#setButton(javax.swing.JButton, java.lang.String, java.lang.String)
     * this is a method which set the images for those color buttons
     * that include the image when it present and when it get pressed
     *
     */
    public void setButton(JButton button, String fileName, String pressedFileName) {
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        
        try {
            Image img1 = ImageIO.read(getClass().getResource(fileName));    // get and read file
            Image img2 = img1.getScaledInstance(COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE, Image.SCALE_DEFAULT);
            button.setIcon(new ImageIcon(img2));
        } catch (IOException ex) {
        }
        
        try {
            Image pressedImg1 = ImageIO.read(getClass().getResource(pressedFileName)); // get and red file
            Image pressedImg2 = pressedImg1.getScaledInstance(COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE,
                                                              Image.SCALE_DEFAULT);   //change file into right scale
            button.setPressedIcon(new ImageIcon(pressedImg2));
        } catch (IOException ex) {
        }
    }
    
    
    /*
     * This method is the action listener for the color buttons and get those colors into the
     * instance variables as String
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        //change the visibility for the part which the player2 need to choose
        if (e.getActionCommand().equals("pink")) {
            chosenPINK();
            chosenColor = e.getActionCommand();
        } else if (e.getActionCommand().equals("blue")) {
            chosenBLUE();
            chosenColor = e.getActionCommand();
        } else if (e.getActionCommand().equals("white")) {
            chosenWHITE();
            chosenColor = e.getActionCommand();
        } else if (e.getActionCommand().equals("green")) {
            chosenGREEN();
            chosenColor = e.getActionCommand();
        } else if (e.getActionCommand().equals("cyan")) {
            chosenCYAN();
            chosenColor = e.getActionCommand();
        } else if (e.getActionCommand().equals("magenta")) {
            chosenMAGENTA();
            chosenColor = e.getActionCommand();
        } else if (e.getActionCommand().equals("orange")) {
            chosenORANGE();
            chosenColor = e.getActionCommand();
        } else if (e.getActionCommand().equals("red")) {
            chosenRED();
            chosenColor = e.getActionCommand();
        } else if (e.getActionCommand().equals("gray")) {
            chosenGRAY();
            chosenColor = e.getActionCommand();
        } // get the color that the user choose for the player 1
        if (e.getActionCommand().equals("pink") || e.getActionCommand().equals("blue")
            || e.getActionCommand().equals("white") || e.getActionCommand().equals("green")
            || e.getActionCommand().equals("magenta") || e.getActionCommand().equals("cyan")
            || e.getActionCommand().equals("orange") || e.getActionCommand().equals("red")
            || e.getActionCommand().equals("gray")) {
            chosenColor = e.getActionCommand();
        } // get the color that the user choose for the player 2
        if (e.getActionCommand().equals("pink2") || e.getActionCommand().equals("blue2")
            || e.getActionCommand().equals("white2") || e.getActionCommand().equals("green2")
            || e.getActionCommand().equals("magenta2") || e.getActionCommand().equals("cyan2")
            || e.getActionCommand().equals("orange2") || e.getActionCommand().equals("red2")
            || e.getActionCommand().equals("gray2")) {
            chosenColor2 = e.getActionCommand();
        }
    }
    
    // return the color for player 1
    public String getColor1() {
        return chosenColor;
    }
    
    // return the color for player 2
    public String getColor2() {
    	int stringLength = chosenColor2.length();
    	chosenColor2 = chosenColor2.substring(0, stringLength - 1);
        return chosenColor2;
    }
    
    //return the name for player1
    public String getName1() {
        return name1.getText();
    }
    
    //return the name for player2
    public String getName2() {
        return name2.getText();
    }
    
}
