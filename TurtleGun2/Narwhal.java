import java.awt.Image;
import javax.swing.ImageIcon;

public class Narwhal {
    private int distance;
    private String narwhalImage = "Narwhal.png";
    private int width;
    private int height;
    private int x = -75;
    private int y = 150;
    private double z = 0;
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
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getDistance() {
        return distance;
    }
    
    public void move() {
        y = (int)(260 * Math.sin(z)) + 250;
        z += .1;
    }
}
