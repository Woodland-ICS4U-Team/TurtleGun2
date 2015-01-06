
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Turtle {
    private int STARTING_X = 300;
    private int speed = 0;
    private int distance; //distance from back narwhal
    private String turtleImage = "Turtle.png";
    private int width;
    private int height;
    private int x = STARTING_X;
    private int y = (TurtleGun2.getLevelHeight()/2) -80;
    private Image image;
    private int lives = 3;
    Level level;
    //image constructor for turtle    
    public Turtle() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(turtleImage));
        //turtleImage = (new ImageComponent("turtleImage.png"));
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
    //resets the variables after a new game is started
    public void reset() {
        x = STARTING_X;
        y = (TurtleGun2.getLevelHeight()/2) -80;
        lives = 3;
        speed = 0;
    }
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
    //Gets distance from narwhal
    public int getDistance() {
        return distance;
    }
    
    public void move() {
        if ((y + speed + width < TurtleGun2.getLevelHeight()) && (y + speed > 0)) {
            y += speed;
        }
    }
}
