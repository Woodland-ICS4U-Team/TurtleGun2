import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.*;

public class Narwhal {
    private int distance;
    private String narwhalImage = "NarwhalAnimated.gif";
    private int width;
    private int height;
    private int x = 0;
    private int y = 150;
    private double z = 0;
    private Image image;
    // Narwhal image constructor
    public Narwhal() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(narwhalImage));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        System.out.println("Width is " + width + " height is " + height);
    }

    public Image getImage() {
        return image;
    }
    //Gets the coordinates
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
    //Sin fuction narwhal to move
    public void move() {
        y = (int)(260 * Math.sin(z)) + 250;
        z += 0.05;
        
    }   
}
