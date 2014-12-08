
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Turtle {
    
    private static int distance;
    private static String turtleImage = "turtleImage.png";
    private static int width;
    private static int height;
    private static int x = 400;
    private static int y = 150;
    private static Image image;
    
    
    public Turtle() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(turtleImage));
        //turtleImage = (new ImageComponent("turtleImage.png"));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
     
    }
    
    public static Image getImage() {
        return image;
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
        } 
        if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("Right pressed");
        }
    }
}
