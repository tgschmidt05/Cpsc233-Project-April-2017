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
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Qingyue Zhu
 * @graphic_design JinMyoung Song, Qingyue Zhu
 * This class is a part of the menu
 * which as the user who choose solo to choose his/her color
 *
 */
public class ColorMenuSingle extends Menu implements ActionListener {

    // set the size of the color button as 100
	public static final int COLOR_BUTTON_SIZE = 100;

    // set default color for player is orange and for ai is pink
	private String chosenColor = "orange";
	private String randomColor = "pink";

	JPanel colorMenuSingle = new JPanel();


	JButton backButton = new JButton("back");
	JButton startButton = new JButton("start");

	JLabel player = new JLabel("player");


	JTextField name1 = new JTextField("Your name");


	JButton pink = new JButton("pink");
	JButton magenta = new JButton("magenta");
	JButton orange = new JButton("orange");
	JButton red = new JButton("red");
	JButton blue = new JButton("blue");
	JButton cyan = new JButton("cyan");
	JButton green = new JButton("green");
	JButton gray = new JButton("gray");
	JButton white = new JButton("white");

	Random kb = new Random();

    // the default constructor for the class which set whole color menu for
    // single player
    public ColorMenuSingle() {
        setter();
        singleMenu();
    }
    
    //set overall things for the menu part
    public void setter() {
        setOthers();
        setButtons();
        addActionListener();
    }

    /*
     * No parameter No return this method set all the buttons for the menu part
     */
    public void setButtons() {
        //set images for the buttons
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

	}

     //set other things like labels, panel and text field
	public void setOthers() {
		super.setMenu(colorMenuSingle);
		super.setLabel(player, "images/Player_MENU.png");
		super.setTextField(name1);

	}

    //add action listener for all the color buttons
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

	}

    //set specific staffs for the menu to choose the player1's color
	public void singleMenu() {
		
		setSingleMenu();
		addSingleMenu();
	}

    /*
     * add the buttons, labels, and text fields into the color Menu for the single player
     */
	public void addSingleMenu() {
		super.addButton(colorMenuSingle, backButton);
		super.addButton(colorMenuSingle, startButton);

		super.addLabel(colorMenuSingle, player);

		super.addButton(colorMenuSingle, blue);
		super.addButton(colorMenuSingle, cyan);
		super.addButton(colorMenuSingle, gray);
		super.addButton(colorMenuSingle, green);
		super.addButton(colorMenuSingle, magenta);
		super.addButton(colorMenuSingle, orange);
		super.addButton(colorMenuSingle, pink);
		super.addButton(colorMenuSingle, red);
		super.addButton(colorMenuSingle, white);

		super.addTextField(colorMenuSingle, name1);
	}

    /*
     * set all the locations of the buttons for the menu
     * those magic numbers has been calculated and set for the graphic design purpose
     */
	public void setSingleMenu() {
		player.setBounds(BUTTON_X - BUTTON_WIDTH, 120, BUTTON_WIDTH, BUTTON_HEIGHT);
		name1.setBounds(BUTTON_X + BUTTON_WIDTH, 120, BUTTON_WIDTH, BUTTON_HEIGHT);
		startButton.setBounds(275, 540, BUTTON_WIDTH, BUTTON_HEIGHT);
		backButton.setBounds(275, 645, BUTTON_WIDTH, BUTTON_HEIGHT);

		white.setBounds(225, 225, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
		green.setBounds(325, 225, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
		magenta.setBounds(425, 225, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
		cyan.setBounds(225, 325, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
		pink.setBounds(325, 325, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
		orange.setBounds(425, 325, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
		red.setBounds(225, 425, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
		blue.setBounds(325, 425, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);
		gray.setBounds(425, 425, COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE);

	}


    /*
     * @parameter(JButton, String, String)
     * @see LightCyclesV3.Menu#setButton(javax.swing.JButton, java.lang.String, java.lang.String)
     * this method is to help to set all the color buttons with images
     */
	public void setButton(JButton button, String fileName, String pressedFileName) {
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);

		try {
			Image img1 = ImageIO.read(getClass().getResource(fileName));
			Image img2 = img1.getScaledInstance(COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE, Image.SCALE_DEFAULT);
			button.setIcon(new ImageIcon(img2));
		} catch (IOException ex) {
		}

		try {
			Image pressedImg1 = ImageIO.read(getClass().getResource(pressedFileName));
			Image pressedImg2 = pressedImg1.getScaledInstance(COLOR_BUTTON_SIZE, COLOR_BUTTON_SIZE,
					Image.SCALE_DEFAULT);
			button.setPressedIcon(new ImageIcon(pressedImg2));
		} catch (IOException ex) {
		}
	}

    /*
     * This is a method that contains all the action listeners and set the chosenColor as String
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		if (e.getActionCommand().equals("pink") || e.getActionCommand().equals("blue")
				|| e.getActionCommand().equals("white") || e.getActionCommand().equals("green")
				|| e.getActionCommand().equals("magenta") || e.getActionCommand().equals("cyan")
				|| e.getActionCommand().equals("orange") || e.getActionCommand().equals("red")
				|| e.getActionCommand().equals("gray")) {
			chosenColor = e.getActionCommand();
		} 

	}

	// return the color for player 1
	public String getColor1() {
		return chosenColor;
	}

	
	// get and return the random color for the AI
	public String aiColor() {
		do {
			int num = kb.nextInt(9);
			switch (num) {
			case 0:
				randomColor = "pink";
				break;
			case 1:
				randomColor = "white";
				break;
			case 2:
				randomColor = "red";
				break;
			case 3:
				randomColor = "orange";
				break;
			case 4:
				randomColor = "blue";
				break;
			case 5:
				randomColor = "cyan";
				break;
			case 6:
				randomColor = "gray";
				break;
			case 7:
				randomColor = "magenta";
				break;
			case 8:
				randomColor = "green";
				break;
			}
		} while (randomColor.equals(chosenColor));
		return randomColor;
	}
    
    //get the name from the user's input
	public String getName1() {
		return name1.getText();
	}


}
