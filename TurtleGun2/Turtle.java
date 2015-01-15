//Turtle class in TurtleGun2
//Contains methods that allow the turtle to move
//Coded by Matthew Milne
//Commented by Caleb Isaacs
//January 15, 2015
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Turtle {
    private int STARTING_X = 300;
    private int speed = 0;
    private String turtleImage = "Turtle.png";
    private int width; // image width
    private int height; // image height
    private int x = STARTING_X; //starting x value
    private int y = TurtleGun2.getLevelHeight()/2 - 80;
    private Image image;
    private int lives = 3;
        
    public Turtle() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(turtleImage));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        y -= height / 2;
    }
    
    public Image getImage() {
        return image;
    }
    
    public void setLives(int newLives) {
        lives = newLives;
        x -= 50;
    }
    
    public void setSpeed(int nSpeed) {
        speed = nSpeed;
    }
    //Resets the variables after a new game is started
    public void reset() {
        x = STARTING_X;
        y = TurtleGun2.getLevelHeight()/2 -80;
        lives = 3;
        speed = 0;
    }
    //These functions get variables for level to use
    public int getSpeed() {
        return speed;
    }
    
    public int getLives() {
        return lives;
    }
    
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
    
    public void move() {
        if ((y + speed + width + 35 < TurtleGun2.getLevelHeight()) && (y + speed > 0)) {
            y += speed;
        }
    }
}
