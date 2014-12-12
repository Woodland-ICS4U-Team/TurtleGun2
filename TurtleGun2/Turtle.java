
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Turtle {
    
    private int distance;
    private String turtleImage = "turtleImage.png";
    private int width;
    private int height;
    private int x = 250;
    private int y = 260;
    private Image image;
    
    
    public Turtle() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(turtleImage));
        //turtleImage = (new ImageComponent("turtleImage.png"));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
     
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
    
    public int getDistance() {
        return distance;
    }
    
    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_SPACE) {
            System.out.println("Space pressed");
           
        } else if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("Up pressed");
            y = y + 10;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("Down pressed");
            y = y - 10;
        }
    }
}
