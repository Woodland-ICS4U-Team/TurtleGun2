//Narwhal class in TurtleGun2
//Contains functions that allow the narwhal to move
//Coded by Matthew Milne
//Commented by Caleb Isaacs
//January 15, 2015
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.*;

public class Narwhal {
    private String narwhalImage = "NarwhalAnimated.gif";
    private int width; //width of the image
    private int height; //height of the image
    private int x = 0; //x coordinate of the narwhal
    private int y = 150; //y coordinate of the narwhal
    private double z = 0; //x value of the sine function the narwhal follows 
    private Image image;
    
    public Narwhal() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(narwhalImage));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public Image getImage() {
        return image;
    }
    //These functions get variables for level to use
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    //Sine fuction that moves the narwhal
    public void move() {
        y = (int)(260 * Math.sin(z)) + 250;
        z += 0.05;
        
    }   
}
