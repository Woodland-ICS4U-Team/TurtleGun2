
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Turtle {
    
    private int distance;
    private String turtleImage = "turtleImage.png";
    private int width;
    private int height;
    private int x = 400;
    private int y = 150;
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
        } 
        if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("Left pressed");
        } 
        if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("Right pressed");
        }
    }
}
