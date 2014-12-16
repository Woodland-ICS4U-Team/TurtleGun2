
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Turtle {
    private int STARTING_X = 200;
    private int speed = 0;
    private int distance; //distance from back narwhal
    private String turtleImage = "Turtle.png";
    private int width;
    private int height;
    private int x = STARTING_X;
    private int y = TurtleGun2.getLevelHeight() / 2;
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
    
    //Key listener to guide the turtle
    public void keyPressed(int keyCode, Level level) {
        if (keyCode == KeyEvent.VK_SPACE) {
            System.out.println("Space pressed");
            level.addPiranha(x + width / 2, y + height / 2);
        } else if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("Up pressed");
            speed = -10;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("Down pressed");
            speed = 10;
        }
    }
    
    public void keyReleased(int keyCode) {
        if (keyCode == KeyEvent.VK_SPACE) {

        } else if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("Up pressed");
            speed = 0;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("Down pressed");
            speed = 0;
        }
    }
}
