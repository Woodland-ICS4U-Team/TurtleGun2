
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Turtle {
    private int STARTING_X = 200;
    private int distance;
    private int speed = 0;
    private String turtleImage = "Turtle.png";
    private int width;
    private int height;
    private int x = STARTING_X;
    private int y = TurtleGun2.getLevelHeight() / 2;
    private Image image;
    
    
    public Turtle() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(turtleImage));
        //turtleImage = (new ImageComponent("turtleImage.png"));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        y -= height / 2;
    }
    
    public void move() {
        y += speed;
    }
    
    public Image getImage() {
        return image;
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
    
    public int getDistance() {
        return distance;
    }
    
    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_SPACE) {
            System.out.println("Space pressed");
            
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
            System.out.println("Space pressed");
            
        } else if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("Up pressed");
            speed = 0;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("Down pressed");
            speed = 0;
        }
    }
}
