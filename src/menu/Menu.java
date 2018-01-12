package menu;

import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * @author Ga Hyung Kim, Qingyue Zhu
 * @graphic designer: JinMyoung Song, Qingyue Zhu
 * This is the parent class for all the menu pages
 */
public class Menu {
    //set some stats for the menu like size of frame and buttons
    public static final int FRAME_SIZE = 750;
    public static final int BUTTON_WIDTH = 200;
    public static final int BUTTON_HEIGHT = 90;
    public static final int BUTTON_BORDER = (FRAME_SIZE-BUTTON_WIDTH)/2;
    public static final int BUTTON_X = BUTTON_BORDER;
    public static final int BUTTON_Y = 300;
    
    Menu() {
    }
    
    /*
     * @Parameter: JPanel
     * this method is used for help set the panel
     */
    public void setMenu(JPanel panel) {
        panel.setPreferredSize(new Dimension(FRAME_SIZE,FRAME_SIZE));
        panel.setBackground(new Color(12,12,28));
        panel.setLayout(null);
    }
    
    /*
     * @Parameter: JPanel, JButton
     * this method is used for help add buttons into panel
     */
    public void addButton(JPanel panel, JButton button) {
        panel.add(button);
    }
    
    /*
     * @Parameter: JPanel, JLabel
     * this method is used for help add labels into panel
     */
    public void addLabel(JPanel panel, JLabel label){
        panel.add(label);
    }
    
    /*
     * @Parameter: JPanel, JTextField
     * this method is used for help add text field into panel
     */
    public void addTextField(JPanel panel, JTextField textField){
        panel.add(textField);
    }
    
    /*
     * @Parameter: JButton, String, String
     * this method is used for help set buttons' images for it present and after pressed
     */
    public void setButton(JButton button, String fileName, String pressedFileName) {
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        
        try {
            Image img1 = ImageIO.read(getClass().getResource(fileName)); // get image
            Image img2 = img1.getScaledInstance
            (BUTTON_WIDTH,BUTTON_HEIGHT,Image.SCALE_DEFAULT);
            button.setIcon(new ImageIcon(img2));
        } catch(IOException ex) {}   // catch the IOException
        
        try {
            Image pressedImg1 = ImageIO.read(getClass().getResource(pressedFileName));
            Image pressedImg2 = pressedImg1.getScaledInstance
            (BUTTON_WIDTH,BUTTON_HEIGHT,Image.SCALE_DEFAULT);
            button.setPressedIcon(new ImageIcon(pressedImg2));
        } catch(IOException ex) {}
    }
    
    /*
     * @Parameter: JLabel, String
     * this method is used for help set labels' images for it present
     */
    public void setLabel(JLabel label, String fileName) {
        try {
            Image img = ImageIO.read(getClass().getResource(fileName));
            Image img2 = img.getScaledInstance(BUTTON_WIDTH, BUTTON_HEIGHT, Image.SCALE_DEFAULT);
            label.setIcon(new ImageIcon(img2));
        } catch (IOException ex) {
        }
    }
    
    /*
     * @Parameter: JTexrField
     * this method is used for help set text field with set background, forground, border and the font
     */
    public void setTextField(JTextField textField){
        textField.setBackground(new Color(12, 12, 28));
        textField.setForeground(new Color(118,216,242));
        textField.setBorder(BorderFactory.createLineBorder(Color.decode("#76d8f2")));
        textField.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
    }
    
    /*
     * @Parameter: JLabel, String
     * this method is used for help set text field with set forground and the font\
     * and set the text into the label
     */
    public void setLabel2(JLabel label,String text){
        label.setForeground(new Color(118,216,242));
        label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
        label.setText(text);
    }
    
    /*
     * @Parameter: JLabel, String
     * this method is used for help set labels' images for it present specially for the title of the game
     */
    public void setTitle(JLabel title, String file){
        try {
            Image img = ImageIO.read(getClass().getResource(file));
            Image img2 = img.getScaledInstance(BUTTON_WIDTH * 3, BUTTON_HEIGHT * 3, Image.SCALE_DEFAULT);
            title.setIcon(new ImageIcon(img2));
        } catch (IOException ex) {
        }
    }
}
