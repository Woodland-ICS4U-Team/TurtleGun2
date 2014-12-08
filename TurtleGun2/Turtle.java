
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Turtle {
    
    private static int distance;
    private static Image turtleImage;
    private static int width;
    private static int height;
    private static int x = 100;
    private static int y = 100;
    
    
    public Turtle() {
        turtleImage = (new ImageComponent("turtleImage.png"));
        width = turtleImage.getWidth(null);
        height = turtleImage.getHeight(null);
     
    }
    
    public static Image getImage() {
        return turtleImage;
    }
    
    public static int getX() {
        return x;
    }
    
    public static int getY() {
        return y;
    }
    
    public static int getDistance() {
        return distance;
    }
    
    public static void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_SPACE) {
            System.out.println("Space pressed");
        } 
        if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("Left pressed");
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("Right pressed");
        }
    }
}
